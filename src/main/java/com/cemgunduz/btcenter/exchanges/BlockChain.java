package com.cemgunduz.btcenter.exchanges;

import java.util.HashMap;
import java.util.Map;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.cemgunduz.btcenter.exchanges.constants.BlockChainRestApi;
import com.cemgunduz.web.RestResponse;
import com.cemgunduz.web.WebUtils;

public class BlockChain {
	
	public static void main(String[] args) {
		
		BlockChain bc = new BlockChain();
		RestResponse response = bc.getBitstampBtcValueForCurrencies();
		
		System.out.println(response.getData("USD", "15m"));
	}
	
	public RestResponse getBitstampBtcValueForCurrencies()
	{
		String apiUrl = BlockChainRestApi.GET_BITSTAMP_BITCOIN_VALUE.getUrl();
		RestResponse response = WebUtils.getRestResponse(apiUrl);
		
		return response;
	}
}
