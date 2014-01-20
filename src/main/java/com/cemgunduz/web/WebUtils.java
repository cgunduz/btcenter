package com.cemgunduz.web;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class WebUtils {
	
	public static Document getScrapableDocument(String url)
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
	
	public static RestResponse getRestResponse(String url)
	{	
		String jsonString = "";
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
			System.out.println(jsonString);
			
			
		}
		catch(Exception e)
		{
			return RestResponse.createUnsuccessfulResponse(e);
		}
		
		return RestResponse.createSuccessfulResponse(jsonString);
	}
 
}

