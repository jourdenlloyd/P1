package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.revature.daos.FormDAO;
import com.revature.pojos.Employee;
import com.revature.pojos.Form;
import com.revature.util.LoggingUtil;

public class rbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//the DAO puts the stuff in the database
	public static FormDAO fd = new FormDAO();
       
    public rbServlet() {
        super();
    }
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("rbform.html");
	}

	/**
	 * @see This is where we check to see if the user is logged in and send them back if not
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fn = request.getParameter("firstname");
		String ln = request.getParameter("lastname");
		String un = request.getParameter("username");
		String type = request.getParameter("eventtype");
		String date = request.getParameter("eventdate");
		String time = request.getParameter("eventtime");
		String addr = request.getParameter("eventaddress");
		String desc = request.getParameter("eventdescription");
		String cost = request.getParameter("eventcost");
		String grdf = request.getParameter("gradingformat");
		String pg = request.getParameter("passinggrade");
		String just = request.getParameter("workjustification");
		double cost1 = Double.parseDouble(cost);
		
		if (type.contains("University Course: 80%")) {
			cost1 = (cost1 * 0.8);
		} else if (type.contains("Seminar: 60%")) {
			cost1 = (cost1 * 0.6);
		} else if (type.contains("Certification Prep Course: 75%")) {
			cost1 = (cost1 * 0.75);
		} else if (type.contains("Certification: 100%")) {
			cost1 = (cost1 * 1);
		} else if (type.contains("Technical Training: 90%")) {
			cost1 = (cost1 * 0.9);
		} else if(type.contains("Other: 30%")) {
			cost1 = (cost1 * 0.30);
		}
		
		fd.createForm(new Form(fn, ln, un, type, date, time, addr, desc, grdf, pg, just, cost1));

		LoggingUtil.trace("Reimbursement sent to DB from Servlet");
		response.sendRedirect("home.html");
		
	}

}
