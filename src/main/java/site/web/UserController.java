package site.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import site.dao.*;
import site.model.*;

@WebServlet("/register")
public class UserController extends HttpServlet {
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
		System.out.println("work 1");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		/*
		 * here is make object of user than fil value
		 */
		User employee = new User();
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setUsername(username);
		employee.setPassword(password);

		try {
			System.out.println("work 1");

			int result = userDao.registerEmployee(employee);
			if (result == 1) {
				System.out.println("succesfuly register");
				request.setAttribute("NOTIFICATION", "User Registered Successfully!");
			} else {
				String script = "'User already exists!'";
				HttpSession session = request.getSession();
				session.setAttribute("alertScript", script);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("work 4");
		System.out.println("dispactch to login");

		RequestDispatcher dispatcher = request.getRequestDispatcher("backend/login.jsp");
		dispatcher.forward(request, response);
	}
}
