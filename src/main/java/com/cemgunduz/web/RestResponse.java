package com.cemgunduz.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.print.attribute.HashAttributeSet;

import com.google.gson.Gson;

public class RestResponse {

	private boolean success;
	private String errorDescription;
	private Map<String, String> data;
	
	private static Gson GSON;
	
	private final String KEY_SEPERATOR_PREFIX = "__-_";
	
	private RestResponse()
	{
		data = new HashMap<String, String>();
		GSON = new Gson();
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

	public String getData(String... nestedKeys)
	{
		List<String> nestedKeysAsList = Arrays.asList(nestedKeys);
		return getData(null, nestedKeysAsList);
	}
	
	// TODO : DOES NOT WORK FOR KEY SEPERATOR PREFIX WITH SAME NAME
	public String getData(List<String> nestedKeys)
	{
		return getData(null, nestedKeys);
	}
	
	private String getData(List<String> keyChain, List<String> nestedKeys)
	{		
		if(nestedKeys == null || nestedKeys.size() < 1)
			throw new UnsupportedOperationException("Nested Key length smaller than allowed");
		
		if(keyChain == null || keyChain.size() == 0)
			keyChain = calculateKeyChain(nestedKeys);
		
		String lastKey = keyChain.get(keyChain.size()-1);
		if(!data.containsKey(lastKey))
		{
			String previousKeyAssociatedValue = getData(keyChain.subList(0, keyChain.size()-2), 
					nestedKeys.subList(0, nestedKeys.size()-1));
			Map<String, String> jsonToDataMap = GSON.fromJson(previousKeyAssociatedValue, Map.class);
			if(!jsonToDataMap.containsKey(nestedKeys.get(nestedKeys.size()-1)))
				throw new UnsupportedOperationException("No such key is found.");
			
			data.put(lastKey, jsonToDataMap.get(nestedKeys.get(nestedKeys.size()-1)));
		}
		
		return data.get(lastKey);
	}
	
	private List<String> calculateKeyChain(List<String> nestedKeys)
	{
		List<String> keyChain = new ArrayList<String>();
		keyChain.add(nestedKeys.get(0));
		
		int keyNumber = 1;
		while(keyNumber < nestedKeys.size())
		{
			keyChain.add(keyChain.get(keyNumber-1) + KEY_SEPERATOR_PREFIX + nestedKeys.get(keyNumber));
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
		Map<String, String> jsonToDataMap = GSON.fromJson(jsonString, Map.class);
		
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
