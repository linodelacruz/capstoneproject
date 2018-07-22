
package com.cramazin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/picturepost")
public class PicturePostServlet extends HttpServlet {
@Override

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DataManager manager = (DataManager) getServletContext().getAttribute("dataManager");
        Integer id = Integer.parseInt(request.getParameter("id"));
        ImageInfo postedimage = manager.postImageInfoBy(id);
        if (postedimage != null) {
            response.setStatus(200);
	    response.setContentType(postedimage.getContentType());
            manager.copyPostImageContent(id, response.getOutputStream());
        } else {
            response.sendError(404);
        }
    }
  
}
