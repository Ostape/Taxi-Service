package com.robosh.web.command.common;

import com.robosh.web.command.Command;
import com.robosh.web.command.RoutesJSP;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * return driver account
 *
 * @author Orest Shemelyuk
 */
public class DriverAccountCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return RoutesJSP.DRIVER_ACCOUNT;
    }
}
