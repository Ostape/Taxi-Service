package com.robosh.web;

import com.robosh.model.entity.Client;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class StudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean jstl= Boolean.getBoolean(req.getParameter("jstl"));
        List<Client> clientList=  new ArrayList<>();
        Client client = new Client();
        PrintWriter writer = resp.getWriter();
        writer.print("sdsdsd");
        String surname = "Яко";
        String name = "Анд";
        String middleName = "Олекса";
        String phoneNumber = "+380967825532";
        String mail = "roenko_olexandr@gmail.com";
        String pass = "and12";
        client.setUserId(22);
        client.setSurname(surname);
       client.setName(name);
        client.setMiddleName(middleName);
        client.setPhoneNumber(phoneNumber);
        client.setEmail(mail);
        client.setPassword(pass);
        clientList.add(client);
        req.setAttribute("clients", clientList);
        writer.print("ssad");
        if (!jstl){
            writer.print("sssss");
            req.getRequestDispatcher("client-no-jstl.jsp");
        }
        else{
            req.getRequestDispatcher("clients.jsp");
        }
    }
}
