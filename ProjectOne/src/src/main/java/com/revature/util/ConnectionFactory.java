package com.revature.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory
{	private String url;
	private String user;
	private String password;
	private static final String PROPERTIES_FILE = "./database.properties";
	private static ConnectionFactory cf;

	public static synchronized Connection getConnection() {

	      if (cf == null) {
	          cf = new ConnectionFactory();
	      }

	      return cf.createConnection();

	  }

	
	  private ConnectionFactory() {

	      Properties prop = new Properties();

	      ClassLoader loader = Thread.currentThread().getContextClassLoader();

	      try (InputStream fis = loader.getResourceAsStream(PROPERTIES_FILE);) {

	          prop.load(fis);
	          url = prop.getProperty("url");
	          user = prop.getProperty("user");
	          password = prop.getProperty("password");

	      } catch (FileNotFoundException e) {
	          e.printStackTrace();
	       
	      } catch (IOException e) {
	          e.printStackTrace();
	      }
	  }

	  private Connection createConnection() {

	      Connection conn = null;

	      try {
	          Class.forName("org.postgresql.Driver");
	          conn = DriverManager.getConnection(url, user, password);

	          System.out.println("Connected to DB!");

	      }  catch (ClassNotFoundException e) {

	          e.printStackTrace();
	      } catch (SQLException e) {
	          e.printStackTrace();

	          System.out.println("DB connection failed!");
	      }
	      return conn;
	  }
}
