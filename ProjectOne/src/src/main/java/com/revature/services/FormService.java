package com.revature.services;

import java.util.List;
import com.revature.pojos.Form;

public interface FormService
{
	public void createForm(Form form);
	public void viewMyForms();	
	public List <Form> viewAllForms();
}
