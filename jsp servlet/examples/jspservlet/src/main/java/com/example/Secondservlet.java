package com.example;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.*;

@WebServlet("/secondservlet")
public class Secondservlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {

        System.out.println("control in second servlet");

        // get data sent from third servlet
        String msg = (String) req.getAttribute("msg");

        PrintWriter out = res.getWriter();
        out.println("<h1>Inside Second Servlet</h1>");
        out.println("<p>Message from Third Servlet: " + msg + "</p>");
    }
}