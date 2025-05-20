<%-- 
    Document   : add‑user
    Created on : May 6, 2025, 10:09:47 PM
    Author     : 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
  <title>Manage Users</title>
   <link rel="stylesheet" href="${pageContext.request.contextPath}/css/manageuser.css">
</head>
<body>
    <header>
       <img src="${pageContext.request.contextPath}/image/logo.jpg" alt="Hospital Logo" class="logo-right" >
      <h1>Healspire Medical Center</h1>
  <p>Inspiring Better Health, Every Day</p>
  </header>
      <nav>
    <a href="${pageContext.request.contextPath}/admin/dashboard.jsp" class="btn">Dashboard</a>
    <a href="${pageContext.request.contextPath}/logout" class="btn">Logout</a>
  </nav>
      <div class="container">
  <h2>Add New User</h2>
  <form action="${pageContext.request.contextPath}/AddUserServlet" method="post">
  <div>
    <label>Full Name:</label>
    <input name="fullname" type="text" required>
  </div>
  <div>
    <label>Email:</label>
    <input name="email" type="email" required>
  </div>
  <div>
    <label>Password:</label>
    <input name="password" type="password" required>
  </div>
  <div>
    <label>Role:</label>
    <select name="role" required>
      <option value="">-- select role --</option>
      <option value="ADMIN">Admin</option>
      <option value="DOCTOR">Doctor</option>
      <option value="NURSE">Nurse</option>
      <!-- etc. -->
    </select>
  </div>
  <button type="submit">Save</button>
</form>

  <a href="${pageContext.request.contextPath}/admin/manage-users">Back to list</a>
      </div>
   <footer>
      <section id="contact">
      <h2>Contact Us</h2>
      <p><strong>Address:</strong> 123 Health Ave, Wellness City</p>
      <p><strong>Phone:</strong> +1 (555) 123-4567</p>
      <p><strong>Email:</strong> info@HealspireMedicalCenter.com</p>
      <div id="map"><!-- Embed your map here --></div>
    </section>
    &copy; 2025 Our Hospital. All rights reserved.
  </footer>
</body></html>
