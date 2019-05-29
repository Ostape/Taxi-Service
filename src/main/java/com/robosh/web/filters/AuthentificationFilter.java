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

import com.robosh.model.command.Utils.AppUtils;
import com.robosh.model.command.Utils.SecurityUtils;
import com.robosh.model.entity.Person;
import com.robosh.model.entity.enums.Role;

public class AuthentificationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        String pathInfo = request.getPathInfo();
        Person loginedPerson = AppUtils.getLoginedUser(request.getSession());

        //if ("/loginClient".equals(pathInfo) && loginedPerson != null){
        if ("/login".equals(pathInfo) && loginedPerson != null){
            if (loginedPerson.getRole().equals(Role.CLIENT)){
                response.sendRedirect(request.getContextPath() + "/taxi-Kyiv/clientAccount");
            }
            else {
                response.sendRedirect(request.getContextPath() + "/taxi-Kyiv/driverAccount");
            }
            return;
        }

        if (SecurityUtils.isSecurityPage(request)){
            if (loginedPerson != null && SecurityUtils.hasPermission(request, loginedPerson.getRole())){
                chain.doFilter(req,resp);
            }
            else {
                if("/makeOrder".equals(pathInfo)){
                //    response.sendRedirect(request.getContextPath() + "/taxi-Kyiv/loginClient");
                    response.sendRedirect(request.getContextPath() + "/taxi-Kyiv/login");
                }
                else {
                    System.out.println("helo");
                    response.sendRedirect(request.getContextPath() + "/taxi-Kyiv/403");
                }
            }
        }
        else {
            chain.doFilter(req,resp);
        }
    }

    @Override
    public void init(FilterConfig fConfig) {

    }
    @Override
    public void destroy() {
    }
}