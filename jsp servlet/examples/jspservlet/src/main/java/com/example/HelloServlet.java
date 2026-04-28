package com.example;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/firstservlet")
public class HelloServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException {
        System.out.println("Servlet HIT");
        res.setContentType("text/html");

        String name = req.getParameter("username");
        String password = req.getParameter("password");

        PrintWriter writer = res.getWriter();

        writer.println("<h2>Login Success</h2>");
        writer.println("Username: " + name + "<br>");
        writer.println("Password: " + password);
    }
}