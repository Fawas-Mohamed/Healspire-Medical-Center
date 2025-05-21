
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>About Us | Hospital Management System</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/about.css">
</head>
<body>
   <header>
     <img src="${pageContext.request.contextPath}/image/logo.jpg" alt="Hospital Logo" class="logo-right" >
      <h1>Welcome to Healspire Medical Center</h1>
  <p>Inspiring Better Health, Every Day</p>
  </header>

  <nav>
    <a href="${pageContext.request.contextPath}/patient/dashboard" class="btn">Dashboard</a>
    <a href="${pageContext.request.contextPath}/logout" class="btn">Logout</a>
  </nav>

  <div class="content-container">
    <section class="about-section">
      <h2>Our Mission</h2>
      <p>
        At <strong>Our Hospital</strong>, we’re committed to providing compassionate,
        world‑class healthcare. Our mission is to blend cutting‑edge medical technology
        with a patient‑centered approach, ensuring each person who walks through our
        doors receives personalized and respectful care.
      </p>
    </section>

    <section class="about-section">
      <h2>Our Vision</h2>
      <p>
        We envision a healthier community where everyone has access to the best possible
        medical services. By continuously innovating and expanding our services, we aim
        to set new standards in healthcare excellence.
      </p>
    </section>
     <div class="video-gallery">
  <video controls autoplay muted loop width="600">
    <source src="${pageContext.request.contextPath}/video/hospital1.mp4" type="video/mp4">
    Your browser does not support the video tag.
  </video>
  <video controls autoplay muted loop width="600">
    <source src="${pageContext.request.contextPath}/video/hospital2.mp4" type="video/mp4">
    Your browser does not support the video tag.
  </video>
</div>


    <section class="about-section">
      <h2>Core Values</h2>
      <ul>
        <li><strong>Compassion:</strong> Caring for patients like family.</li>
        <li><strong>Integrity:</strong> Upholding the highest ethical standards.</li>
        <li><strong>Excellence:</strong> Delivering outstanding clinical outcomes.</li>
        <li><strong>Collaboration:</strong> Working together across disciplines.</li>
        <li><strong>Innovation:</strong> Embracing new ideas and technologies.</li>
      </ul>
    </section>
        <div class="gallery">
        <img src="${pageContext.request.contextPath}/image/hospital1.jpg" alt="Hospital Building" />
        <img src="${pageContext.request.contextPath}/image/hospital2.jpg" alt="Reception Area" />
        <img src="${pageContext.request.contextPath}/image/hospital3.jpg" alt="Operation Theatre" />
        <img src="${pageContext.request.contextPath}/image/hospital4.jpg" alt="Patient Care Ward" />
        </div><br><br>

    <section class="about-section">
      <h2>Contact Information</h2>
      <p><strong>Address:</strong> 123 Health Ave, Wellness City, Country</p>
      <p><strong>Phone:</strong> +1 (555) 123‑4567</p>
      <p><strong>Email:</strong> info@HealspireMedicalCenter.com</p>
    </section>
  </div>

  <footer>
      <section id="contact">
      <h2>Contact Us</h2>
      <p><strong>Address:</strong> MAHENWATHTHA, PITIPANA, HOMAGAMA, SRI LANKA</p>
      <p><strong>Phone:</strong> +1 (555) 123-4567</p>
      <p><strong>Email:</strong> info@ourhospital.com</p>
      <div id="map"><!-- Embed your map here --></div>
    </section>
    &copy; 2025 Our Hospital Management System – All Rights Reserved
  </footer>
</body>
</html>

