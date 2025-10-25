package com.user.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.AppointmentDAO;
import com.entity.Appointment;
import com.db.DBConnect;

@SuppressWarnings("serial")
@WebServlet("/addAppointment")
public class AppointmentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            // Read parameters from the request
            int userId = Integer.parseInt(req.getParameter("userid"));
            String fullname = req.getParameter("fullname");
            String gender = req.getParameter("gender");
            String age = req.getParameter("age");
            String appoint_date = req.getParameter("appoint_date");
            String email = req.getParameter("email");
            String phno = req.getParameter("phno");
            String diseases = req.getParameter("diseases");
            int doctor_id = Integer.parseInt(req.getParameter("doct"));
            String address = req.getParameter("address");

            // Create Appointment object
            Appointment ap = new Appointment(userId, fullname, gender, age, appoint_date, email, phno, diseases, doctor_id, address, "Pending");

            // Initialize DAO with DB connection
            AppointmentDAO dao = new AppointmentDAO(DBConnect.getConn());
            HttpSession session=req.getSession();
            
            // Add appointment to database
            boolean f = dao.addAppointment(ap);
            // Redirect based on result
            if (f) {
                req.getSession().setAttribute("succMsg", "Appointment booked successfully");
                resp.sendRedirect("user_appointment.jsp");
            } else {
                req.getSession().setAttribute("errorMsg", "Something went wrong on server");
                resp.sendRedirect("user_appointment.jsp");
            }

        } catch (Exception e) {
            e.printStackTrace();
            req.getSession().setAttribute("errorMsg", "Error: " + e.getMessage());
            resp.sendRedirect("user_appointment.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Optional: Handle GET requests if needed
        resp.sendRedirect("user_appointment.jsp");
    }
}
