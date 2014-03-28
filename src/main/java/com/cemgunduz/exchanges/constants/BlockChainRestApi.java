package com.cemgunduz.exchanges.constants;

public enum BlockChainRestApi {

	GET_BITSTAMP_BITCOIN_VALUE("http://blockchain.info/ticker"), 
	CONVERT_DOLLAR_TO_BITSTAMP("http://blockchain.info/tobtc"); 
	
	private String url;
	
	private BlockChainRestApi(String url)
	{
		this.url = url;
	}
	
	public String getUrl()
	{
		return url;
	}
}
