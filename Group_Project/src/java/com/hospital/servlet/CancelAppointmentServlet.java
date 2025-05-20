/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.hospital.servlet;

import com.hospital.dao.AppointmentDAO;
import com.hospital.dao.impl.AppointmentDAOImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
/**
 *
 * @author 
 */
@WebServlet("/CancelAppointmentServlet")
public class CancelAppointmentServlet extends HttpServlet {
 private AppointmentDAO appointmentDAO = new AppointmentDAOImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int appointmentId = Integer.parseInt(req.getParameter("appointmentId"));
        appointmentDAO.updatePaymentStatus(appointmentId, "Cancelled");
        resp.sendRedirect(req.getContextPath() + "/view-appointments");
    }
}