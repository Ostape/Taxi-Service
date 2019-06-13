package com.robosh.web.command.account.client;

import com.robosh.web.command.Command;
import com.robosh.web.command.RoutesJSP;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * return client account page
 *
 * @author Orest Shemelyuk
 */
public class ClientAccountCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return RoutesJSP.CLIENT_ACCOUNT;
    }
}
