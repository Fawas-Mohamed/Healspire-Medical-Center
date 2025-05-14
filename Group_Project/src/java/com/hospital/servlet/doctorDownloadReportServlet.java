/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.hospital.servlet;

import com.hospital.dao.TestReportDAO;
import com.hospital.dao.impl.TestReportDAOImpl;
import com.hospital.model.TestReport;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Fawas
 */
@WebServlet("/doctor/view-reports1")
public class doctorDownloadReportServlet extends HttpServlet {
 private TestReportDAO reportDAO = new TestReportDAOImpl();

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String idStr = req.getParameter("id");
    String inline = req.getParameter("inline");

    if (idStr == null) {
      resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing report ID.");
      return;
    }

    int reportId = Integer.parseInt(idStr);
    TestReport report = reportDAO.findById(reportId);

    if (report == null) {
      resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Report not found.");
      return;
    }

    File file = new File(report.getFilePath());
    if (!file.exists()) {
      resp.sendError(HttpServletResponse.SC_NOT_FOUND, "File not found.");
      return;
    }

    String mimeType = getServletContext().getMimeType(file.getName());
    if (mimeType == null) mimeType = "application/octet-stream";

    resp.setContentType(mimeType);
    String disposition = "inline".equals(inline) ? "inline" : "attachment";
    resp.setHeader("Content-Disposition", disposition + "; filename=\"" + file.getName() + "\"");

    try (FileInputStream in = new FileInputStream(file);
         OutputStream out = resp.getOutputStream()) {
      byte[] buffer = new byte[4096];
      int bytesRead;
      while ((bytesRead = in.read(buffer)) != -1) {
        out.write(buffer, 0, bytesRead);
      }
    }
  }
}