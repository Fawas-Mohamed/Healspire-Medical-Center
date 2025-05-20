<%-- 
    Document   : adminassigned-appointments
    Created on : Apr 29, 2025, 10:36:46 PM
    Author     : 
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*, com.hospital.model.Appointment" %>
<!DOCTYPE html>
<html>
<head>
    <title>Assigned Appointments</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin-site.css">
</head>

<body>
     <header><img src="${pageContext.request.contextPath}/image/logo.jpg" alt="Hospital Logo" class="logo-right" >
      <h1> Healspire Medical Center</h1>
  <p>Inspiring Better Health, Every Day</p></header>
       <nav>
    <a href="${pageContext.request.contextPath}/admin/dashboard.jsp" class="btn">Dashboard</a>
    <a href="${pageContext.request.contextPath}/logout" class="btn">Logout</a>
  </nav>
  <main class="container">
      <h2 style="text-align: center">All Assigned Appointments</h2><br>
    <table>
      <thead>
        <tr>
          <th>ID</th><th>Doctor ID</th><th>Schedule ID</th><th>Patient Name</th>
          <th>Email</th><th>Date</th><th>Time</th><th>Payment</th><th>Booked At</th>
        </tr>
      </thead>
      <tbody>
    
        <%
            List<Appointment> list = (List<Appointment>) request.getAttribute("appointments");
            for (Appointment a : list) {
        %>
        <tr>
            <td><%= a.getId() %></td>
            <td><%= a.getDoctorId() %></td>
            <td><%= a.getScheduleId() %></td>
            <td><%= a.getPatientName() %></td>
            <td><%= a.getPatientEmail() %></td>
            <td><%= a.getAppointmentDate() %></td>
            <td><%= a.getAppointmentTime() %></td>
            <td><%= a.getPaymentStatus() %></td>
            <td><%= a.getBookedAt() %></td>
        </tr>
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
      <p><strong>Email:</strong> info@ourhospital.com</p>
      <div id="map"><!-- Embed your map here --></div>
    </section>
      &copy; 2025 Hospital Management System — All Rights Reserved</footer>
</body>
</html>

