
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
@WebServlet("/updateprofile")
public class UpdateProfileServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            User user = (User)request.getSession().getAttribute("user");
            String username = user.getUsername();
            String firstname = request.getParameter("firstname");
            String lastname = request.getParameter("lastname");
            String zipc = request.getParameter("zipcode");
            String aboutuser = request.getParameter("aboutme");
            Part profileimagepart = request.getPart("profileimage");
            Part coverimagepart = request.getPart("coverimage");
                if (profileimagepart != null && coverimagepart !=null) {
                    DataManager dataManager = (DataManager) getServletContext().getAttribute("dataManager");                  
                    InputStream profileImageStream = null;
                    InputStream coverImageStream = null;
                    try {
                        String profileImageFileName = profileimagepart.getSubmittedFileName();
                        String profileImageContentType = profileimagepart.getContentType();
                        profileImageStream = profileimagepart.getInputStream();
                        String coverImageFileName = coverimagepart.getSubmittedFileName();
                        String coverImageContentType = coverimagepart.getContentType();
                        coverImageStream = coverimagepart.getInputStream();
                        int zipcode = Integer.parseInt(zipc);
                        int profileimageid = dataManager.updateProfileImage(profileImageFileName, profileImageContentType, profileImageStream);
                        int coverimageid = dataManager.updateCoverImage(coverImageFileName, coverImageContentType,coverImageStream);
                        
                        dataManager.updateUserProfile(username, firstname, lastname, zipcode, aboutuser, profileimageid, coverimageid);
                        dataManager.updateUser(username, firstname, lastname, profileimageid);
                    } finally {
                        if (profileImageStream != null) {
                            try {
                                profileImageStream.close();
                                coverImageStream.close();
                            } catch (IOException ignored) {
                            }
                        }
                    }

                }
 
            if (user == null) {
                request.setAttribute("flash", "Unable to update, Verify your information again");
                request.getRequestDispatcher("/WEB-INF/views/profile.jsp").forward(request, response);
            } else {                
                response.sendRedirect("/cramazin/profile");
            }
        }
    }
            
    


