/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.hospital.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.hospital.dao.PatientDAO;
import com.hospital.dao.impl.PatientDAOImpl;
import com.hospital.model.Patient;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/patientlogin1")
public class PatientLoginServlet extends HttpServlet {
  private PatientDAO userDAO = new PatientDAOImpl();

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String email    = req.getParameter("email");
    String password = req.getParameter("password");
    String fullName = req.getParameter("fullName");
     PatientDAO dao = new PatientDAOImpl() {};
        Patient user = dao.validateUser(email, password);
        if (user != null) {
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            session.setAttribute("patientName", fullName);
            session.setAttribute("email",email);
            session.setAttribute("patientId",   user.getId());
            session.setAttribute("patientName", user.getFullName());
            
            resp.sendRedirect("patient/patientdashboard.jsp");
        } else {
            req.setAttribute("loginError", "Invalid email or password");
            resp.sendRedirect("error.jsp");
        }}}

    /*Optional<Patient> optUser = userDAO.findByUsernameAndPassword(email, password);
    if (optUser.isPresent()) {
      HttpSession session = req.getSession(true);
      session.setAttribute("patientId", optUser.get().getId());
      session.setAttribute("patientName", optUser.get().getFullName());
      // ✅ Correct Redirect
      resp.sendRedirect(req.getContextPath() + "/patientdashboard");
    } else {
      req.setAttribute("loginError", "Invalid email or password");
      req.getRequestDispatcher("/patientdashboard.jsp").forward(req, resp);
    }
  }
}
*/