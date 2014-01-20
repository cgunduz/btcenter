package com.cemgunduz.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.print.attribute.HashAttributeSet;

import com.google.gson.Gson;

public class RestResponse {

	private boolean success;
	private String errorDescription;
	private Map<String, String> data;
	
	private final String KEY_SEPERATOR_PREFIX = "__-_";
	
	private RestResponse()
	{
		data = new HashMap<String, String>();
	}

	public boolean isSuccess() {
		return success;
	}

	private void setSuccess(boolean success) {
		this.success = success;
	}

	public String getErrorDescription() {
		return errorDescription;
	}

	private void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}

	
	// TODO : DOES NOT WORK FOR KEY SEPERATOR PREFIX WITH SAME NAME
	public String getData(String... nestedKeys)
	{
		return getData(null, nestedKeys);
	}
	
	private String getData(List<String> keyChain, String... nestedKeys)
	{		
		if(nestedKeys == null || nestedKeys.length < 1)
			throw new UnsupportedOperationException("Nested Key length smaller than allowed");
		
		if(keyChain == null || keyChain.size() == 0)
			keyChain = calculateKeyChain(nestedKeys);
		
		String lastKey = keyChain.get(nestedKeys.length-1);
		if(!data.containsKey(lastKey))
		{
			String previousKeyAssociatedValue = getData((String[]) keyChain.subList(0, keyChain.size()-2).toArray());
			data.put(lastKey, lastKeyAssociatedValue);
		}
		
		return data.get(lastKey);
	}
	
	private List<String> calculateKeyChain(String... nestedKeys)
	{
		List<String> keyChain = new ArrayList<String>();
		keyChain.add(nestedKeys[0]);
		
		int keyNumber = 1;
		while(keyNumber < nestedKeys.length)
		{
			keyChain.add(keyChain.get(keyNumber-1) + KEY_SEPERATOR_PREFIX + nestedKeys[keyNumber]);
			keyNumber++;
		}
		
		return keyChain;
	}
	
	private String getDataByKey(String key)
	{
		return data.get(key);
	}
	
	private Map<String, String> getData() {
		return data;
	}
	
	private void setData(Map<String, String> map){
		this.data = map;
	}
	
	public static RestResponse createUnsuccessfulResponse(Exception e)
	{
		return createUnsuccessfulResponse(e.getMessage());
	}
	
	public static RestResponse createUnsuccessfulResponse(String reason)
	{
		RestResponse res = new RestResponse();
		res.setSuccess(false);
		res.setErrorDescription(reason);
		
		return res;
	}
	
	public static RestResponse createSuccessfulResponse(String jsonString)
	{
		Gson gson = new Gson();
		Map<String, String> jsonToDataMap = gson.fromJson(jsonString, Map.class);
		
		return createSuccessfulResponseByMap(jsonToDataMap);
	}
	
	private static RestResponse createSuccessfulResponseByMap(Map<String, String> jsonToDataMap)
	{
		RestResponse res = new RestResponse();
		res.setSuccess(true);
		res.setErrorDescription("Success");
		res.setData(jsonToDataMap);
		
		return res;
	}
}
