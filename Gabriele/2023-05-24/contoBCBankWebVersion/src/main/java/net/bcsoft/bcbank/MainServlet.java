package net.bcsoft.bcbank;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.bcsoft.bcbank.util.Program;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Report", urlPatterns = "/report")
public class MainServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/plain");
        PrintWriter writer = response.getWriter();
        writer.println(Program.start());
        writer.flush();
    }
}
