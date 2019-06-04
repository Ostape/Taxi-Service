package com.robosh;

import com.robosh.Utils.PriceVoyageUtils;
import com.robosh.Utils.TimeWaitTaxiUtil;
import com.robosh.model.entity.*;
import com.robosh.model.entity.enums.OrderStatus;
import com.robosh.service.*;

class Main{
    public static void main(String[] args) {
        System.out.println(TimeWaitTaxiUtil.getTimeWait());
    }

}
