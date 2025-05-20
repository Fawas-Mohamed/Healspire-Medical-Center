<%-- 
    Document   : dashboard
    Created on : Apr 27, 2025, 12:37:46 AM
    Author     : 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
<head>
   <meta charset="UTF-8">
  <title>Dashboard | Hospital Management System</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admindashborad.css">
</head>
<body>
     <header>
    <img src="${pageContext.request.contextPath}/image/logo.jpg" alt="Hospital Logo" class="logo-right" >
      <h1>Welcome to Healspire Medical Center</h1>
  <p>Inspiring Better Health, Every Day</p>
    <h2>Welcome to the Admin Panel</h2>
  </header>
      <nav>
       <a href="<%=request.getContextPath()%>/logout" class="btn">Logout</a>
       <a href="<%=request.getContextPath()%>/about.jsp" class="btn">About Us</a>
      </nav>
  <main class="container" style="align-items: center">
      <div class="dashboard-card">
        <div class="dashboard-nav">
            <a href="<%=request.getContextPath()%>/admin/manage-users" class="btn" >Manage Users</a><br><br><br>
            <a href="<%=request.getContextPath()%>/admin/manage-doctors" class="btn">Manage Doctors</a><br><br>
            <a href="<%=request.getContextPath()%>/adminAssignedAppointmentsServlet" class="btn">Appointment History</a><br><br>
            <a href="<%=request.getContextPath()%>/book-appointments" class="btn">Book Appointment</a><br><br>
            <a href="<%=request.getContextPath()%>/change-password" class="btn">Change Password</a><br><br>
            <a href="<%=request.getContextPath()%>/admin/manage-nurses" class="btn">Manage nurse</a><br><br>
            <a href="<%=request.getContextPath()%>/admin/upload-test-report" class="btn">Upload Reports</a><br><br>  
        </div>
</div>
     </main>
  <footer>
       <section id="contact">
      <h2>Contact Us</h2>
      <p><strong>Address:</strong> 123 Health Ave, Wellness City</p>
      <p><strong>Phone:</strong> +1 (555) 123-4567</p>
      <p><strong>Email:</strong> info@ourhospital.com</p>
      <div id="map"><!-- Embed your map here --></div>
    </section>
    &copy; 2025 Hospital Management System — All Rights Reserved
  </footer>
</body>
</html>

