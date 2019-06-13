package com.robosh.web.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.robosh.model.entity.Person;
import com.robosh.model.entity.enums.Role;
import com.robosh.myUtils.LoginedUserUtils;
import com.robosh.myUtils.SecurityUtils;

import static com.robosh.web.command.PathCommand.*;

public class AuthenticationFilter implements Filter {

    @Override
    public void init(FilterConfig fConfig) {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        String pathInfo = request.getPathInfo();
        String contextAndServletPath = request.getContextPath() + request.getServletPath();
        Person loginedPerson = LoginedUserUtils.getLoginedUser(request.getSession());

        if ((LOGIN_PAGE.equals(pathInfo) || REGISTER_CLIENT.equals(pathInfo)) && loginedPerson != null) {
            if (loginedPerson.getRole().equals(Role.CLIENT)) {
                response.sendRedirect(contextAndServletPath + CLIENT_ACCOUNT);
            } else {
                response.sendRedirect(contextAndServletPath + DRIVER_ACCOUNT);
            }
            return;
        }

        if (SecurityUtils.isSecurityPage(request)) {
            if (loginedPerson != null && SecurityUtils.hasPermission(request, loginedPerson.getRole())) {
                chain.doFilter(req, resp);
            } else {
                if (MAKE_ORDER.equals(pathInfo)) {
                    response.sendRedirect(contextAndServletPath + LOGIN_PAGE);
                } else {
                    response.sendRedirect(contextAndServletPath + FORBIDDEN);
                }
            }
        } else {
            chain.doFilter(req, resp);
        }
    }

    @Override
    public void destroy() {
    }
}