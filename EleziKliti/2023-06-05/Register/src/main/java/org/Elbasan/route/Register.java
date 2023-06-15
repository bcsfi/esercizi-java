package org.Elbasan.route;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.Elbasan.jdbc.ConnectionProvider;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

@WebServlet(name="This is a register page ", urlPatterns="/register")
public class Register extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        boolean status = false;

        try {

            ConnectionProvider driver = new ConnectionProvider("localhost","5053","postgres","postgres", "Astrorep");

            PreparedStatement statement = driver.getConnection().prepareStatement("INSERT INTO USER(user_name, user_email, user_password).VALUES(? ? ?)");

            statement.setString(1, email);
            statement.setString(2, username);
            statement.setString(3, password);

            if(statement.executeUpdate() == 1){
                status = true;
            }

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

        if(status){
            req.getRequestDispatcher("registerSuccessed.html").forward(req, resp);
        } else {
            req.getRequestDispatcher("registerSuccessed.html").forward(req, resp);
        }

    }

    private String createToken(){
        String Token += Math.floorMod();
    }
}
