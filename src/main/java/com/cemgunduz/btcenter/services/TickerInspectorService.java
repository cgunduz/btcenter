package com.cemgunduz.btcenter.services;

import com.cemgunduz.btcenter.services.constants.PanicLevel;

/**
 * Created by cgunduz on 2/5/14.
 */
public interface TickerInspectorService {

    PanicLevel detectSuddenDecrease();
}
