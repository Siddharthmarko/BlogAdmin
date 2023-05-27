package site.op;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import site.dao.*;

@WebServlet(urlPatterns = "/deletecomment", name = "deletecomment")
public class deletecomment extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CommentDao commentDAO;

    public void init() {
        commentDAO = new CommentDaoImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve the ID parameter from the request
        String id = request.getParameter("id");

        // Perform the delete operation based on the ID
        if (id != null) {
            int postId = Integer.parseInt(id);
            commentDAO.deleteComment(postId);
            System.out.println("Deleted blog post with ID: " + id);
        }

        // Redirect back to the desired page after deleting
        response.sendRedirect(request.getContextPath() + "/backend/comment.jsp");
    }
}