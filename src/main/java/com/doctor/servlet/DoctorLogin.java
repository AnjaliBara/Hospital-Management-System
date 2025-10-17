package com.doctor.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.DoctorDao;
import com.db.DBConnect;
import com.entity.Doctor;

@SuppressWarnings("serial")
@WebServlet("/doctorLogin")
public class DoctorLogin extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    String email = req.getParameter("email");
	    String password = req.getParameter("password");
	    System.out.println("Login attempt: " + email + " / " + password);

	    HttpSession session = req.getSession();

	    DoctorDao dao = new DoctorDao(DBConnect.getConn());
	    Doctor doctor = dao.login(email, password);

	    if (doctor != null) {
	        System.out.println("Login successful for: " + email); 
	        session.setAttribute("doctObj", doctor);
	        resp.sendRedirect(req.getContextPath() + "/doctor/index.jsp");

	    } else {
	        System.out.println("Login failed for: " + email);
	        req.setAttribute("errorMsg", "Invalid email & password");
	        req.getRequestDispatcher("/WEB-INF/doctor_login.jsp").forward(req, resp);
	    }
	}


	
}
