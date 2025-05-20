<%-- 
    Document   : payment
    Created on : Apr 28, 2025, 1:34:31 AM
    Author     : 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Payment Page</title>
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
<h2>Payment Page</h2>
<p>Confirm your booking and pay.</p>
<form action="${pageContext.request.contextPath}/confirm-booking" method="post">
    <input type="hidden" name="doctorId"   value="${param.doctorId}"/>
    <input type="hidden" name="scheduleId" value="${param.scheduleId}"/>
    <input type="hidden" name="amount"      value="${doctor.fee}"/>
    <div>
      <label>Your Name:</label><br>
      <input type="text" name="patientName" required>
    </div>
    <div>
      <label>Your Email:</label><br>
      <input type="email" name="patientEmail" required>
    </div>
    <div>
      <label>Your Phone:</label><br>
      <input type="tel" name="patientPhone" pattern="\+?[0-9]{10,15}" placeholder="+9477xxxxxxx" required>
    </div>
    <br>
    <button type="submit">💳 Pay & Confirm</button>
    
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

    


