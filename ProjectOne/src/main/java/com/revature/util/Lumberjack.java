package com.revature.util;

import java.util.Date;

public class Lumberjack
{
	
	public static void ljlog(String desc) {
		Date date = new Date();
		System.out.println(date.getTime() + desc);
	}

}
