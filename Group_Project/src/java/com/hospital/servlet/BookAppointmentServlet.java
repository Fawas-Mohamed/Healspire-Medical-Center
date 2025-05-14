/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.hospital.servlet;

import com.hospital.dao.AppointmentDAO;
import com.hospital.dao.DoctorDAO;
import com.hospital.dao.impl.AppointmentDAOImpl;
import com.hospital.dao.impl.DoctorDAOImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/book-appointment")
public class BookAppointmentServlet extends HttpServlet {
    private DoctorDAO doctorDAO = new DoctorDAOImpl();
    private AppointmentDAO appointmentDAO = new AppointmentDAOImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int doctorId = Integer.parseInt(req.getParameter("doctorId"));
        int scheduleId = Integer.parseInt(req.getParameter("scheduleId"));
        resp.sendRedirect(req.getContextPath() + "/payment?doctorId=" + doctorId + "&scheduleId=" + scheduleId);
    }
}
       /* int doctorId = Integer.parseInt(req.getParameter("doctorId"));
        Date date = Date.valueOf(req.getParameter("date"));
        Time time = Time.valueOf(req.getParameter("time") + ":00");

        HttpSession session = req.getSession(false);
        int patientId = (int) session.getAttribute("patientId");

        Appointment appointment = new Appointment();
        appointment.setDoctorId(doctorId);
        appointment.setPatientId(patientId);
        appointment.setAppointmentDate(date);
        appointment.setAppointmentTime(time);

        appointmentDAO.save(appointment);

        resp.sendRedirect(req.getContextPath() + "/view-appointments");
    }
}
*/