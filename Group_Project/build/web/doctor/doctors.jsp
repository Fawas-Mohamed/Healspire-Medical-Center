<%-- 
    Document   : doctors
    Created on : Apr 28, 2025, 3:35:12 PM
    Author     : Fawas
--%>

<%@page import="com.hospital.model.Doctor"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>    
  <title>Available Doctors</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/viewdoctor.css">
</head>
<body>
    <header>
     <img src="${pageContext.request.contextPath}/image/logo.jpg" alt="Hospital Logo" class="logo-right" >
      <h1>Healspire Medical Center</h1>
  <p>Inspiring Better Health, Every Day</p>
</header>
<nav>
  <a href="${pageContext.request.contextPath}/patientdashboard.jsp" class="btn">Home</a>
  <a href="${pageContext.request.contextPath}/logout" class="btn">Logout</a>
</nav>

<main class="container">
<h2>Available Doctors</h2>
<table class="doctor-table">
<%
    List<Doctor> doctorsList = (List<Doctor>) request.getAttribute("doctorsList");
    if (doctorsList != null && !doctorsList.isEmpty()) {
        for (Doctor doc : doctorsList) {
%>
   <thead>
      <tr>
        <th>Name</th>
        <th>Specialization</th>
        <th>Fee</th>
        <th>Action</th>
      </tr>
    </thead>
    <tbody>
        
        <tr>
     <td>️ Dr. <%= doc.getName() %></td>
   <td><%= doc.getSpecialization() %>)</td>
     <td> $<%= doc.getFee() %> </td>
      <td>
      🔗 <a href="<%=request.getContextPath()%>/details?doctorId=<%=doc.getId()%>">View Details</a>
    </td>
        </tr>
<%
        }
    } else {
%>
    <li>No doctors found.</li>
<%
    }
%>
 </tbody>
  </table>
</main>
<footer>
     <section id="contact">
      <h2>Contact Us</h2>
      <p><strong>Address:</strong> 123 Health Ave, Wellness City</p>
      <p><strong>Phone:</strong> +1 (555) 123-4567</p>
      <p><strong>Email:</strong> info@HealspireMedicalCenter.com</p>
      <div id="map"><!-- Embed your map here --></div>
    </section>
  &copy; 2025 Our Hospital - All Rights Reserved
</footer>
</body>
</html>

