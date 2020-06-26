package com.prac.webapp.jee; 

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {
	private LogInService logInService = new LogInService();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/LogIn.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		Boolean userStatus = logInService.validateUser(name, password);
		if (userStatus) {
			request.setAttribute("name", name);
			request.getRequestDispatcher("/WEB-INF/WelCome.jsp").forward(request, response);
		} else {
			request.setAttribute("ErrorMessage", "Invalid Credentials!!");
			request.getRequestDispatcher("/WEB-INF/LogIn.jsp").forward(request, response);
		}
	}
}