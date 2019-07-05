package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.revature.util.ConnectionFactory;

public class LoginDAO
{
Connection conn = ConnectionFactory.getConnection();

public boolean loginCheck(String username, String password)
	{
		String sql = "Select username, passwrd from employee where username = ?;";
		PreparedStatement stmt;
		int flag = 0;
		if(password.equals("") && username.equals(""))
			return false;
		else {

		try
			{
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, username);
				ResultSet rs = stmt.executeQuery();
				String pwCheck = "";

				while (rs.next())
					{
						pwCheck = rs.getString("passwrd");
					}

				if (pwCheck.equals(password))
					{
						flag = 2;
					}else
						flag=1;

			} catch (SQLException e)
			{
				e.printStackTrace();
			}
		if (flag == 1)
			{
				return false;
			} else

			return true;
		}

	}
}
