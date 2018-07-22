
package com.cramazin;

import java.io.IOException;
import java.io.InputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig(maxFileSize=16177215)
@WebServlet("/userpost")
public class UserPostServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       if (request.getSession().getAttribute("user") == null) {
            request.getRequestDispatcher("/WEB-INF/views/home.jsp");
        }
        if (request.getMethod().equalsIgnoreCase("GET")) {
            request.getRequestDispatcher("/WEB-INF/views/profile.jsp").forward(request, response);
        } else {
            User user = (User) request.getSession().getAttribute("user");
            String username = user.getUsername();
            String postedtext = request.getParameter("postedtext");
            Part part = request.getPart("postedimage");
            UserPost post = null;
            if (part != null) {
                    DataManager dataManager = (DataManager) getServletContext().getAttribute("dataManager");                  
                    InputStream imageStream = null;
                    try {
                        String fileName = part.getSubmittedFileName();
                        String contentType = part.getContentType();
                        imageStream = part.getInputStream();
                        int postedimageid = dataManager.savePostedImage(fileName, contentType, imageStream);
                        System.out.println("information passed: "+ "image id" + postedimageid + "posted text"+ postedtext + "user"+username);
                        post = dataManager.savePost(username, postedimageid, postedtext);  
                    } finally {
                        if (imageStream != null) {
                            try {
                                imageStream.close();
                            } catch (IOException ignored) {}
                        }
                    }            
                }   
                request.setAttribute("post", post);
                response.sendRedirect("/cramazin/profile");
            }
    }
}
