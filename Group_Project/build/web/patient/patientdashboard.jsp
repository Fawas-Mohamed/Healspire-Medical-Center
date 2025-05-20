<%-- 
    Document   : Patientdashbord
    Created on : Apr 27, 2025, 11:30:07 AM
    Author     : 
--%>

<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

<head>
  <meta charset="UTF-8">
  
  <title>Patient Dashboard</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/patientdashborad.css">
 
</head>
<body>

<%
    if (session == null || session.getAttribute("email") == null) {
        response.sendRedirect(request.getContextPath() + "/welcome.jsp");
        return;
    }
    String patientName = (String) session.getAttribute("patientName");
%>

<header>
       <img src="${pageContext.request.contextPath}/image/logo.jpg" alt="Hospital Logo" class="logo-right" >
      <h1>Welcome to Healspire Medical Center</h1>
  <p>Inspiring Better Health, Every Day</p>
</header>

<nav>
    <a href="${pageContext.request.contextPath}/view-doctors" class="btn">View Doctors</a>
        <a href="<%= request.getContextPath() %>/appointment-details" class="btn">View Appointments</a>
        <a href="<%=request.getContextPath()%>/view-invoices" class="btn">View Invoices</a>
        <a href="<%=request.getContextPath()%>/view-test-reports" class="btn">Report</a>
        <a href="<%=request.getContextPath()%>/logout" class="btn">Logout</a>
</nav>

<main>

        <p class="welcome-text">Welcome, <strong><%= patientName %></strong>! 👋</p>

   
       
   
   <div class="image-gallery">
  <figure class="gallery-item">
    <img src="${pageContext.request.contextPath}/image/doctor1.jpg" alt="Dr Namal">
    <figcaption>Dr Namal<br>Cardiologist</figcaption>
  </figure>
  <figure class="gallery-item">
    <img src="${pageContext.request.contextPath}/image/doctor4.jpg" alt="Dr Kamala">
    <figcaption>Dr Ravi<br>Neurologist</figcaption>
  </figure>
  <figure class="gallery-item">
    <img src="${pageContext.request.contextPath}/image/doctor6.jpg" alt="Dr Ravi">
    <figcaption>Dr Kamala<br>Pediatrician</figcaption>
  </figure>
  <figure class="gallery-item">
    <img src="${pageContext.request.contextPath}/image/doctor2.jpg" alt="Dr Amal">
    <figcaption>Dr Amanda<br>General Surgeon</figcaption>
  </figure>
  <figure class="gallery-item">
    <img src="${pageContext.request.contextPath}/image/doctor5.jpg" alt="Dr Smith">
    <figcaption>Dr Smith<br>Dermatologist</figcaption>
  </figure>
</div>

</main>
<footer>
     <section id="contact">
      <h2>Contact Us</h2>
      <p><strong>Address:</strong> 123 Health Ave, Wellness City</p>
      <p><strong>Phone:</strong> +1 (555) 123-4567</p>
      <p><strong>Email:</strong> info@HealspireMedicalCenter.com</p>
      
    </section>
    &copy; 2025 Our Hospital - All Rights Reserved
</footer>

</body>
</html>
