package com.admin.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.entity.Doctor;
import com.dao.DoctorDao;
import com.db.DBConnect;

@WebServlet("/addDoctor")
public class AddDoctor extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fullName = req.getParameter("fullName");
        String dob = req.getParameter("dob");
        String qualification = req.getParameter("qualification");
        String specialist = req.getParameter("specialist");
        String email = req.getParameter("email");
        String mobno = req.getParameter("mobno");
        String password = req.getParameter("password");

        Doctor doctor = new Doctor();
        doctor.setFullName(fullName);
        doctor.setDob(dob);
        doctor.setQualification(qualification);
        doctor.setSpecialist(specialist);
        doctor.setEmail(email);
        doctor.setMobNo(mobno);
        doctor.setPassword(password);

        DoctorDao dao = new DoctorDao(DBConnect.getConn());
        boolean result = dao.registerDoctor(doctor);

        if(result) {
            req.getSession().setAttribute("sucMsg", "Doctor added successfully!");
            resp.sendRedirect("admin/doctor_list.jsp");
        } else {
            req.getSession().setAttribute("errorMsg", "Unable to add doctor!");
            resp.sendRedirect("admin/add_doctor.jsp");
        }
    }
}
