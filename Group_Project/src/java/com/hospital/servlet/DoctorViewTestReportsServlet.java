/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.hospital.servlet;

import com.hospital.dao.PatientDAO;
import com.hospital.dao.TestReportDAO;
import com.hospital.dao.impl.PatientDAOImpl;
import com.hospital.dao.impl.TestReportDAOImpl;
import com.hospital.model.Patient;
import com.hospital.model.TestReport;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 
 */
@WebServlet("/doctor/view-reports")
public class DoctorViewTestReportsServlet extends HttpServlet {
    private PatientDAO patientDAO = new PatientDAOImpl();
    private TestReportDAO reportDAO = new TestReportDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<Patient> patients = patientDAO.findAll();
        req.setAttribute("patientsList", patients);
        String pid = req.getParameter("patientId");
        if (pid != null && !pid.isEmpty()) {
            try {
                int patientId = Integer.parseInt(pid);
                List<TestReport> reports = reportDAO.findByPatientId(patientId);
                req.setAttribute("reportsList", reports);
                req.setAttribute("selectedPatientId", patientId);
            } catch (NumberFormatException ignore) {}
        }
        req.getRequestDispatcher("/doctor/doctorview-test-reports.jsp")
           .forward(req, resp);
    }
}