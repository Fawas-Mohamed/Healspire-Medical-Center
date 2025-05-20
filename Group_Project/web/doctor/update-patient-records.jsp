<%-- 
    Document   : update-patient-records
    Created on : Apr 27, 2025, 9:33:28 PM
    Author     : 
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Update Patient Records</title>
     <link rel="stylesheet" href="${pageContext.request.contextPath}/css/doctorupdaterecords.css">
</head>
<body>
    <header>
    <img src="${pageContext.request.contextPath}/image/logo.jpg" alt="Hospital Logo" class="logo-right" >
      <h1>Healspire Medical Center</h1>
  <p>Inspiring Better Health, Every Day</p>
  </header>

  <nav>
    <a href="${pageContext.request.contextPath}/doctor/doctor-dashboard.jsp" class="btn">Dashboard</a>
    <a href="${pageContext.request.contextPath}/logout" class="btn">Logout</a>
  </nav>
    <div class="container">
<h2>Update Patient Records</h2>

<% if (request.getAttribute("message") != null) { %>
    <p style="color:green;"><%= request.getAttribute("message") %></p>
<% } %>

<form method="post" action="update-patient-records">
    <label>Patient ID:</label><br>
    <input type="text" name="patientId" required><br><br>
    <label>Prescription:</label><br>
    <textarea name="prescription" rows="5" cols="30" required></textarea><br><br>

    <button type="submit">Update</button>
</form>
    </div>
    <footer>
      
      <h2>Contact Us</h2>
      <p><strong>Address:</strong> 123 Health Ave, Wellness City</p>
      <p><strong>Phone:</strong> +1 (555) 123-4567</p>
      <p><strong>Email:</strong> info@HealspireMedicalCenter.com</p>
      

    &copy; 2025 Hospital Management System — All Rights Reserved
  </footer>
</body>
</html>
