package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.revature.daos.LoginDAO;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static LoginDAO ld = new LoginDAO();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("login.html");
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		boolean che = ld.loginCheck(username, password);
		
		if (che == false) {
			resp.sendRedirect("login.html");
			System.out.println(che);
		} 
		else 
			if (che == true) {
			resp.sendRedirect("home.html");
			System.out.println(che);
		}
	}

}
