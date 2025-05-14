/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.hospital.servlet;

import com.hospital.dao.DoctorDAO;
import com.hospital.dao.impl.DoctorDAOImpl;
import com.hospital.model.Doctor;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/manage-doctors")
public class ManageDoctorsServlet extends HttpServlet {
   private DoctorDAO dao = new DoctorDAOImpl();
  @Override protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    List<Doctor> list = dao.findAll();
    req.setAttribute("doctorsList", list);
    req.getRequestDispatcher("/admin/manage-doctors.jsp").forward(req,resp);
  }
  @Override protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String action = req.getParameter("action");
    if("save".equals(action)) {
      Doctor d=new Doctor();
      d.setName(req.getParameter("name"));
      d.setSpecialization(req.getParameter("specialization"));
      d.setFee(Double.parseDouble(req.getParameter("fee")));
      d.setPassword(req.getParameter("password"));
      dao.save(d);
    } else if("delete".equals(action)) {
      dao.deleteById(Integer.parseInt(req.getParameter("doctorId")));
    }
    resp.sendRedirect(req.getContextPath()+"/admin/manage-doctors");
  }
}