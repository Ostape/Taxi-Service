package com.robosh.web.command.account;

import com.robosh.Utils.AppUtils;
import com.robosh.Utils.CookiesUtils;
import com.robosh.Utils.PriceVoyageUtils;
import com.robosh.Utils.TimeWaitTaxiUtil;
import com.robosh.web.command.Command;
import com.robosh.web.command.directions.ClientOrderCommand;
import com.robosh.model.entity.*;
import com.robosh.model.entity.enums.DriverStatus;
import com.robosh.service.AdressService;
import com.robosh.service.CouponService;
import com.robosh.service.DriverService;
import com.robosh.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EnterOrderCommand implements Command {

    private OrderService orderService;
    private DriverService driverService;
    private AdressService adressService;
    private CouponService couponService;
    private Command clientOrderCommand = new ClientOrderCommand();

    public EnterOrderCommand(OrderService orderService, DriverService driverService,
                             AdressService adressService, CouponService couponService) {
        this.orderService = orderService;
        this.driverService = driverService;
        this.adressService = adressService;
        this.couponService = couponService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        final String wrongDataRequest = clientOrderCommand.execute(request, response);
        final String addressDepartureStr = request.getParameter("addressDeparture");
        final String addressArriveStr = request.getParameter("addressArrive");
        final String carType = request.getParameter("carType");
        final String couponStr = request.getParameter("coupon");

        if (isNotSameAddress(addressDepartureStr, addressArriveStr)) {
            Driver driver = driverService.getDriverByCarTypeAndDriverStatus(DriverStatus.FREE, carType);
            if (driver != null){
                bookedDriver(driver);
                Client loginedClient = (Client) AppUtils.getLoginedUser(request.getSession());
                Adress addressDeparture = adressService.getAdressByAdressString(addressDepartureStr);
                Adress addressArrive = adressService.getAdressByAdressString(addressArriveStr);
                Coupon coupon = couponService.getCouponByName(couponStr);
                int costs = PriceVoyageUtils.getPriceDependDistance(addressArrive, addressDeparture);
                int costWithDiscount = PriceVoyageUtils.getPriceWithCoupon(costs, coupon);
                orderService.createOrderInDB(loginedClient, driver, addressDeparture, addressArrive,
                        coupon, costs, costWithDiscount);
                int timeWait = TimeWaitTaxiUtil.getTimeWait();
                CookiesUtils.addCookies(response, driver, costWithDiscount,timeWait);
                return "redirect#" + request.getContextPath() + "/taxi-Kyiv/showClientOrder";
            }else {
                return wrongDataRequest + "?noSuitableCarType=true";
            }
        }
        else {
            return wrongDataRequest + "?sameAddress=true";
        }
    }

    private void bookedDriver(Driver driver) {
        driver.setDriverStatus(DriverStatus.BOOKED);
        driverService.updateDriverStatus(driver);
    }

    //check if address is not same
    private boolean isNotSameAddress(String addressDeparture, String addressArrive) {
        return !addressArrive.equals(addressDeparture);
    }

}
