package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.revature.pojos.Employee;
import com.revature.services.EmployeeService;
import com.revature.util.ConnectionFactory;
import com.revature.util.LoggingUtil;


public class EmployeeDAO implements EmployeeService
{ Connection conn = ConnectionFactory.getConnection();
	@Override
	public void approveSuper(boolean b, int id)
		{
			String sql = "UPDATE approvals SET superchk=? WHERE rbid=?;";
			PreparedStatement stmt;
			
			String sql1 = "update approvals set award = rbforms.\"cost\" from rbforms where superchk = true and dhchk = true and bencochk = true and rbforms.rbid = ?;";
			PreparedStatement stmt1;

			String sql2 = "update approvals set funds = funds - rbforms.\"cost\" from rbforms where superchk = true and dhchk = true and bencochk = true and rbforms.rbid = ?;";
			PreparedStatement stmt2;
			
			try
				{
					stmt = conn.prepareStatement(sql);
					stmt.setBoolean(1, b);
					stmt.setInt(2, id);
					stmt.executeUpdate();
					LoggingUtil.trace("Direct supervisor approved");
					
					stmt1 = conn.prepareStatement(sql1);
					stmt1.setInt(1, id);
					stmt1.executeUpdate();
					LoggingUtil.trace("Full approval achieved, funds awarded");
					
					stmt2 = conn.prepareStatement(sql2);
					stmt2.setInt(1, id);
					stmt2.executeUpdate();
					LoggingUtil.trace("Available funds updated");
				} catch (SQLException e)
				{
					e.printStackTrace();
				}
		}

	@Override
	public void approveDH(boolean b, int id)
		{
			String sql = "UPDATE approvals SET dhchk=? WHERE rbid=?;";
			PreparedStatement stmt;
			
			String sql1 = "update approvals set award = rbforms.\"cost\" from rbforms where superchk = true and dhchk = true and bencochk = true and rbforms.rbid = ?;";
			PreparedStatement stmt1;
			
			String sql2 = "update approvals set funds = funds - rbforms.\"cost\" from rbforms where superchk = true and dhchk = true and bencochk = true and rbforms.rbid = ?;";
			PreparedStatement stmt2;

			try
				{
					stmt = conn.prepareStatement(sql);
					stmt.setBoolean(1, b);
					stmt.setInt(2, id);
					stmt.executeUpdate();
					LoggingUtil.trace("Department head approved");
					
					stmt1 = conn.prepareStatement(sql1);
					stmt1.setInt(1, id);
					stmt1.executeUpdate();
					LoggingUtil.trace("Full approval achieved, funds awarded");
					
					stmt2 = conn.prepareStatement(sql2);
					stmt2.setInt(1, id);
					stmt2.executeUpdate();
					LoggingUtil.trace("Available funds updated");
				} catch (SQLException e)
				{
					e.printStackTrace();
				}
		}

	@Override
	public void approveBC(boolean b, int id)
		{
			String sql = "UPDATE approvals SET bencochk=? WHERE rbid=?;";
			PreparedStatement stmt;
			
			String sql1 = "update approvals set award = rbforms.\"cost\" from rbforms where superchk = true and dhchk = true and bencochk = true and rbforms.rbid = ?;";
			PreparedStatement stmt1;
			
			String sql2 = "update approvals set funds = funds - rbforms.\"cost\" from rbforms where superchk = true and dhchk = true and bencochk = true and rbforms.rbid = ?;";
			PreparedStatement stmt2;

			try
				{
					stmt = conn.prepareStatement(sql);
					stmt.setBoolean(1, b);
					stmt.setInt(2, id);
					stmt.executeUpdate();
					LoggingUtil.trace("Benco approved");
					
					stmt1 = conn.prepareStatement(sql1);
					stmt1.setInt(1, id);
					stmt1.executeUpdate();
					LoggingUtil.trace("Full approval achieved, funds awarded");
					
					stmt2 = conn.prepareStatement(sql2);
					stmt2.setInt(1, id);
					stmt2.executeUpdate();
					LoggingUtil.trace("Available funds updated");
				} catch (SQLException e)
				{
					e.printStackTrace();
				}
		}

	@Override
	public void updateGrade(String finalGrade, int rbid)
		{
			String sql = "UPDATE approvals SET finalgrade=? WHERE rbid=?;";
			PreparedStatement stmt;

			try
				{
					stmt = conn.prepareStatement(sql);
					stmt.setString(1, finalGrade);
					stmt.setInt(2, rbid);
					stmt.executeUpdate();
					LoggingUtil.trace("Grade updated DAO");
				} catch (SQLException e)
				{
					e.printStackTrace();
				}
			
		}

}
