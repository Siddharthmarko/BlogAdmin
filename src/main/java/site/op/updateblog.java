package site.op;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import site.dao.*;
import site.model.*;
import site.web.*;

@WebServlet("/updateblog")
public class updateblog extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private BlogPostDao blogPostDAO;

    public void init() {
        blogPostDAO = new BlogPostDaoImpl();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String id = request.getParameter("id");
        long postId = Integer.parseInt(id);

        String title = request.getParameter("title");
        String user = LoginController.usekaro;
        String author = request.getParameter("author");
        String Category = request.getParameter("Category");
        String Content = request.getParameter("Content");

        BlogPost newBlogPost = new BlogPost(postId, title, Content, user, author, Category);

        try {
            blogPostDAO.updateBlogPost(newBlogPost);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        response.sendRedirect(request.getContextPath() + "/backend/index.jsp");
    }

}
