/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.hospital.servlet;

import com.hospital.dao.DoctorDAO;
import com.hospital.dao.LogDAO;
import com.hospital.dao.impl.DoctorDAOImpl;
import com.hospital.dao.impl.LogDAOImpl;
import com.hospital.model.Doctor;
import com.hospital.model.LogEntry;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpSession;

@WebServlet("/doctorservlet")
public class DoctorLogsServlet extends HttpServlet {
    private LogDAO logDAO = new LogDAOImpl();
    private DoctorDAO dacdao=new DoctorDAOImpl();   
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<LogEntry> logs = logDAO.findAllDoctorLogs();
        req.setAttribute("logsList", logs);
         String id = req.getParameter("id");
        String password = req.getParameter("password");
        String name = req.getParameter("name");        
        DoctorDAO dao = new DoctorDAOImpl() {};
        Doctor user = dao.validateUser(id, password,name);
        if (user != null) {
            HttpSession session = req.getSession();
            session.setAttribute("doctorId", user.getId());    // 👍
            session.setAttribute("doctorName", user.getName());
            resp.sendRedirect("doctor/doctor-dashboard.jsp");
        } else {
            resp.sendRedirect("error.jsp");
        }
    }}
    

