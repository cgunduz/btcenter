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
	
	public RestResponse getBitstampBtcValueForCurrencies()
	{
		return WebUtils.getRestResponse(
                BlockChainRestApi.GET_BITSTAMP_BITCOIN_VALUE.getUrl());
	}
}
