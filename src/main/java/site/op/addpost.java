package site.op;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import site.dao.*;
import site.model.*;
import site.web.*;

@WebServlet("/add")
public class addpost extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private BlogPostDao blogPostDAO;

    public void init() {
        blogPostDAO = new BlogPostDaoImpl();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        System.out.println("insertBlogPost ooraha");

        String title = request.getParameter("title");
        String user = LoginController.usekaro;
        String author = request.getParameter("author");
        String Category = request.getParameter("Category");
        String Content = request.getParameter("Content");

        BlogPost newBlogPost = new BlogPost(title, Content, user, author, Category);
        blogPostDAO.insertBlogPost(newBlogPost);

        response.sendRedirect(request.getContextPath() + "/backend/index.jsp");
    }

}
