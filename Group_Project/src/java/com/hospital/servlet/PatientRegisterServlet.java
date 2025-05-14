/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.hospital.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet("/patient/patientregister")
public class PatientRegisterServlet extends HttpServlet {
    private static final String URL = "jdbc:mysql://localhost:3306/hospital_db";
    private static final String USER = "root";
    private static final String PASS = "";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fullName = req.getParameter("fullName");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String contactNo = req.getParameter("contactNo");
        String gender = req.getParameter("gender");
        String dob = req.getParameter("dob");

        // Validate required fields including non-empty DOB
        if (fullName == null || fullName.trim().isEmpty()
            || email == null || email.trim().isEmpty()
            || password == null || password.trim().isEmpty()
            || contactNo == null || contactNo.trim().isEmpty()
            || gender == null || gender.trim().isEmpty()
            || dob == null || dob.trim().isEmpty()) {
            resp.sendRedirect("register.jsp?msg=error&reason=Missing+fields");
            return;
        }

        String sql = "INSERT INTO patient(fullName,email,password,contact_no,gender,dob,created_at) VALUES (?,?,?,?,?,?,?)";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new ServletException("MySQL Driver not found", e);
        }

        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement pst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pst.setString(1, fullName);
            pst.setString(2, email);
            pst.setString(3, password);
            pst.setString(4, contactNo);
            pst.setString(5, gender);
            // safe parse of dob
            java.util.Date parsedDob = new SimpleDateFormat("yyyy-MM-dd").parse(dob);
            pst.setDate(6, new java.sql.Date(parsedDob.getTime()));
            pst.setTimestamp(7, new Timestamp(System.currentTimeMillis()));

            int affected = pst.executeUpdate();
            if (affected == 0) {
                throw new SQLException("Creating patient failed, no rows affected.");
            }

            try (ResultSet generatedKeys = pst.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int patientId = generatedKeys.getInt(1);
                    HttpSession session = req.getSession();
                    session.setAttribute("patientId", patientId);
                    session.setAttribute("patientName", fullName);
                    session.setAttribute("email", email);
                    resp.sendRedirect("patientdashboard.jsp?msg=registered");
                    return;
                } else {
                    throw new SQLException("Creating patient failed, no ID obtained.");
                }
            }
        } catch (ParseException pe) {
            String reason = URLEncoder.encode("Invalid+date+format", StandardCharsets.UTF_8);
            resp.sendRedirect("register.jsp?msg=error&reason=" + reason);
        } catch (Exception e) {
            e.printStackTrace();
            String reason = URLEncoder.encode(e.getMessage(), StandardCharsets.UTF_8);
            resp.sendRedirect("register.jsp?msg=error&reason=" + reason);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("register.jsp");
    }
}


/*@WebServlet("/patientregister")
public class PatientRegisterServlet extends HttpServlet {
    private PatientDAO da = new PatientDAOImpl();

    /**
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
  
   
      /**  Patient p = new Patient();
        String fullName = req.getParameter("fullName");
        String email = req.getParameter("email");
        String password = req.getParameter("password");  // consider hashing the password
        String contactNo = req.getParameter("contactNo");
        String gender = req.getParameter("gender");
        String dob = req.getParameter("dob");

        // Ensure parameters are not null or empty
        if (fullName == null || email == null || password == null || contactNo == null || gender == null || dob == null) {
            resp.sendRedirect("register.jsp?msg=error&reason=Missing+fields");
            return;
        }

        // Set the patient details
        p.setFullName(fullName);
        p.setEmail(email);
        p.setPassword(password); // You might want to hash the password
        p.setContact_no(contactNo);
        p.setGender(gender);

        // Handle date of birth (DOB)
        try {
            if (dob != null && !dob.isEmpty()) {
                p.setDob(new SimpleDateFormat("yyyy-MM-dd").parse(dob));
            }
        } catch (Exception e) {
            // If there's an issue parsing the date, log it and redirect with an error
            resp.sendRedirect("register.jsp?msg=error&reason=Invalid+DOB");
            return;
        }

        // Save the patient object to the database
        try {
            a.save(p);
            // Redirect to the patient dashboard with a success message
            resp.sendRedirect("patientdashboard.jsp?msg=registered");
        } catch (Exception e) {
            // Handle database error and redirect to registration page with an error
            resp.sendRedirect("register.jsp?msg=error&reason=Database+Error");
            e.printStackTrace();
        }
    }
*/
