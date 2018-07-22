
package com.cramazin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") != null)
            request.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(request, response);
        else {
            DataManager users = (DataManager) getServletContext().getAttribute("dataManager");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            System.out.println("the password is " + password);
            User user = users.authenticate(email, password);
            if (user == null) {
                request.setAttribute("flash", "Incorrect info entered, verify and try again!");
                request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
            } else {
                
                request.getSession().setAttribute("user", user);
                response.sendRedirect("/cramazin/");
            }
        }
    }
    
    
}
