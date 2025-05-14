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

/**
 *
 * @author Fawas
 */
@WebServlet(name = "adminAssignedAppointmentsServlet", urlPatterns = {"/adminAssignedAppointmentsServlet"})
public class adminAssignedAppointmentsServlet extends HttpServlet {
private AppointmentDAO appointmentDAO = new AppointmentDAOImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Appointment> appointments = appointmentDAO.findAllAppointments();
        request.setAttribute("appointments", appointments);
        request.getRequestDispatcher("/admin/adminassigned-appointments.jsp").forward(request, response);
    }
}