package site.op;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import site.dao.*;
import site.model.*;

@WebServlet("/insertcomment")
public class insertcomment extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CommentDao commentdao;

    public void init() {
        commentdao = new CommentDaoImpl();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String id = request.getParameter("postId");
        System.out.println(id + "id" + id);
        long postId = Integer.parseInt(id);
        String name = request.getParameter("name");
        String content = request.getParameter("content");

        Comment newComment = new Comment(postId, name, content);
        commentdao.insertComment(newComment);

        response.sendRedirect(request.getContextPath() + "/singlepost?id=" + id + "");
        System.out.println("after");

    }

}
