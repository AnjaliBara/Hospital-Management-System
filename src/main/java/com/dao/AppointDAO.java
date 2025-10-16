package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Doctor;
import com.entity.appointment;

public class AppointDAO {

private Connection conn;

public AppointDAO( Connection conn) {
	super();
	this.conn=conn;
}
	
public boolean addAppointment(appointment ap)
{
	boolean f=false;
	
	try {
		String sql="insert into appointment(user_id,fullName,gender,age,appoinDate,email,phno, diseases,doctor_id,address,status) values(?,?,?,?,?,?,?,?,?,?,?)";
		
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1,ap.getUser_id());
		ps.setString(2,ap.getFullName());
		ps.setString(3,ap.getGender());
		ps.setString(4,ap.getAge());
		ps.setString(5,ap.getAppoinDate());
		ps.setString(6,ap.getEmail());
		ps.setString(7,ap.getPhno());
		ps.setString(8,ap.getDiseases());
		ps.setInt(9,ap.getDoctor_id());
		ps.setString(10,ap.getAddress());
		ps.setString(11,ap.getStatus());
		

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
	
public List<appointment> getAllAppointmentByLoginUser(int user_id)
{
	List<appointment> list=new ArrayList<appointment>();
	
	appointment d=null;
	try {
		String sql="select * from appointment where user_id=?";
		
		PreparedStatement ps=conn.prepareStatement(sql);
		
		
		ps.setInt(1, user_id);
		ResultSet rs=ps.executeQuery();
		
		
		while(rs.next())
		{
			d=new appointment();
			d.setId(rs.getInt(1));
			d.setUser_id(rs.getInt(2));
			d.setFullName(rs.getString(3));
		d.setGender(rs.getString(4));
		d.setAge(rs.getString(5));
		d.setAppoinDate(rs.getString(6));
			d.setEmail(rs.getString(7));
			d.setPhno(rs.getString(8));
			d.setDiseases(rs.getString(9));
			d.setDoctor_id(rs.getInt(10));
			d.setAddress(rs.getString(11));
			d.setStatus(rs.getString(12));
			list.add(d);
			
		}
		
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	return list;
}

public Doctor getDoctorById(int id)
{
	
	
	Doctor d=null;
	try {
		String sql="select * from doctor where id=?";
		
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs=ps.executeQuery();
		
		
		while(rs.next())
		{
			d=new Doctor();
			d.setId(rs.getInt(1));
			d.setFullName(rs.getString(2));
			d.setDob(rs.getNString(3));
			d.setQualification(rs.getString(4));
			d.setSpecialist(rs.getString(5));
			d.setEmail(rs.getString(6));
			d.setMobno(rs.getString(7));
			d.setPassword(rs.getString(8));
		
			
		}
		
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	return d;
}
	

public List<appointment> getAllAppointmentByDoctorLogin(int doctor_id)
{
List<appointment> list=new ArrayList<appointment>();

appointment d=null;
try {
	String sql="select * from appointment where doctor_id=?";
	
	PreparedStatement ps=conn.prepareStatement(sql);
	
	
	ps.setInt(1, doctor_id);
	ResultSet rs=ps.executeQuery();
	
	while(rs.next())
	{
		d=new appointment();
		d.setId(rs.getInt(1));
		d.setUser_id(rs.getInt(2));
		d.setFullName(rs.getString(3));
	d.setGender(rs.getString(4));
	d.setAge(rs.getString(5));
	d.setAppoinDate(rs.getString(6));
		d.setEmail(rs.getString(7));
		d.setPhno(rs.getString(8));
		d.setDiseases(rs.getString(9));
		d.setDoctor_id(rs.getInt(10));
		d.setAddress(rs.getString(11));
		d.setStatus(rs.getString(12));
		list.add(d);
	}
	
	
}catch(Exception e)
{
	e.printStackTrace();
}
return list;
}
	

public appointment getAllAppointmentById(int id)
{


appointment d=null;
try {
	String sql="select * from appointment where id=?";
	
	PreparedStatement ps=conn.prepareStatement(sql);
	
	
	ps.setInt(1,id);
	ResultSet rs=ps.executeQuery();
	
	while(rs.next())
	{
		d=new appointment();
		d.setId(rs.getInt(1));
		d.setUser_id(rs.getInt(2));
		d.setFullName(rs.getString(3));
	d.setGender(rs.getString(4));
	d.setAge(rs.getString(5));
	d.setAppoinDate(rs.getString(6));
		d.setEmail(rs.getString(7));
		d.setPhno(rs.getString(8));
		d.setDiseases(rs.getString(9));
		d.setDoctor_id(rs.getInt(10));
		d.setAddress(rs.getString(11));
		d.setStatus(rs.getString(12));
	
	}
	
	
}catch(Exception e)
{
	e.printStackTrace();
}
return d;
}
	
public boolean updateCommentStatus(int id,int doctor_id,String comm)
{
	 boolean f=false;
	try {
		

		String sql="update appointment set status=? where id=? and doctor_id=?";
		
PreparedStatement ps=conn.prepareStatement(sql);
		
		ps.setString(1,comm);
		ps.setInt(2,id);
		ps.setInt(3,doctor_id);
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



public List<appointment> getAllAppointment()
{
List<appointment> list=new ArrayList<appointment>();

appointment ap=null;
try {
	String sql="select * from appointment order by user_id desc";
	
	PreparedStatement ps=conn.prepareStatement(sql);
	
	
	
	ResultSet rs=ps.executeQuery();
	
	while(rs.next())
	{
		ap=new appointment();
		ap.setId(rs.getInt(1));
		ap.setUser_id(rs.getInt(2));
		ap.setFullName(rs.getString(3));
	    ap.setGender(rs.getString(4));
	    ap.setAge(rs.getString(5));
	    ap.setAppoinDate(rs.getString(6));
		ap.setEmail(rs.getString(7));
		ap.setPhno(rs.getString(8));
		ap.setDiseases(rs.getString(9));
		ap.setDoctor_id(rs.getInt(10));
		ap.setAddress(rs.getString(11));
		ap.setStatus(rs.getString(12));
		list.add(ap);
	}
	
	
}catch(Exception e)
{
	e.printStackTrace();
}
return list;
}

public boolean updateAppointmentStatus(int id, String status) {
	boolean f = false;
	 try {
	     String sql = "update appointment set status=? where appointment_id=?";
	     PreparedStatement ps = conn.prepareStatement(sql);
	     ps.setString(1, status);
	     ps.setInt(2, id);
	     
	     int i = ps.executeUpdate();
	     if(i == 1) {
	         f = true;
	     }
	 } catch (Exception e) {
	     e.printStackTrace();
	 }
	 return f;
}



}
