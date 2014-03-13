package com.cemgunduz.utils.impl;

import java.io.IOException;

import com.cemgunduz.utils.entity.RestResponse;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.springframework.stereotype.Component;

@Component
public class WebUtilsImpl {
	
	public Document getScrapableDocument(String url)
	{
		try {
			Document doc = Jsoup.connect(url).get();
			return doc;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
	public RestResponse getRestResponse(String url)
	{	
		String jsonString;
		try
		{
			Client client = Client.create();
			
			WebResource webResource = client.resource(url);
			 
			ClientResponse response = webResource.accept("application/json")
					.get(ClientResponse.class);
			 
			if (response.getStatus() != 200) {
			
				return RestResponse.createUnsuccessfulResponse(response.getStatusInfo().getReasonPhrase());
			}
			 
			jsonString = response.getEntity(String.class);
		}
		catch(Exception e)
		{
			return RestResponse.createUnsuccessfulResponse(e);
		}
		
		return RestResponse.createSuccessfulResponse(jsonString);
	}
}

