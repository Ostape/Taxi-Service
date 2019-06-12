package com.robosh.web.command.account.client;


import com.robosh.myUtils.CookiesUtils;
import com.robosh.myUtils.LoginedUserUtils;
import com.robosh.myUtils.PriceVoyageUtils;
import com.robosh.myUtils.TimeWaitTaxiUtil;
import com.robosh.web.command.Command;
import com.robosh.model.entity.*;
import com.robosh.model.entity.enums.DriverStatus;
import com.robosh.service.AddressService;
import com.robosh.service.CouponService;
import com.robosh.service.DriverService;
import com.robosh.service.OrderService;
import com.robosh.web.command.RedirectPath;
import com.robosh.web.command.RoutesJSP;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * class that takes parameter from order and process them
 *
 * @author Orest Shemelyuk
 */
public class EnterOrderCommand implements Command {
    private static final String ADDRESS_DEPARTURE_PARAMETER = "addressDeparture";
    private static final String ADDRESS_ARRIVE_PARAMETER = "addressArrive";
    private static final String CAR_TYPE_PARAMETER = "carType";
    private static final String COUPON_PARAMETER = "coupon";
    private static final String NO_SUCH_CAR = "?noSuitableCarType=true";
    private static final String SAME_ADDRESS = "?sameAddress=true";


    private OrderService orderService;
    private DriverService driverService;
    private AddressService addressService;
    private CouponService couponService;

    public EnterOrderCommand(OrderService orderService, DriverService driverService,
                             AddressService addressService, CouponService couponService) {
        this.orderService = orderService;
        this.driverService = driverService;
        this.addressService = addressService;
        this.couponService = couponService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        final String addressDepartureStr = request.getParameter(ADDRESS_DEPARTURE_PARAMETER);
        final String addressArriveStr = request.getParameter(ADDRESS_ARRIVE_PARAMETER);
        final String carType = request.getParameter(CAR_TYPE_PARAMETER);
        final String couponStr = request.getParameter(COUPON_PARAMETER);

        if (isNotSameAddress(addressDepartureStr, addressArriveStr)) {
            Driver driver = driverService.getDriverByCarTypeAndDriverStatus(DriverStatus.FREE, carType);
            if (driver != null) {
                bookedDriver(driver);
                Client loginedClient = (Client) LoginedUserUtils.getLoginedUser(request.getSession());
                Address addressDeparture = addressService.getAdressByAdressString(addressDepartureStr);
                Address addressArrive = addressService.getAdressByAdressString(addressArriveStr);
                Coupon coupon = couponService.getCouponByName(couponStr);
                int costs = PriceVoyageUtils.getPriceDependDistance(addressArrive, addressDeparture);
                int costWithDiscount = PriceVoyageUtils.getPriceWithCoupon(costs, coupon);
                orderService.createOrderInDB(loginedClient, driver, addressDeparture, addressArrive,
                        coupon, costs, costWithDiscount);
                int timeWait = TimeWaitTaxiUtil.getTimeWait();
                CookiesUtils.addCookies(response, driver, costWithDiscount, timeWait);
                return RedirectPath.REDIRECT_SHOW_CLIENT_ORDER;
            } else {
                return RoutesJSP.TAXI_ORDER + NO_SUCH_CAR;
            }
        } else {
            return RoutesJSP.TAXI_ORDER + SAME_ADDRESS;
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
