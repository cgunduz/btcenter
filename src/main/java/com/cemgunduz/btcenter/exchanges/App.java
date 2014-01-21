package com.cemgunduz.btcenter.exchanges;

import com.cemgunduz.web.RestResponse;

/**
 * Created by cgunduz on 1/21/14.
 */
public class App {

    public static void main(String[] args)
    {
        BlockChain blockChain = new BlockChain();
        BtcTurk btcTurk = new BtcTurk();

        RestResponse response1 = blockChain.getBitstampBtcValueForCurrencies();
        RestResponse response2 = btcTurk.getTicker();
        RestResponse response3 = btcTurk.getOrderbook();

        System.out.println(response1.getData("USD" , "buy"));
        System.out.println(response2.getData("bid"));
        System.out.println(response3.getData("asks"));
    }
}
