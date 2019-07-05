package com.revature.drivers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.revature.utils.ConnectionFactory;
import com.revature.utils.LoggingUtil;


public class Driver
{
	public static Connection conn=ConnectionFactory.getConnection();
	
	public static void main(String[] args)
	{
		//Employee emp= new Employee();
	
		adtest("Mohamad","Hijazi","mbinali@lloydco.com","123");

	}

		static void adtest(String s,String f,String l,String g)
	{
		
		
		String sql = "INSERT INTO employee (firstname, lastname, username, passwrd, supervisor, depthead, benco) VALUES(?, ?, ?, ?, false, false, false);";
		
		PreparedStatement stmt;

		try
			{
				stmt = conn.prepareStatement(sql);
				
				stmt.setString(1, s);
				stmt.setString(2, f);
				stmt.setString(3, l);
				stmt.setString(4, g);
				stmt.executeUpdate();
				System.out.println("Employee account created.\n\n");

			} catch (SQLException ex)
			{
				LoggingUtil.info("SQL exception in addEmployee method.");
				ex.printStackTrace();
			}
	}

}
