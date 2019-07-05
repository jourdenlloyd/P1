package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.revature.daos.EmployeeDAO;
import com.revature.pojos.Employee;
import com.revature.util.LoggingUtil;

public class UpdateGradeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static EmployeeDAO ed = new EmployeeDAO();

	public void init(ServletConfig config) throws ServletException {
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("updateforms.html");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String fg = request.getParameter("finalgrade");
			String rbid = request.getParameter("rbid");
			int rbid1 = Integer.parseInt(rbid);
			
			ed.updateGrade(fg, rbid1);
			
			LoggingUtil.trace("Grade updated servlet");
			response.sendRedirect("home.html");
		}
		
	
	}


