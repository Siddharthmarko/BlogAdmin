package site.web;

import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import site.dao.*;
import site.model.*;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String usekaro;
	private LoginDao loginDao;
	private BlogPostDao blogPostDAO;

	public void init() {
		loginDao = new LoginDao();
		blogPostDAO = new BlogPostDaoImpl();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("In /login");
		authenticate(request, response);
	}

	private void authenticate(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("authentication");

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		LoginBean loginBean = new LoginBean();
		loginBean.setUsername(username);
		loginBean.setPassword(password);

		try {
			if (loginDao.validate(loginBean)) {
				System.out.println("validate");
				usekaro = username;

				RequestDispatcher dispatcher = request.getRequestDispatcher("backend/index.jsp");

				dispatcher.forward(request, response);
				listPost(request, response);

			} else {
				HttpSession session = request.getSession();
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	private void listPost(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<BlogPost> listPost = blogPostDAO.selectAllBlogPosts();
		request.setAttribute("listPost", listPost);
		RequestDispatcher dispatcher = request.getRequestDispatcher("backend/index.jsp");
		dispatcher.forward(request, response);
	}
}
