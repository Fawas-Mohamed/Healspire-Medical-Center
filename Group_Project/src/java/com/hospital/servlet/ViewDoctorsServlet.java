/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.hospital.servlet;

import com.hospital.dao.DoctorDAO;
import com.hospital.dao.ScheduleDAO;
import com.hospital.dao.impl.DoctorDAOImpl;
import com.hospital.dao.impl.ScheduleDAOImpl;
import com.hospital.model.Doctor;
import com.hospital.model.Schedule;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 
 */
@WebServlet("/details")
public class ViewDoctorsServlet extends HttpServlet {
    private DoctorDAO doctorDAO = new DoctorDAOImpl();
    private ScheduleDAO scheduleDAO = new ScheduleDAOImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        String doctorIdStr = req.getParameter("doctorId");
        if (doctorIdStr != null) {
            int doctorId = Integer.parseInt(doctorIdStr);
            Doctor doctor = doctorDAO.findById(doctorId);
            List<Schedule> schedulesList = scheduleDAO.findByDoctorId(doctorId);
            req.setAttribute("doctor", doctor);
            req.setAttribute("schedulesList", schedulesList);
            req.getRequestDispatcher("/doctor/doctor-details.jsp").forward(req, resp);
        } else {
            resp.sendRedirect(req.getContextPath() + "/view-doctors");
        }
    }
}