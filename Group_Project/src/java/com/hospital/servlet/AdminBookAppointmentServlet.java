/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.hospital.servlet;


import com.hospital.dao.AppointmentDAO;
import com.hospital.dao.DoctorDAO;
import com.hospital.dao.ScheduleDAO;
import com.hospital.dao.impl.AppointmentDAOImpl;
import com.hospital.dao.impl.DoctorDAOImpl;
import com.hospital.dao.impl.ScheduleDAOImpl;
import com.hospital.model.Appointment;
import com.hospital.model.Doctor;
import com.hospital.model.Schedule;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;
/**
 *
 * @author 
 */
@WebServlet("/book-appointments")
public class AdminBookAppointmentServlet extends HttpServlet {
 private DoctorDAO doctorDAO   = new DoctorDAOImpl();
    private ScheduleDAO scheduleDAO = new ScheduleDAOImpl();
    private AppointmentDAO apptDAO = new AppointmentDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<Doctor> doctors = doctorDAO.findAll();
        req.setAttribute("doctors", doctors);
        String did = req.getParameter("doctorId");
        if (did != null && !did.isEmpty()) {
            try {
                int doctorId = Integer.parseInt(did);
                List<Schedule> slots = scheduleDAO.findByDoctorId(doctorId);
                req.setAttribute("schedules", slots);
                req.setAttribute("selectedDoctorId", doctorId);
            } catch (NumberFormatException ignore) { }
        }
        req.getRequestDispatcher("/admin/book-appointment.jsp")
           .forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // read posted fields
        int doctorId    = Integer.parseInt(req.getParameter("doctorId"));
        int scheduleId  = Integer.parseInt(req.getParameter("scheduleId"));
        String patientName  = req.getParameter("patientName");
        String patientEmail = req.getParameter("patientEmail");
        Appointment a = new Appointment();
        a.setDoctorId(doctorId);
        a.setScheduleId(scheduleId);
        a.setPatientName(patientName);
        a.setPatientEmail(patientEmail);
        a.setPaymentStatus("Pending");
        apptDAO.saveAppointment(a);
        HttpSession session = req.getSession();
        session.setAttribute("msg", "Appointment created (ID=" + a.getId() + ")");
        resp.sendRedirect(req.getContextPath() + "/book-appointments");
    }
}