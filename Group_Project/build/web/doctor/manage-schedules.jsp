<%-- 
    Document   : manage-schedules
    Created on : Apr 27, 2025, 9:37:40 PM
    Author     : 
--%>

<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Doctor: Manage Schedules</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/manage-schedules.css">
</head>
<body>
     <header>
    <img src="${pageContext.request.contextPath}/image/logo.jpg" alt="Hospital Logo" class="logo-right" >
      <h1>Welcome to Healspire Medical Center</h1>
  <p>Inspiring Better Health, Every Day</p>
  </header>
      <nav>
    <a href="${pageContext.request.contextPath}/doctor/doctor-dashboard.jsp" class="btn">Dashboard</a>
    <a href="${pageContext.request.contextPath}/logout" class="btn">Logout</a>
  </nav>

    <div class="container">
        <h2>Manage Your Schedules</h2>

        <% if (request.getAttribute("message") != null) { %>
            <div class="message"><%= request.getAttribute("message") %></div>
        <% } %>

        <form method="post" action="manage-schedules" class="schedule-form">
            <label for="date">Date:</label>
            <input type="date" name="date" id="date" required>

            <label for="timeSlot">Time Slot:</label>
            <input type="text" name="timeSlot" id="timeSlot" placeholder="e.g. 10:00 AM - 11:00 AM" required>

            <button type="submit">Save Schedule</button>
        </form>

        <h3>Your Schedules</h3>
        <table>
            <thead>
                <tr>
                    <th>Date</th>
                    <th>Time Slot</th>
                </tr>
            </thead>
            <tbody>
                <%
                    List<com.hospital.model.Schedule> schedulesList = 
                        (List<com.hospital.model.Schedule>) request.getAttribute("schedulesList");
                    if (schedulesList != null && !schedulesList.isEmpty()) {
                        for (com.hospital.model.Schedule schedule : schedulesList) {
                %>
                <tr>
                    <td><%= schedule.getScheduleDate() %></td>
                    <td><%= schedule.getTimeSlot() %></td>
                </tr>
                <%   }
                    } else {
                %>
                <tr><td colspan="2">No schedules available.</td></tr>
                <% } %>
            </tbody>
        </table>

        <a class="back-link" href="${pageContext.request.contextPath}/doctor/dashboard">Back to Dashboard</a>
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
