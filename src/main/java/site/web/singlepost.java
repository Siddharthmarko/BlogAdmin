package site.web;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import site.dao.*;
import site.model.*;

@WebServlet(urlPatterns = "/singlepost", name = "singlepost")
public class singlepost extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public static String usekaro;
    private BlogPostDao blogPostDAO;

    public void init() {
        blogPostDAO = new BlogPostDaoImpl();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("In /login");
        String id = request.getParameter("id");
        int postId = Integer.parseInt(id);
        System.out.println("bilkul upra hai blog ke");
        BlogPost listPost = blogPostDAO.selectBlogPost(postId);
        request.setAttribute("listPost", listPost);
        RequestDispatcher dispatcher = request.getRequestDispatcher("backend/singlepost.jsp");
        dispatcher.forward(request, response);
    }

}
