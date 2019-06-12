package com.robosh.web.command.common;

import com.robosh.web.command.Command;
import com.robosh.web.command.RoutesJSP;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * return error page 403 forbidden
 *
 * @author Orest Shemelyuk
 */
public class ErrorForbiddenCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return RoutesJSP.HTTP_FORBIDDEN;
    }
}
