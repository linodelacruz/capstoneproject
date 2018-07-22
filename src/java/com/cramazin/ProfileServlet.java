
package com.cramazin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DataManager dataManager = (DataManager) getServletContext().getAttribute("dataManager");
        User user = (User)request.getSession().getAttribute("user");
        String username = user.getUsername();
        request.setAttribute("userPosts", dataManager.getAllPostsFromUser(username));
        
        UserProfile userprofile = dataManager.getUserProfile(username);
        request.setAttribute("userprofile", userprofile);
        request.getRequestDispatcher("/WEB-INF/views/profile.jsp").forward(request, response);
    }

   
}
