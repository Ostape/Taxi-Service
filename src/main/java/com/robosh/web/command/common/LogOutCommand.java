package com.robosh.web.command.common;

import com.robosh.web.command.Command;
import com.robosh.web.command.PathCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * destroy session adn logout from account
 *
 * @author Orest Shemelyuk
 */
public class LogOutCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        session.invalidate();
        String contextAndServletPath = request.getContextPath() + request.getServletPath();
        return PathCommand.REDIRECT + contextAndServletPath + PathCommand.HOME_PAGE;
    }
}
