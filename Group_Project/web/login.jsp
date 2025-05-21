
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Hospital Management System</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
</head>
<body>

  <header>
       <img src="${pageContext.request.contextPath}/image/logo.jpg" alt="Hospital Logo" class="logo-right" >
      <h1>Welcome to Healspire Medical Center</h1>
  <p>Inspiring Better Health, Every Day</p>
  </header>

  <nav>
    <a href="${pageContext.request.contextPath}/patient/register.jsp" class="btn">Patient</a>
    <a href="${pageContext.request.contextPath}/doctor-logs.jsp" class="btn">Doctor Login</a>
    <a href="${pageContext.request.contextPath}/admin/user-logs.jsp" class="btn">Admin Login</a>
    <a href="${pageContext.request.contextPath}/about.jsp" class="btn">About Us</a>
  </nav>

  <div class="container">
      <h2 style="text-align: center">Patient Login</h2>
    <form method="post" action="${pageContext.request.contextPath}/patientlogin1">
      <label>Email:</label>
      <input type="text" name="email" required>
      <label>Password:</label>
      <input type="password" name="password" required>
      <button type="submit" class="btn">Login</button>
    </form>
      <p style="text-align: center">New patient? 
          <a href="${pageContext.request.contextPath}/patient/register.jsp" style="text-align: center">Register here</a>
    </p>

    <section id="about-us">
      <h2>About Us</h2>
      <p>Our Hospital is a leading healthcare provider offering world-class treatment and compassionate care...</p>
    </section>

    <section id="services">
      <h2>Our Services</h2>
      <ul>
        <li>24/7 Emergency Care</li>
        <li>Outpatient & Inpatient Services</li>
        <li>Advanced Diagnostic Imaging (MRI, CT, X-Ray)</li>
        <li>Laboratory Services</li>
        <li>Pharmacy</li>
        <li>Telemedicine Consultations</li>
      </ul>
    </section>

    <section id="departments">
      <h2>Departments</h2>
      <ul>
        <li>Cardiology</li>
        <li>Neurology</li>
        <li>Orthopedics</li>
        <li>Pediatrics</li>
        <li>Oncology</li>
        <li>Gynecology & Obstetrics</li>
        <li>General Surgery</li>
      </ul>
    </section>
  <footer>
      <section id="contact">
      <h2>Contact Us</h2>
      <p><strong>Address:</strong> MAHENWATHTHA, PITIPANA, HOMAGAMA, SRI LANKA</p>
      <p><strong>Phone:</strong> +1 (555) 123-4567</p>
      <p><strong>Email:</strong> info@HealspireMedicalCenter.com</p>
      <div id="map"><!-- Embed your map here --></div>
    </section>
    &copy; 2025 Our Hospital. All rights reserved.
  </footer>
</div>
</body>
</html>
