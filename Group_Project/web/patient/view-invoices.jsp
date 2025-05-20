<%-- 
    Document   : view-invoices
    Created on : Apr 28, 2025, 1:35:58 AM
    Author     : 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.hospital.model.Payment" %>
<%@ page import="java.util.*,com.hospital.model.Invoice" %>
<%@ page import="java.util.List, com.hospital.model.Invoice" %>

<!DOCTYPE html>
<html>
<head><meta charset="UTF-8">
  <title>Your Invoices</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/invoice.css"><!-- comment -->
</head>
<body>
     <header>
    <img src="${pageContext.request.contextPath}/image/logo.jpg" alt="Hospital Logo" class="logo-right" >
      <h1>Welcome to Healspire Medical Center</h1>
  <p>Inspiring Better Health, Every Day</p>
  </header>

  <nav>
    <a href="${pageContext.request.contextPath}/patient/dashboard" class="btn">Dashboard</a>
    <a href="${pageContext.request.contextPath}/logout" class="btn">Logout</a>
  </nav>

  <main class="container">
  <h2 style="text-align: center" >Your Invoices</h2>
  <table>
       <thead>
    <tr><th>ID</th><th>Amount</th><th>Date</th><th>Download</th></tr>
    </thead>
      <tbody>
    <%
      List<Invoice> list = (List<Invoice>) request.getAttribute("invoices");
      if (list != null && !list.isEmpty()) {
        for (Invoice inv : list) {
    %>
    <tr>
      <td><%=inv.getId()%></td>
      <td>$<%=inv.getAmount()%></td>
      <td><%=inv.getCreatedAt()%></td>
      <td>
        <a href="<%=request.getContextPath()%>/download-invoice?invoiceId=<%=inv.getId()%>">
          Download PDF
        </a>
      </td>
    </tr>
    <%   }
      } else { %>
    <tr><td colspan="4">No invoices found.</td></tr>
    <% } %>
 </tbody>
    </table>
  <p><a href="<%=request.getContextPath()%>/patient/dashboard">Back to Dashboard</a></p>
   </main>

  <footer>
      <section id="contact">
      <h2>Contact Us</h2>
      <p><strong>Address:</strong> 123 Health Ave, Wellness City</p>
      <p><strong>Phone:</strong> +1 (555) 123-4567</p>
      <p><strong>Email:</strong> info@HealspireMedicalCenter.com</p>
      <div id="map"><!-- Embed your map here --></div>
    </section>
    &copy; 2025 Hospital Management System — All Rights Reserved
  </footer>
</body>
</html>
