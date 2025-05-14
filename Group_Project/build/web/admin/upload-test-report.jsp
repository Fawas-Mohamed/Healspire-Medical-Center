<%-- 
    Document   : upload-test-report
    Created on : May 2, 2025, 1:35:24 AM
    Author     : Fawas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.List, com.hospital.model.Patient" %>

<!DOCTYPE html>
<html>
<head><title>Upload Test Report</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin-site.css"><!-- comment --></head>
<body>
    <header><img src="${pageContext.request.contextPath}/image/logo.jpg" alt="Hospital Logo" class="logo-right" >
      <h1> Healspire Medical Center</h1>
  <p>Inspiring Better Health, Every Day</p></header>
         <nav>
    <a href="${pageContext.request.contextPath}/admin/dashboard.jsp" class="btn">Dashboard</a>
    <a href="${pageContext.request.contextPath}/logout" class="btn">Logout</a>
  </nav>
  <main class="container">
      <h2 style="text-align: center">Upload Test Report</h2><br>
<% String error = (String) request.getAttribute("error"); %>
<% if (error != null) { %>
  <div style="color:red"><%= error %></div>
<% } %>
<form method="post" action="<%=request.getContextPath()%>/admin/upload-test-report">
    <label>Select Patient:</label>
    <select name="patientId" required>
      <option value="">-- Select --</option>
      <% 
         List<Patient> patients = (List<Patient>) request.getAttribute("patientsList");
         if (patients != null) {
           for (Patient p : patients) {
      %>
        <option value="<%=p.getId()%>"><%=p.getFullName()%> (<%=p.getEmail()%>)</option>
      <%   }
         }
      %>
    </select><br/>
    <label>Report Name:</label><input type="text" name="reportName" required/><br/>
    <label>File Path:</label><input type="text" name="filePath" required/><br/>
    <button type="submit">Upload</button>
</form>
</main>
  <footer>
       <section id="contact">
      <h2>Contact Us</h2>
      <p><strong>Address:</strong> 123 Health Ave, Wellness City</p>
      <p><strong>Phone:</strong> +1 (555) 123-4567</p>
      <p><strong>Email:</strong> info@ourhospital.com</p>
      <div id="map"><!-- Embed your map here --></div>
    </section>
      &copy; 2025 Hospital Management System — All Rights Reserved</footer>
</body>
</html>