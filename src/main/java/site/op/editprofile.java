package site.op;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import site.dao.*;
import site.model.*;

@WebServlet("/editprofile")
public class editprofile extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDao userDao;

    public void init() {
        userDao = new UserDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        register(request, response);
    }

    private void register(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String password = request.getParameter("passWord");
        System.out.println("password is  = " + password);

        User employee = new User();
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setPassword(password);

        try {

            int result = userDao.Editemployee(employee);
            if (result == 1) {
                System.out.println("succesfuly register");
                request.setAttribute("NOTIFICATION", "User Registered Successfully!");
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("backend/profile.jsp");
        dispatcher.forward(request, response);
    }
}
