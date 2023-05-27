package site.op;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import site.web.*;

@WebServlet(urlPatterns = "/logout", name = "logout")
public class logout extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        LoginController.usekaro = null;
        response.sendRedirect(request.getContextPath() + "/admin");
    }

}
