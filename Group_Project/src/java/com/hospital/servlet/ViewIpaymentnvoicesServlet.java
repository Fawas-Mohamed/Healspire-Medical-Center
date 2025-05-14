/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.hospital.servlet;

import com.hospital.dao.InvoiceDAO;
import com.hospital.dao.PaymentDAO;
import com.hospital.dao.impl.PaymentDAOImpl;
import com.hospital.model.Payment;
import com.hospital.dao.impl.InvoiceDAOImpl;
import com.hospital.model.Invoice;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;
import com.hospital.dao.InvoiceDAO;

@WebServlet("/view-invoices")
public class ViewIpaymentnvoicesServlet extends HttpServlet {
   private InvoiceDAO dao = new InvoiceDAOImpl();
   @Override 
   protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
    HttpSession session = req.getSession(false);
    if (session == null || session.getAttribute("patientId") == null) {
      resp.sendRedirect(req.getContextPath() + "/login.jsp");
      return;
    }
    int patientId = (Integer) session.getAttribute("patientId");
    List<Invoice> invoices = dao.findByPatientId(patientId);
    req.setAttribute("invoices", invoices);
    req.getRequestDispatcher("/patient/view-invoices.jsp").forward(req, resp);
  }
}