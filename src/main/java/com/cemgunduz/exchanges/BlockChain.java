package com.cemgunduz.exchanges;

import com.cemgunduz.exchanges.constants.BlockChainRestApi;
import com.cemgunduz.utils.entity.RestResponse;
import com.cemgunduz.utils.impl.WebUtilsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BlockChain {

    @Autowired
    WebUtilsImpl webUtils;

	public RestResponse getBitstampBtcValueForCurrencies()
	{
		return webUtils.getRestResponse(
                BlockChainRestApi.GET_BITSTAMP_BITCOIN_VALUE.getUrl());
	}
}
