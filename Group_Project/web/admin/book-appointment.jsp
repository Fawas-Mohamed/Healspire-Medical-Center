<%-- 
    Document   : book-appointment
    Created on : May 1, 2025, 2:02:38 PM
    Author     : 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.hospital.model.Doctor, com.hospital.model.Schedule" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.List, com.hospital.model.Doctor, com.hospital.model.Schedule" %>
<!DOCTYPE html>
<html>
<head>
  <title>Admin: Book Appointment</title>
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
      <h2 style="text-align: center">Admin: Book Appointment</h2><br>
  <%
    String msg = (String) session.getAttribute("msg");
    if (msg != null) {
  %>
    <p style="color:green;"><%= msg %></p>
  <%
      session.removeAttribute("msg");
    }
  %>
  <form method="get" action="${pageContext.request.contextPath}/book-appointments">
    <label>Choose Doctor:</label>
    <select name="doctorId" required onchange="this.form.submit()">
      <option value="">-- select --</option>
      <%
        List<Doctor> docs = (List<Doctor>) request.getAttribute("doctors");
        Integer sel = (Integer) request.getAttribute("selectedDoctorId");
        if (docs != null) {
          for (Doctor d : docs) {
            boolean selected = (sel != null && sel.intValue() == d.getId());
      %>
        <option value="<%= d.getId() %>" <%= selected ? "selected" : "" %>>
          Dr. <%= d.getName() %> (<%= d.getSpecialization() %>)
        </option>
      <% 
          }
        }
      %>
    </select>
  </form>

  <%
    List<Schedule> schedules = (List<Schedule>) request.getAttribute("schedules");
    if (schedules != null) {
      if (schedules.isEmpty()) {
  %>
    <p>No schedule slots found for that doctor.</p>
  <%
      } else {
  %>
    <form method="post" action="${pageContext.request.contextPath}/book-appointments">
      <input type="hidden" name="doctorId" value="<%= request.getAttribute("selectedDoctorId") %>"/>
      <label>Choose Slot:</label>
      <table>
        <thead><tr><th>Select</th><th>Date</th><th>Time Slot</th></tr></thead>
        <tbody>
      <%
        for (Schedule s : schedules) {
      %>
       <tr>
        <td><input type="radio" name="scheduleId" value="<%= s.getId() %>" required></td>
          <td><%= s.getScheduleDate() %> </td>
        <td><%= s.getTimeSlot() %></td>
         </tr>
      <% } %>
    </tbody>
      </table>
      <label>Patient Name:</label><br/>
      <input type="text" name="patientName" required/><br/>
      <label>Patient Email:</label><br/>
      <input type="email" name="patientEmail" required/><br/><br/>
      <button type="submit">Create Appointment</button>
    </form>
  <%
      }
    }
  %>
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

  <p><a href="<%= request.getContextPath() %>/admin/dashboard">Back to Admin Dashboard</a></p>
</body>
</html>