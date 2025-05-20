<%-- 
    Document   : view-test-reports
    Created on : Apr 30, 2025, 1:19:24 AM
    Author     : 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List,com.hospital.model.TestReport" %>
<!DOCTYPE html>
<html>
<head><meta charset="UTF-8">
  <title>View Test Reports</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/invoice.css"></head>
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
<h2 style="text-align: center" >Your Test Reports</h2>
<table border="1" cellpadding="5">
  <tr><th>Name</th><th>Uploaded</th><th>View</th><th>Download</th></tr>
  <%
    List<TestReport> list = (List<TestReport>)request.getAttribute("reports");
    if (list != null && !list.isEmpty()) {
      for (TestReport r : list) {
  %>
  <tr>
    <td><%= r.getReportName() %></td>
    <td><%= r.getCreatedAt() %></td>
    <td>
      <a href="<%=request.getContextPath()%>/download-report?id=<%=r.getId()%>&inline=true">
        View
      </a>
    </td>
    <td>
      <a href="<%=request.getContextPath()%>/download-report?id=<%=r.getId()%>">
        Download
      </a>
    </td>
  </tr>
  <% }
    } else { %>
  <tr><td colspan="4">No reports found.</td></tr>
  <% } %>
</table>
<a href="<%=request.getContextPath()%>/patient/dashboard">Back to Dashboard</a>
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