package com.example;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/thirdservlet")
public class Thirdservlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {

        System.out.println("control in third servlet");

        RequestDispatcher reqdispatch = req.getRequestDispatcher("/secondservlet");
        reqdispatch.forward(req, res);

        PrintWriter writer = res.getWriter();
        writer.println("<h1> response from servlet third </h1>");
    }
}