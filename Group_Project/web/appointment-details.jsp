<%-- 
    Document   : appointment-details
    Created on : Apr 28, 2025, 6:25:21 PM
    Author     : 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="com.hospital.model.Appointment" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <style>
    /* Override container width for form layout */
    main.container {
      max-width: 400px;
    }
    .form-group {
      margin-bottom: 1rem;
      text-align: left;
    }
    .form-group label {
      display: block;
      font-weight: bold;
      margin-bottom: 0.3rem;
    }
    .form-group input {
      width: 100%;
      padding: 0.6rem;
      border: 1px solid #ccc;
      border-radius: 4px;
      background: #f7f7f7;
    }
  </style>
  <meta charset="UTF-8">
  <title>Appointment Confirmed</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/viewdoctor.css">
</head>
<body>
    <header>
   <img src="${pageContext.request.contextPath}/image/logo.jpg" alt="Hospital Logo" class="logo-right" >
      <h1>Welcome to Healspire Medical Center</h1>
  <p>Inspiring Better Health, Every Day</p>
</header>
    


<nav>
  <a href="${pageContext.request.contextPath}/view-doctors" class="btn">Book Another Appointment</a>
  <a href="${pageContext.request.contextPath}/logout" class="btn">Logout</a>
</nav>
<main class="container">
    <%
        Appointment appt = (Appointment) request.getAttribute("appointment");
    %>
    <h2 class="text-center">Appointment Confirmed!</h2>
    <form>
      <div class="form-group">
        <label>Appointment ID</label>
        <input type="text" value="<%= appt.getId() %>" readonly>
      </div>
    <div class="form-group">
        <label>Doctor ID</label>
        <input type="text" value="<%= appt.getDoctorId() %>" readonly>
      </div>
     <div class="form-group">
        <label>Patient Name</label>
        <input type="text" value="<%= appt.getPatientName() %>" readonly>
      </div>
    <div class="form-group">
        <label>Patient Email</label>
        <input type="text" value="<%= appt.getPatientEmail() %>" readonly>
      </div>
      <div class="form-group">
        <label>Date</label>
        <input type="text" value="<%= appt.getAppointmentDate() %>" readonly>
      </div>
      <div class="form-group">
        <label>Time</label>
        <input type="text" value="<%= appt.getAppointmentTime() %>" readonly>
      </div>
      <div class="form-group">
        <label>Payment Status</label>
        <input type="text" value="<%= appt.getPaymentStatus() %>" readonly>
      </div>
      <div class="form-group">
        <label>Booked At</label>
        <input type="text" value="<%= appt.getBookedAt() %>" readonly>
      </div>
      <div class="text-center">
        <a href="${pageContext.request.contextPath}/view-doctors" class="btn">Book Another</a>
      </div>
    </form>
  
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