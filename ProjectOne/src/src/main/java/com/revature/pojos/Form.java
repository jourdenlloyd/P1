package com.revature.pojos;

public class Form
{ // no args constructor
public Form() {
	super();
}

//args constructor
public Form(String firstname, String lastname, String username, String eventType, String eventDate,
		String eventTime, String eventAddress, String eventDescription, String gradingFormat,
		String passingGrade, String workjustification, double eventCost) {
	super();
	this.firstname = firstname;
	this.lastname = lastname;
	this.username = username;
	this.eventType = eventType;
	this.eventDate = eventDate;
	this.eventTime = eventTime;
	this.eventAddress = eventAddress;
	this.eventDescription = eventDescription;
	this.gradingFormat = gradingFormat;
	this.passingGrade = passingGrade;
	this.workjustification = workjustification;
	this.eventCost = eventCost;
}

public Form(int id, String firstname, String lastname, String username, String eventType, String eventDate,
		String eventTime, String eventAddress, String eventDescription, String gradingFormat,
		String passingGrade, String workjustification, double eventCost) {
			this.rbid = id;
			this.firstname = firstname;
			this.lastname = lastname;
			this.username = username;
			this.eventType = eventType;
			this.eventDate = eventDate;
			this.eventTime = eventTime;
			this.eventAddress = eventAddress;
			this.eventDescription = eventDescription;
			this.gradingFormat = gradingFormat;
			this.passingGrade = passingGrade;
			this.workjustification = workjustification;
			this.eventCost = eventCost;
		}

//fields
private String firstname;
private String lastname;
private String username;
private String eventType;
private String eventDate;
private String eventTime;
private String eventAddress;
private String eventDescription;
private String gradingFormat;
private String passingGrade;
private String workjustification;
private double eventCost;
private int rbid;

// getters & setters
public String getFirstname()
	{
		return firstname;
	}

public void setFirstname(String firstname)
	{
		this.firstname = firstname;
	}

public String getLastname()
	{
		return lastname;
	}

public void setLastname(String lastname)
	{
		this.lastname = lastname;
	}

public String getUsername()
	{
		return username;
	}

public void setUsername(String username)
	{
		this.username = username;
	}

public String getEventType()
	{
		return eventType;
	}

public void setEventType(String eventType)
	{
		this.eventType = eventType;
	}

public String getEventDate()
	{
		return eventDate;
	}

public void setEventDate(String eventDate)
	{
		this.eventDate = eventDate;
	}

public String getEventTime()
	{
		return eventTime;
	}

public void setEventTime(String eventTime)
	{
		this.eventTime = eventTime;
	}

public String getEventAddress()
	{
		return eventAddress;
	}

public void setEventAddress(String eventAddress)
	{
		this.eventAddress = eventAddress;
	}

public String getEventDescription()
	{
		return eventDescription;
	}

public void setEventDescription(String eventDescription)
	{
		this.eventDescription = eventDescription;
	}

public String getGradingFormat()
	{
		return gradingFormat;
	}

public void setGradingFormat(String gradingFormat)
	{
		this.gradingFormat = gradingFormat;
	}

public String getPassingGrade()
	{
		return passingGrade;
	}

public void setPassingGrade(String passingGrade)
	{
		this.passingGrade = passingGrade;
	}

public String getWorkjustification()
	{
			return workjustification;
	}

public void setWorkjustification(String workjustification)
	{
			this.workjustification = workjustification;
	}

public double getEventCost()
	{
		return eventCost;
	}

public void setEventCost(int eventCost)
	{
		this.eventCost = eventCost;
	}

public int getRbid()
	{
			return rbid;
	}

public void setRbid(int rbid)
	{
			this.rbid = rbid;
	}

@Override
public String toString()
	{
		return "Form [firstname=" + firstname + ", lastname=" + lastname + ", username=" + username
				+ ", eventType=" + eventType + ", eventDate=" + eventDate + ", eventTime="
				+ eventTime + ", eventAddress=" + eventAddress + ", eventDescription="
				+ eventDescription + ", gradingFormat=" + gradingFormat + ", passingGrade="
				+ passingGrade + ", workjustification=" + workjustification + ", eventCost="
				+ eventCost + "]";
	}


}