package com.robosh.Utils;

import com.robosh.model.entity.Adress;
import com.robosh.model.entity.Coupon;

public class OrderUtils {
    private static final double START_PRICE = 30.0;

    private OrderUtils() {
    }

    public static int calculatePriceDependDistance(Adress adressArrive, Adress adressDeparture) {
        double arriveStreetPrice = getStreetPrice(adressArrive.getStreet());
        double departureStreetPrice = getStreetPrice(adressDeparture.getStreet());
        double arriveHouseNumberPrice = getHouseNumberPrice(adressArrive.getHouseNumber());
        double departureHouseNumberPrice = getHouseNumberPrice(adressDeparture.getHouseNumber());

        int totalPriceWithoutDiscount = (int) (START_PRICE + (arriveHouseNumberPrice + departureHouseNumberPrice
                        + arriveStreetPrice + departureStreetPrice)/2 + getPriceWeather());
        return totalPriceWithoutDiscount;
    }

    private static double getHouseNumberPrice(String houseNumber) {
        if (houseNumber.contains("/")) {
            houseNumber = houseNumber.replace("/", ".");
        }
        return new Double(houseNumber);
    }

    private static double getStreetPrice(String street) {
        return (double) street.charAt(0) / 10.0;
    }

    private static int getPriceWeather(){
        return (int)(Math.random() * 100);
    }

    private static int getPriceWithCoupon(Adress adressArrive, Adress adressDeparture, Coupon coupon) {
        int discountPercents = coupon.getDiscount();
        int priceWithoutDiscount = calculatePriceDependDistance(adressArrive, adressDeparture);
        return priceWithoutDiscount * (discountPercents / 100) + priceWithoutDiscount;
    }
}
