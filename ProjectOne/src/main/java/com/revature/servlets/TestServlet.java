package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public TestServlet() {
        super();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hellow world");
        PrintWriter pw=response.getWriter();
        pw.write("hello work from here ");
        response.getWriter().write("Welcome ");
        pw.close();
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hellow world");
        PrintWriter pw=response.getWriter();
        pw.write("hello work from here ");
        response.getWriter().write("Welcome ");
        pw.close();
		
	}

}
