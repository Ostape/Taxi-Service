package com.robosh.Utils;

public class TimeWaitTaxiUtil {
    private TimeWaitTaxiUtil(){}

    public static int getTimeWait(){
        return (int) (Math.random() * 10);
    }
}