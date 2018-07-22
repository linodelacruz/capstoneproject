
package com.cramazin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("")
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DataManager dataManager = (DataManager) getServletContext().getAttribute("dataManager");
        request.setAttribute("posts", dataManager.getAllPosts());
        request.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(request, response);
    }

}
