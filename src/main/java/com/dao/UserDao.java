package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.entity.User;

public class UserDao {
   private Connection conn;

   public UserDao(Connection conn) {
	super();
	this.conn = conn;
   }
   public boolean register(User u)
   {
	   boolean f=false;
	   
	   try {
		  String sql="Insert into user_dtls(full_name,email,password) values(?,?,?)" ;
		   
		   PreparedStatement ps=conn.prepareStatement(sql);
		   ps.setString(1, u.getFullName());
		   ps.setString(2, u.getEmail());
		   ps.setString(3, u.getPassword());
		   
		  int i= ps.executeUpdate();
		  
		  if(i==1)
		  {
			  f=true;
		  }
		  
		   
	   }catch (Exception e) {
		   e.printStackTrace();
	   }
	   return f;
	   
	   }
   public User login(String em,String psw) {
	   User u =null;
	   try {
		   String sql="select * from user_dtls where email=? and password=?";
		   PreparedStatement ps = conn.prepareStatement(sql);
		   ps.setString(1, em);
		   ps.setString(2, psw);
		   
		   ResultSet rs = ps.executeQuery();
		   while(rs.next())
		   {
			   u = new User();
			   u.setId(rs.getInt(1));
			   u.setFullName(rs.getString(2));
			   u.setEmail(rs.getString(3));
			   u.setPassword(rs.getString(4));
		   }
		   
	   } catch(Exception e) {
		   e.printStackTrace();
	   }
	   return u;
  }
   public boolean ckeckOldPassword(int userId,String oldpassword )
	{
		boolean f=false;
		try {
			
			
			String sql="select * from user_details where id=? and password=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			
			ps.setInt(1,userId);	
			
			ps.setString(2,oldpassword);
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				f=true;
			
			}
			
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return f;
	}
	

	public boolean changePassword(int userId,String newpassword )
	{
		boolean f=false;
		try {
			
			
			String sql="update user_details set  password=? where id=? ";
			PreparedStatement ps=conn.prepareStatement(sql);
			
			
			
			ps.setString(1,newpassword);
			ps.setInt(2,userId);	
			
		int i=ps.executeUpdate();
		if(i==1)
		{
			f=true;
		}
			
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return f;
	}
	
   
   }