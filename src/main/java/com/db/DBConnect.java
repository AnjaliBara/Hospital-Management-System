package com.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
  private static Connection conn;
  
 public static Connection getConn() {
   
	  try {
  
		  Class.forName("com.mysql.cj.jdbc.Driver");
<<<<<<< HEAD
		  conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitalmanagementsystem","root","Asm#711397");
=======
		  conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitalmanagementsystem","root","Aradhana7@");
>>>>>>> cfb7e32 (Added Admin login and logout)
	
	  }catch (Exception e) {
		  e.printStackTrace();
	  }
  
	  return conn;
  }
}
