<%-- 
    Document   : doctor-dashboard
    Created on : Apr 27, 2025, 7:11:45 PM
    Author     : 
--%>

<%@ page session="true" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Doctor Dashboard | Hospital Management System</title>  
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/doctor.css">
</head>
<body>
<%
    if (session == null || session.getAttribute("doctorId") == null) {
        response.sendRedirect(request.getContextPath() + "/doctor-logs.jsp");
        return;
    }
    String doctorName = (String) session.getAttribute("doctorName");
%>
<header>
     <img src="${pageContext.request.contextPath}/image/logo.jpg" alt="Hospital Logo" class="logo-right" >
     
      <h1>Healspire Medical Center</h1>
      <p>Inspiring Better Health, Every Day</p>
      
    
</header>
<nav>
    <a href="<%=request.getContextPath()%>/assigned-appointments" class="btn">See Assigned Appointments</a>
    <a href="<%=request.getContextPath()%>/update-patient-records" class="btn">Update Patient Records</a>
    <a href="<%=request.getContextPath()%>/doctor/view-reports" class="btn">View Test Reports</a>
    <a href="<%=request.getContextPath()%>/manage-schedules" class="btn">Manage Schedules</a>
    <a href="<%=request.getContextPath()%>/logout" class="btn">Logout</a>
</nav>

<p class="welcome-text" style="text-align: center">Welcome, <strong>Dr. <%= doctorName %> </strong> 👨‍⚕️👩‍⚕</p>
<div class="container">
    <p>1.Welcome to your dashboard. Select an option above to manage patients, appointments, and medical records.</p>

    <p>2.Use the menu above to view and manage your patients, schedule appointments, and update records.</p>

    <p>3.Choose an action above to access patient profiles, organize your appointments, or review clinical notes.</p>

    <p>Select from the options above to oversee patient care, book appointments, and manage records.</p>
</div><Br>

<footer>
     <section id="contact">
      <h2>Contact Us</h2>
      <p><strong>Address:</strong> 123 Health Ave, Wellness City</p>
      <p><strong>Phone:</strong> +1 (555) 123-4567</p>
      <p><strong>Email:</strong> info@HealspireMedicalCenter.com</p>
      <div id="map"><!-- Embed your map here --></div>
    </section>
    &copy; 2025 Hospital Management System - All Rights Reserved
</footer>
</body>
</html>

