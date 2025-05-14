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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Fawas
 */
@WebServlet("/appointment-details")
public class AppointmentDetailsServlet extends HttpServlet {
    
   
  private AppointmentDAO dao = new AppointmentDAOImpl();  
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
    HttpSession session = req.getSession(false);
    if (session == null || session.getAttribute("appointmentId") == null) {
        resp.sendRedirect(req.getContextPath() + "/view-doctors");
        return;
    }
    Object apptObj = session.getAttribute("appointmentId");
    int appointmentId;
    if (apptObj instanceof Integer) {
        appointmentId = (Integer) apptObj;
    } else {
        appointmentId = Integer.parseInt(apptObj.toString());
    }
    Appointment appt = dao.findById(appointmentId);
    if (appt == null) {
        resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Appointment not found");
        return;
    }
    req.setAttribute("appointment", appt);
    req.getRequestDispatcher("/appointment-details.jsp").forward(req, resp);
}
}