<%-- 
    Document   : register
    Created on : Apr 27, 2025, 12:37:06 AM
    Author     : 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Register | Hospital Management System</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/patientregister.css">
</head>
<body>
     <header>
        <img src="${pageContext.request.contextPath}/image/logo.jpg" alt="Hospital Logo" class="logo-right" >
      <h1>Welcome to Healspire Medical Center</h1>
      <p>Inspiring Better Health, Every Day</p>
      <h2>Patient Protol</h2>
    </header>
   <div class="form-container">
  <div class="form-left">
    <h2>Register</h2>
     <form  action="patientregister" method="post" > 
       <div class="form-group">
            <label>Full Name:</label>
            <input type="text" name="fullName" required />
       </div>
       
            <div class="form-group">
        <label>Email:</label>
        <input type="email" name="email" required />
      </div>
      <div class="form-group">
        <label>Password:</label>
        <input type="password" name="password" required />
      </div>
      <div class="form-group">
        <label>Contact No:</label>
        <input type="number" name="contactNo" required />
      </div>
      <div class="form-group">
        <label>Gender:</label>
        <select name="gender" required>
          <option value="Male">Male</option>
          <option value="Female">Female</option>
          <option value="Other">Other</option>
        </select>
      </div>
      <div class="form-group">
        <label>Date of Birth:</label>
        <input type="date" name="dob" />
      </div>
      <input type="submit" value="Register" />
    </form>
    <p>Already have an account? <a href="${pageContext.request.contextPath}/patient/login.jsp" class="btn">Login here</a></p>
  </div>
  <div class="form-image"></div>
</div>
   <div class="instructions">
  <h3>Instructions</h3>
  <ul>
    <li>Reports can be best viewed on Google Chrome (version 40.0.2214 and above), Mozilla Firefox (version 38 and above), and Internet Explorer (version 9 and above).</li>
    <li>Users need to activate the "Compatibility View" option under the "Tools" menu in Internet Explorer.</li>
    <li>HIV reports are not available on the website.</li>
    <li>Hospital IPD Patient reports are not available on the website.</li>
    <li>Login via OTP is only available for patients on the website.</li>
  </ul>
  
</div>

     <footer>
         <section id="contact">
      <h2>Contact Us</h2>
      <p><strong>Address:</strong> 123 Health Ave, Wellness City</p>
      <p><strong>Phone:</strong> +1 (555) 123-4567</p>
      <p><strong>Email:</strong> info@HealspireMedicalCenter.com</p>
    </section>
        &copy; 2025 Hospital Management System. All rights reserved.
    </footer>
</body>
</html>
