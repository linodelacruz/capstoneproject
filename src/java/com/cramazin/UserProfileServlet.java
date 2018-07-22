
package com.cramazin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/userprofile")
public class UserProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DataManager dataManager = (DataManager) getServletContext().getAttribute("dataManager");
        String username = request.getParameter("username");
        System.out.println("username:  "+ username);
        
        UserProfile globaluserprofile = dataManager.getGlobalUserProfile(username);
        request.setAttribute("globaluserprofile", globaluserprofile);
        request.getRequestDispatcher("/WEB-INF/views/userprofile.jsp").forward(request, response);
    }

    
}
