package com.robosh.web.command.common;

import com.robosh.web.command.Command;
import com.robosh.web.command.RoutesJSP;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * return home page jsp
 *
 * @author Orest Shemelyuk
 */
public class TaxiHomeCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return RoutesJSP.TAXI_HOME;
    }
}
