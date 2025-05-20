<%-- 
    Document   : assigned-appointments
    Created on : Apr 29, 2025, 9:46:10 PM
    Author     : 
--%>

<%@page import="com.hospital.model.Appointment"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Assigned Appointments</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/ass-appoinment.css"><!-- comment --></head>
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
<h2>Assigned Appointments</h2>
<table border="1" cellpadding="10">
    <tr>
        <th>Appointment ID</th>
        <th>Doctor ID</th>
        <th>Patient Name</th>
        <th>Patient Email</th>
        <th>Date</th>
        <th>Time Slot</th>
        <th>Payment Status</th>
    </tr>
    <%
        List<Appointment> appointments = (List<Appointment>) request.getAttribute("appointments");
        if (appointments != null && !appointments.isEmpty()) {
            for (Appointment a : appointments) {
    %>
        <tr>
    <td><%= a.getId() %></td>
    <td><%= a.getDoctorId() %></td>
    <td><%= a.getPatientName() %></td>
    <td><%= a.getPatientEmail() %></td>
    <td><%= a.getAppointmentDate() %></td>
    <td><%= a.getAppointmentTime() %></td>
    <td><%= a.getPaymentStatus() %></td>
   
</tr>
    <%
            }
        } else {
    %>
        <tr><td colspan="6">No appointments found.</td></tr>
    <%
        }
    %>
</table>
  <a class="back-link" href="${pageContext.request.contextPath}/doctor/dashboard">Back to Dashboard</a>
    </div><br><br><br><br>
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

