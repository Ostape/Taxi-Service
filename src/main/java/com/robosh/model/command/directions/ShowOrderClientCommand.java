package com.robosh.model.command.directions;

import com.robosh.Utils.CookiesUtils;
import com.robosh.model.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ShowOrderClientCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String driverName = CookiesUtils.readCookie(request, CookiesUtils.DRIVER_NAME);
        String phoneNumber = CookiesUtils.readCookie(request, CookiesUtils.DRIVER_PHONE);
        String priceVoyage = CookiesUtils.readCookie(request, CookiesUtils.PRICE_VOYAGE);
        String timeWait = CookiesUtils.readCookie(request, CookiesUtils.TIME_WAIT);

        System.out.println(driverName);
        request.setAttribute(CookiesUtils.DRIVER_NAME, driverName);
        request.setAttribute(CookiesUtils.DRIVER_PHONE, phoneNumber);
        request.setAttribute(CookiesUtils.PRICE_VOYAGE, priceVoyage);
        request.setAttribute(CookiesUtils.TIME_WAIT, timeWait);
        return "/jsp/accountClient/orderStatus.jsp";
    }
}