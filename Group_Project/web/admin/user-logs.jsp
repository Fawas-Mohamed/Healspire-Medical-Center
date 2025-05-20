<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Admin Login | Hospital Management System</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/adminlog.css">
</head>
<body>
  <header>
   <img src="${pageContext.request.contextPath}/image/logo.jpg" alt="Hospital Logo" class="logo-right" >
      <h1> Healspire Medical Center</h1>
      <p>Inspiring Better Health, Every Day</p>
      <h2>Admin Portal</h2>
  </header>

  <div class="form-container">
    <div class="form-left">
      <h2>Admin Login/Logout</h2>
      <form action="${pageContext.request.contextPath}/admin/login" method="post">
        <div class="form-group">
          <label for="email">User name</label>
          <input type="text" id="email" name="email" placeholder="Enter username" required />
        </div>
        <div class="form-group">
          <label for="password">Password</label>
          <input type="password" id="password" name="password" placeholder="Enter password" required />
        </div>
        <input type="submit" value="Login" class="btn-login"/>
      </form>
      <a class="forgot-btn" href="${pageContext.request.contextPath}/error.jsp">Forgot Password?</a>
    </div>
    <div class="form-image"></div>
  </div>
  <footer>
       <section id="contact">
      <h2>Contact Us</h2>
      <p><strong>Address:</strong> MAHENWATHTHA, PITIPANA, HOMAGAMA, SRI LANKA</p>
      <p><strong>Phone:</strong> +1 (555) 123-4567</p>
      <p><strong>Email:</strong> info@ourhospital.com</p>
      <div id="map"></div>
    </section>
    &copy; 2025 Hospital Management System — All Rights Reserved
  </footer>

</body>
</html>
