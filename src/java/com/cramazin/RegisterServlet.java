
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
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User)request.getSession().getAttribute("user");
        if (request.getSession().getAttribute("user") != null) {
            request.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(request, response);
        } else {

            
            String email = request.getParameter("email");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String password1 = request.getParameter("password1");
            String firstname = request.getParameter("firstname");
            String lastname = request.getParameter("lastname");
            Part part = request.getPart("profileimage");
                        
            if (part != null) {
                    DataManager dataManager = (DataManager) getServletContext().getAttribute("dataManager");                  
                    InputStream imageStream = null;
                    try {
                        
                        String fileName = part.getSubmittedFileName();
                        String contentType = part.getContentType();
                        imageStream = part.getInputStream();
                        int profileimageid = dataManager.saveProfileImage(fileName, contentType, imageStream);
                        
                        user = dataManager.registerUser(email, username, password, password1, firstname, lastname,profileimageid);
                        
                    } finally {
                        if (imageStream != null) {
                            try {
                                imageStream.close();
                            } catch (IOException ignored) {
                            }
                        }
                    }

                }
 
            if (user == null) {
                request.setAttribute("flash", "Unable to register, Verify your that your passwords match");
                request.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(request, response);
            } else {
                
                request.getSession().setAttribute("user", user);
                System.out.println("this is the user created" + user);
                response.sendRedirect("/cramazin/");
            }
        }
    }
}
