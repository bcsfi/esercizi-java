package org.bcbank.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.bcbank.ProgramManage;
import org.bcbank.model.Risultati;
import org.bcbank.teamplates.HtmlTable;

import java.io.*;
import java.util.List;


@WebServlet(name="dati", urlPatterns = "/datielaborati")
public class DatiElaborati extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {


        response.setContentType("text/html");
        ProgramManage manager = new ProgramManage();
        List<Risultati> elencoRisultati = manager.getListaRisultati();


        System.out.print(request.getRequestURL() + "questo url ha ricevuto una richiesta. \n");
        System.out.print(request.getRemoteAddr() + "Questo di ha seguito una  richiesta. \n");


        String htmlResult = HtmlTable.createHtmlTable(elencoRisultati);

        PrintWriter writer = response.getWriter();
        writer.println(htmlResult);
    }
}
