package site.web;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/admin")
public class BlogPostController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    RequestDispatcher dispatcher = null;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getServletPath();
        switch (action) {
            case "/profile.jsp":
                dispatcher = request.getRequestDispatcher("backend/login.jsp");
                break;

            default:
                if (LoginController.usekaro == null) {
                    System.out.println("its worked");
                    dispatcher = request.getRequestDispatcher("backend/login.jsp");
                } else {
                    dispatcher = request.getRequestDispatcher("backend/index.jsp");
                }
                dispatcher.forward(request, response);

                break;
        }

        dispatcher.forward(request, response);
    }

}
