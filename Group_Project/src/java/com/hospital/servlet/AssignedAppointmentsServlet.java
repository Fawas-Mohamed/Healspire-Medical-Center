/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.hospital.servlet;

import com.hospital.dao.impl.AppointmentDAOImpl;
import com.hospital.model.Appointment;
import com.hospital.dao.AppointmentDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 
 */
@WebServlet("/assigned-appointments")
public class AssignedAppointmentsServlet extends HttpServlet {
 private AppointmentDAO appointmentDAO = new AppointmentDAOImpl();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
        HttpSession session = req.getSession(false);
        List<Appointment> appointments;

        if (session != null && session.getAttribute("doctorId") != null) {
            int doctorId = (Integer) session.getAttribute("doctorId");
            appointments = appointmentDAO.findByDoctorId(doctorId);
        } else if (session != null && session.getAttribute("adminId") != null) {
            appointments = appointmentDAO.findAll();
        } else {
            resp.sendRedirect(req.getContextPath() + "/login.jsp");
            return;
        }

        req.setAttribute("appointments", appointments);
        req.getRequestDispatcher("doctor/assigned-appointments_1.jsp").forward(req, resp);
    }
}