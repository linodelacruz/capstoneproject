
package com.cramazin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/profileimage")
public class ProfileImageDownloadServlet extends HttpServlet {

    @Override

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DataManager manager = (DataManager) getServletContext().getAttribute("dataManager");
        Integer id = Integer.parseInt(request.getParameter("id"));
        ImageInfo image = manager.profileImageInfoBy(id);
        if (image != null) {
            response.setStatus(200);
	    response.setContentType(image.getContentType());
            manager.copyProfileImageContent(id, response.getOutputStream());
        } else {
            response.sendError(404);
        }
    }
}