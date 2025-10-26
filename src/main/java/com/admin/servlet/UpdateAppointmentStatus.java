package com.admin.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.AppointmentDAO;
import com.db.DBConnect;


@WebServlet("/updateAppointmentStatus")
public class UpdateAppointmentStatus extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            String status = req.getParameter("status");
            
            System.out.println("=== DEBUG SERVLET ===");
            System.out.println("Appointment ID: " + id);
            System.out.println("New Status: " + status);
            
            AppointmentDAO dao = new AppointmentDAO(DBConnect.getConn());
            boolean f = dao.updateAppointmentStatus(id, status);
            
            HttpSession session = req.getSession();
            if(f) {
                session.setAttribute("succMsg", "Appointment status updated to: " + status);
                System.out.println("DEBUG: Update successful in servlet");
            } else {
                session.setAttribute("errorMsg", "Failed to update appointment status. Appointment may not exist.");
                System.out.println("DEBUG: Update failed in servlet");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            HttpSession session = req.getSession();
            session.setAttribute("errorMsg", "Error: " + e.getMessage());
        }
        // Make sure this matches your actual JSP file name
        resp.sendRedirect("admin/patient.jsp");
    }
}