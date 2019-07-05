package com.revature.servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.daos.EmployeeDAO;
import com.revature.daos.FormDAO;
import com.revature.pojos.Form;
import com.revature.util.Lumberjack;

public class AllFormsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Lumberjack lj = new Lumberjack();
	

  protected void doGet(HttpServletRequest request, HttpServletResponse
  response) throws ServletException, IOException {
	  Lumberjack.ljlog("AllFormsServlet.doGet() called");
	  FormDAO fd = new FormDAO();
  ArrayList<Form> formList; 
  formList = fd.viewAllForms();
  Lumberjack.ljlog("AllFormsServlet.doGet(): formList before mapping\n\n" + formList.toString() + "\n\n");
  ObjectMapper om = new ObjectMapper(); 
  String str = om.writeValueAsString(formList);
  Lumberjack.ljlog("AllFormsServlet.doGet(): formList after mapping\n\n" + str + "\n\n");
  //System.out.println(str); response.getWriter().write(str);
  response.sendRedirect("viewallforms.html"); }
 

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String rbid = request.getParameter("rbid");
		int rbid1 = Integer.parseInt(rbid);
		String appr = request.getParameter("approver");
		String tf = request.getParameter("status");
		boolean tf1 = Boolean.parseBoolean(tf);
		
		EmployeeDAO ed = new EmployeeDAO();
		
		if (appr.contains("BenCo")) {
			ed.approveBC(tf1, rbid1);
			System.out.println("updated");
			
		} else if (appr.contains("Direct Supervisor")){
			ed.approveSuper(tf1, rbid1);
			System.out.println("updated");
			
			
		} else if (appr.contains("Department Head")) {
		ed.approveDH(tf1, rbid1);
		System.out.println("updated");
		
	
		}
		response.sendRedirect("viewallforms.html");
	}

}
