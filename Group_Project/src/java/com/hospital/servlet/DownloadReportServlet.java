/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.hospital.servlet;

import com.hospital.dao.TestReportDAO;
import com.hospital.dao.impl.TestReportDAOImpl;
import com.hospital.model.TestReport;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

/**
 *
 * @author 
 */
@WebServlet("/download-report")
public class DownloadReportServlet extends HttpServlet {
  private TestReportDAO dao = new TestReportDAOImpl();
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String idStr = req.getParameter("id");
    boolean inline = "true".equals(req.getParameter("inline"));
    if (idStr == null) {
      resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
      return;
    }
    TestReport r = dao.findById(Integer.parseInt(idStr));
    if (r == null) {
      resp.sendError(HttpServletResponse.SC_NOT_FOUND);
      return;
    }
    File f = new File(r.getFilePath());
    if (!f.exists()) {
      resp.sendError(HttpServletResponse.SC_NOT_FOUND);
      return;
    }
    resp.setContentType("application/pdf");
    String disposition = (inline ? "inline" : "attachment")
        + "; filename=\"" + r.getReportName() + ".pdf\"";
    resp.setHeader("Content-Disposition", disposition);
    resp.setContentLengthLong(f.length());
    try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(f));
         BufferedOutputStream out = new BufferedOutputStream(resp.getOutputStream())) {
      byte[] buffer = new byte[8192];
      int len;
      while ((len = in.read(buffer)) != -1) {
        out.write(buffer, 0, len);
      }
    }
  }
}
