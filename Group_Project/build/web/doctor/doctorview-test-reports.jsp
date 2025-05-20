<%-- 
    Document   : doctorview-test-reports
    Created on : May 2, 2025, 1:37:25 AM
    Author     : 
--%>

<%@page import="com.hospital.model.Patient"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List, com.hospital.model.Patient, com.hospital.model.TestReport" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Doctor: View Patient Reports</title>
  <!-- Link to your CSS -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/doctorviewreport.css">
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

  <div class="container">
    <h2>View Test Reports</h2>

    <form method="get" action="${pageContext.request.contextPath}/doctor/view-reports">
      <label for="patientSelect">Select Patient:</label>
      <select id="patientSelect" name="patientId" required onchange="this.form.submit()">
        <option value="">-- select --</option>
        <%
          List<Patient> pts = (List<Patient>) request.getAttribute("patientsList");
          Integer sel = (Integer) request.getAttribute("selectedPatientId");
          if (pts != null) {
            for (Patient p : pts) {
              boolean selected = (sel != null && sel.equals(p.getId()));
        %>
          <option value="<%= p.getId() %>" <%= selected ? "selected" : "" %>>
            <%= p.getFullName() %> (&lt;<%= p.getEmail() %>&gt;)
          </option>
        <%  }
          }
        %>
      </select>
    </form>

    <%
      List<TestReport> reps = (List<TestReport>) request.getAttribute("reportsList");
      if (reps != null) {
        if (reps.isEmpty()) {
    %>
      <p>No reports for this patient.</p>
    <%
        } else {
    %>
      <table>
        <thead>
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Uploaded</th>
            <th>View</th>
          </tr>
        </thead>
        <tbody>
          <% for (TestReport r : reps) { %>
          <tr>
            <td><%= r.getId() %></td>
            <td><%= r.getReportName() %></td>
            <td><%= r.getCreatedAt() %></td>
            <td>
              <a href="${pageContext.request.contextPath}/download-report?id=<%= r.getId() %>&inline=true"
                 target="_blank">Open</a>
            </td>
          </tr>
          <% } %>
        </tbody>
      </table>
    <%
        }
      }
    %>

    <a href="${pageContext.request.contextPath}/doctor/dashboard" class="back-link">
      Back to Dashboard
    </a>
  </div>
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
