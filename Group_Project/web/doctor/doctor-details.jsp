<%-- 
    Document   : doctor-details
    Created on : Apr 28, 2025, 1:35:50 PM
    Author     : 
--%>

<%@page import="com.hospital.model.Schedule"%>
<%@page import="com.hospital.model.Doctor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head> <meta charset="UTF-8">
  <title>Doctor Details</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/viewdoctor.css">
</head>
<body>
    <header>
  <img src="${pageContext.request.contextPath}/image/logo.jpg" alt="Hospital Logo" class="logo-right" >
      <h1>Healspire Medical Center</h1>
  <p>Inspiring Better Health, Every Day</p>
   
</header>

<nav>
  <a href="${pageContext.request.contextPath}/view-doctors" class="btn">Back to Doctor List</a>
  <a href="${pageContext.request.contextPath}/logout" class="btn">Logout</a>
</nav>

<main class="container">
<%
    Doctor doctor = (Doctor) request.getAttribute("doctor");
    List<Schedule> schedules = (List<Schedule>) request.getAttribute("schedulesList");

    if (doctor != null) {
%>
    <h2>👨‍⚕️ Dr. <%= doctor.getName() %> (<%= doctor.getSpecialization() %>)</h2>
    <p>Fee: $<%= doctor.getFee() %></p>
    <h3 class="text-center">Availability</h3>
    <% if (schedules != null && !schedules.isEmpty()) { %>
    <table class="availability-table">
  <thead>
    <tr><th>Date</th><th>Time Slot</th><th>Book</th></tr>
  </thead>
  <tbody>
      
            <% for (Schedule s : schedules) { %>
               <tr>
                    <td><%= s.getScheduleDate() %></td>
                    <td> <%= s.getTimeSlot() %> </td>
                    <td>
                    <form action="<%= request.getContextPath() %>/book-appointment" method="post" style="display:inline;">
                        <input type="hidden" name="doctorId" value="<%= doctor.getId() %>">
                        <input type="hidden" name="scheduleId" value="<%= s.getId() %>">
                        <button type="submit">📅 Book Appointment</button>
                    </form>
              
      </tr>
            <% } %>
         </tbody>
         </table>
    <% } else { %>
        <p>No schedules available for this doctor.</p>
    <% } %>
<%
    } else {
%>
    <p>Doctor details not found.</p>
<%
    }
%>
<br>
<a href="<%= request.getContextPath() %>/view-doctors">🔙 Back to Doctor List</a>
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
