/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.hospital.servlet;

import com.hospital.dao.ScheduleDAO;
import com.hospital.dao.impl.ScheduleDAOImpl;
import com.hospital.model.Schedule;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.util.List;
/**
 *
 * @author 
 */
@WebServlet("/manage-schedules")
public class ManageSchedulesServlet extends HttpServlet {
    private ScheduleDAO dao = new ScheduleDAOImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
         HttpSession session = req.getSession(false);
    if (session == null || session.getAttribute("doctorId") == null) {
        resp.sendRedirect(req.getContextPath() + "/doctor-logs.jsp");
        return;
    }
    int docId = (Integer) session.getAttribute("doctorId");
    List<Schedule> list = dao.findByDoctorId(docId);
    req.setAttribute("schedulesList", list);
    req.getRequestDispatcher("/doctor/manage-schedules.jsp").forward(req, resp);
}
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
         throws ServletException, IOException {
    // 1) verify doctor is logged in
    HttpSession session = req.getSession(false);
    if (session == null || session.getAttribute("doctorId")==null) {
      resp.sendRedirect(req.getContextPath()+"/doctor-logs.jsp");
      return;
    }
    int docId = (Integer)session.getAttribute("doctorId");
    java.sql.Date date = java.sql.Date.valueOf(req.getParameter("date"));
    String slot = req.getParameter("timeSlot");
    Schedule s = new Schedule();
    s.setDoctorId(docId);
    s.setScheduleDate(date);
    s.setTimeSlot(slot);
    dao.save(s);
    req.setAttribute("message","Schedule saved");
    req.getRequestDispatcher("/doctor/manage-schedules.jsp").forward(req, resp);
  }
}