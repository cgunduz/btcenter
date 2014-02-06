package com.cemgunduz.btcenter.services.constants;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by cgunduz on 2/6/14.
 */
public class BtcenterServiceSettings {

    public final static Double WALL_QUALIFIER_RATIO;
    public final static Double MAX_BUY_RATING;
    public final static Double MAX_SELL_RATING;
    public final static Integer DEFAULT_ORDERBOOK_DEPTH;

    static
    {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("settings.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        WALL_QUALIFIER_RATIO = (Double)properties.get("WALL_QUALIFIER_RATIO");
        MAX_BUY_RATING = (Double)properties.get("WALL_QUALIFIER_RATIO");
        MAX_SELL_RATING = (Double)properties.get("MAX_SELL_RATING");
        DEFAULT_ORDERBOOK_DEPTH = (Integer)properties.get("DEFAULT_ORDERBOOK_DEPTH");
    }
}
