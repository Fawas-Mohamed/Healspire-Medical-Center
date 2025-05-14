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
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.List;

/**
 *
 * @author Fawas
 */
@WebServlet("/admin/upload-test-report")
public class AdminUploadTestReportServlet extends HttpServlet {
 private PatientDAO patientDAO = new PatientDAOImpl();
    private TestReportDAO reportDAO = new TestReportDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // load all patients
        List<Patient> patients = patientDAO.findAll();
        req.setAttribute("patientsList", patients);
        req.getRequestDispatcher("/admin/upload-test-report.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("patientId");
        String name = req.getParameter("reportName");
        String path = req.getParameter("filePath");
        if (idStr == null || name.isEmpty() || path.isEmpty()) {
            req.setAttribute("error", "All fields are required.");
            doGet(req, resp);
            return;
        }
        try {
            int pid = Integer.parseInt(idStr);
            TestReport r = new TestReport();
            r.setPatientId(pid);
            r.setReportName(name);
            r.setFilePath(path);
            reportDAO.save(r);
            resp.sendRedirect(req.getContextPath() + "/admin/upload-test-report?success=true");
        } catch (NumberFormatException e) {
            req.setAttribute("error", "Invalid patient ID.");
            doGet(req, resp);
        }
    }
}