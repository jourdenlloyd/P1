package com.revature.driver;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.revature.util.LoggingUtil;
import com.revature.daos.EmployeeDAO;
import com.revature.daos.FormDAO;
import com.revature.daos.LoginDAO;
import com.revature.pojos.Form;
import com.revature.services.FormService;

public class Driver
{	//public static Connection conn=ConnectionFactory.getConnection();

public static void main(String[] args)
	{
		EmployeeDAO ed = new EmployeeDAO();
		ed.updateGrade("90%+", 19);
		ed.approveSuper(true, 19);
		ed.approveDH(true, 19);
		ed.approveBC(true, 19);
	}
}
