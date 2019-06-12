package com.robosh.web.command;

import static com.robosh.web.command.PathCommand.*;

public interface RedirectPath {
    String REDIRECT = "redirect#";
    String SERVLET_PATH = "/Taxi_Service_war_exploded/taxi-Kyiv/";

    String REDIRECT_CLIENT_ACCOUNT =REDIRECT + SERVLET_PATH + CLIENT_ACCOUNT;
    String REDIRECT_DRIVER_ACCOUNT =REDIRECT + SERVLET_PATH + DRIVER_ACCOUNT;
    String REDIRECT_SHOW_CLIENT_ORDER = REDIRECT + SERVLET_PATH + SHOW_CLIENT_ORDER;
    String REDIRECT_LOGIN = REDIRECT + SERVLET_PATH + LOGIN_PAGE;
    String REDIRECT_HOME_PAGE = REDIRECT + SERVLET_PATH + HOME_PAGE;
}
