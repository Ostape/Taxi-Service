package com.robosh.web.filters;

import java.io.IOException;


import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
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
        ////////
//        System.out.println("path info: " + pathInfo);
//        if (loginedPerson != null){
//            System.out.println(loginedPerson.getName());
//        }else {
//            System.out.println("not logged");
//        }
        ///////
        if ("/loginClient".equals(pathInfo) && loginedPerson != null){
//            System.out.println("i am logined!!!!\n");
//            System.out.println("request context path = " + request.getContextPath());
            response.sendRedirect(request.getContextPath() + "/taxi-Kyiv/clientAccount");
            //chain.doFilter(req, resp);
            return;
        }

        if (SecurityUtils.isSecurityPage(request)){
            if (loginedPerson != null && SecurityUtils.hasPermission(request, loginedPerson.getRole())){
            //    System.out.println("yey i`m in sec page");
                chain.doFilter(req,resp);
            }
            else {
                //System.out.println("no, i`m not");
                response.sendRedirect(request.getContextPath() + "/403");
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