<%-- 
    Document   : doctor-logs
    Created on : Apr 27, 2025, 12:42:30 AM
    Author     : 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
  <title>Doctor Login | Hospital Management System</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/doctorlogs.css">
</head>
<body>
  <header>
      <img src="${pageContext.request.contextPath}/image/logo.jpg" alt="Hospital Logo" class="logo-right" >
      <h1> Healspire Medical Center</h1>
      <p>Inspiring Better Health, Every Day</p>
      <h2>Doctor Portal</h2>
  </header>

  <div class="form-container">
    <form action="doctorservlet" method="post">
      <h2 class="header">Doctor Login</h2>
      <div class="form-group">
        <label for="name">Doctor Name</label>
        <input id="name" type="text" name="name" placeholder="Enter your name" required />
      </div>
      <div class="form-group">
        <label for="id">Doctor ID</label>
        <input id="id" type="text" name="id" placeholder="Enter your ID" required />
      </div>
      <div class="form-group">
        <label for="password">Password</label>
        <input id="password" type="password" name="password" placeholder="Enter password" required />
      </div>
      <input type="submit" value="Login" />
      <a class="btn" href="error.jsp">Forgot Password?</a>
      <p><a href="${pageContext.request.contextPath}/dashboard">Back to Dashboard</a></p>
    </form>
    <div class="form-image"></div>
  </div>

  <footer>
      <section id="contact">
      <h2>Contact Us</h2>
      <p><strong>Address:</strong> 123 Health Ave, Wellness City</p>
      <p><strong>Phone:</strong> +1 (555) 123-4567</p>
      <p><strong>Email:</strong> info@HealspireMedicalCenter.com</p>
      <div id="map"><!-- Embed your map here --></div>
    </section>
    &copy; 2025 Our Hospital Management System - All Rights Reserved
  </footer>
</body>
</html>

