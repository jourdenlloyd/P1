package com.revature.services;

public interface EmployeeService
{
	public void approveSuper(boolean b, int id);

	public void approveDH(boolean b, int id);

	public void approveBC(boolean b, int id);
	
	public void updateGrade(String finalGrade, int id);
}
