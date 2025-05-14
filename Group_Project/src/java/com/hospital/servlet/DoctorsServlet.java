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
import javax.servlet.http.*;
import java.io.IOException;
import java.util.*;

@WebServlet("/view-doctors")
public class DoctorsServlet extends HttpServlet {
     private DoctorDAO doctorDAO = new DoctorDAOImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {      
        List<Doctor> doctorsList = doctorDAO.findAll();
        req.setAttribute("doctorsList", doctorsList);
        req.getRequestDispatcher("/doctor/doctors.jsp").forward(req, resp);
    }
}