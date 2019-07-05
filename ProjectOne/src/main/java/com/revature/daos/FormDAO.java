package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.revature.pojos.Form;
import com.revature.services.FormService;
import com.revature.util.ConnectionFactory;
import com.revature.util.LoggingUtil;

public class FormDAO implements FormService
{
Connection conn = ConnectionFactory.getConnection();

@Override
public void createForm(Form form)
	{
		String sql = "INSERT INTO rbforms (firstname, lastname, username, \"type\", \"date\", event_time, address, description, \"cost\", grade_format, passing_grade, justification) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		String sql1 = "INSERT INTO approvals(rbid) SELECT rbid FROM rbforms on conflict (rbid) do nothing;";

		PreparedStatement stmt;
		PreparedStatement stmt1;

		String firstname = form.getFirstname();
		String lastname = form.getLastname();
		String username = form.getUsername();
		String eventType = form.getEventType();
		String eventDate = form.getEventDate();
		String eventTime = form.getEventTime();
		String eventAddress = form.getEventAddress();
		String eventDescription = form.getEventDescription();
		String gradingFormat = form.getGradingFormat();
		String passingGrade = form.getPassingGrade();
		String workjustification = form.getWorkjustification();
		double eventCost = form.getEventCost();

		try
			{
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, firstname);
				stmt.setString(2, lastname);
				stmt.setString(3, username);
				stmt.setString(4, eventType);
				stmt.setString(5, eventDate);
				stmt.setString(6, eventTime);
				stmt.setString(7, eventAddress);
				stmt.setString(8, eventDescription);
				stmt.setDouble(9, eventCost);
				stmt.setString(10, gradingFormat);
				stmt.setString(11, passingGrade);
				stmt.setString(12, workjustification);
				stmt.executeUpdate();

				stmt1 = conn.prepareStatement(sql1);
				stmt1.executeUpdate();

				LoggingUtil.trace("Reimbursement request submitted");
			} catch (SQLException e)
			{
				e.printStackTrace();
			}

	}

@Override
public void viewMyForms()
	{

	}

@Override
public ArrayList <Form> viewAllForms()
	{
		ArrayList <Form> formList = new ArrayList <Form>();
		String sql = "select * from rbforms;";
		Statement stmt;

		try
			{
				stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);

				if (rs.next() == false)
					{
					} else
					do
						{
							formList.add(new Form(rs.getInt(1), rs.getString(2), rs.getString(3),
									rs.getString(4), rs.getString(5), rs.getString(6),
									rs.getString(7), rs.getString(8), rs.getString(9),
									rs.getString(13), rs.getString(11), rs.getString(12),
									rs.getDouble(10)));

						} while (rs.next());
			} catch (SQLException e)
			{
				LoggingUtil.error(e.getMessage());
				System.out.println("No forms in DB!");
				e.printStackTrace();
			}
		return formList;

	}
}
