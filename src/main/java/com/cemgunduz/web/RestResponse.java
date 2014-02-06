package com.cemgunduz.web;

import java.util.*;

import javax.print.attribute.HashAttributeSet;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;

public class RestResponse {

	private boolean success;
	private String errorDescription;
	private Map<String, Object> data;

	private static Gson GSON = new Gson();
	
	private RestResponse()
	{
		data = new HashMap<String, Object>();
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

	public Object getData(String... nestedKeys)
	{
		List<String> nestedKeysAsList = Arrays.asList(nestedKeys);
		return getData(nestedKeysAsList);
	}

	public Object getData(List<String> nestedKeys)
	{
        String firstKey = nestedKeys.get(0);
        if(!data.containsKey(firstKey))
            throw new IllegalArgumentException("Key not found");

        Object mapValue = data.get(firstKey);

        if(!(mapValue instanceof Map))
            return mapValue;

        String finalKey = nestedKeys.get(nestedKeys.size()-1);
        if(nestedKeys.size() > 2)
        {
            for(String nextKey : nestedKeys.subList(1,nestedKeys.size()-1))
            {
                Map<String,Object> tempMap = (Map)mapValue;
                mapValue = tempMap.get(nextKey);
            }
        }

        Map<String,Object> tempMap = (Map)mapValue;
        return tempMap.get(finalKey);
	}
	
	private Map<String, Object> getData() {
		return data;
	}
	
	private void setData(Map<String, Object> map){
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
        Map<String, Object> jsonToDataMap = GSON.fromJson(jsonString, Map.class);
		return createSuccessfulResponseByMap(jsonToDataMap);
	}
	
	private static RestResponse createSuccessfulResponseByMap(Map<String, Object> jsonToDataMap)
	{
		RestResponse res = new RestResponse();
		res.setSuccess(true);
		res.setErrorDescription("Success");
		res.setData(jsonToDataMap);
		
		return res;
	}
}
