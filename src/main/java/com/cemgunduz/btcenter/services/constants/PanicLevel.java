package com.cemgunduz.btcenter.services.constants;

/**
 * Created by cgunduz on 2/5/14.
 */
public enum PanicLevel {

    EXTREME(5), VERY_HIGH(4), HIGH(3), MEDIOCRE(2), LOW(1), STAGNANT(0);

    private int value;

    private PanicLevel(int value)
    {
        this.value = value;
    }

    public int getValue()
    {
        return value;
    }
}
