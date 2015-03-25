package com.davidoladeji.park.service.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by Daveola on 2/22/2015.
 */
public class CustomNumber {

    public double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }


    public float percentage(int n, int total) {
        float proportion = ((float) n) / ((float) total);
        return proportion * 100;
    }

    public int percentageInt(int n, int total) {
        int proportion = 100 * ((n) / (total));
        return proportion;
    }
}
