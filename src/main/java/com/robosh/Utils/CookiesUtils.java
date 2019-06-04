package com.robosh.Utils;

import com.robosh.model.entity.Driver;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.stream.Stream;

public class CookiesUtils {
    public static final String DRIVER_NAME = "driverName";
    public static final String DRIVER_PHONE = "phoneNumber";
    public static final String PRICE_VOYAGE = "priceVoyage";
    public static final String TIME_WAIT = "timeWait";

    private CookiesUtils() {}

    public static String readCookie(HttpServletRequest request, String key) throws UnsupportedEncodingException {
        Cookie[] cookies = request.getCookies();
        for (Cookie c : cookies) {
            if (key.equals(c.getName())) {
                return URLDecoder.decode(c.getValue(), "UTF-8");
            }
        }
        return null;
    }

    public static void addCookies(HttpServletResponse response,
                                  Driver driver, int price, int timeWait) throws UnsupportedEncodingException {
        String safeName = URLEncoder.encode(driver.getName(), "UTF-8");
        String phoneDriver = driver.getPhoneNumber();
        String priceStr = price + "";
        String timeWaitStr = timeWait + "";

        Cookie driverNameCookie = new Cookie(CookiesUtils.DRIVER_NAME, safeName);
        Cookie phoneNumberCookie = new Cookie(CookiesUtils.DRIVER_PHONE, phoneDriver);
        Cookie priceCookie = new Cookie(CookiesUtils.PRICE_VOYAGE, priceStr);
        Cookie timeWaitCookie = new Cookie(CookiesUtils.TIME_WAIT, timeWaitStr);

        driverNameCookie.setMaxAge(-1);
        phoneNumberCookie.setMaxAge(-1);
        priceCookie.setMaxAge(-1);
        timeWaitCookie.setMaxAge(-1);

        response.addCookie(driverNameCookie);
        response.addCookie(phoneNumberCookie);
        response.addCookie(priceCookie);
        response.addCookie(timeWaitCookie);
    }


}
