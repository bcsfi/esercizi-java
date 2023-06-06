package org.BCVinaiano.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="questa e' la home!", urlPatterns="/home")
public class RouteHome extends HttpServlet {
    public void doGet (HttpServletRequest richieste, HttpServletResponse risposta) throws IOException {
        PrintWriter printer = risposta.getWriter();
        printer.print("");
    }
}
