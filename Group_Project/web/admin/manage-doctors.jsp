<%-- 
    Document   : manage-doctors
    Created on : Apr 27, 2025, 12:39:06?AM
    Author     : 
--%>

<%@ page import="java.util.List,com.hospital.model.Doctor" %>
<%@ page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <meta charset="UTF-8">
  <title>Manage Doctors</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin-site.css">
    </head>
    <body>
        <header><img src="${pageContext.request.contextPath}/image/logo.jpg" alt="Hospital Logo" class="logo-right" >
      <h1> Healspire Medical Center</h1>
  <p>Inspiring Better Health, Every Day</p>   
        </header>
      <nav>
    <a href="${pageContext.request.contextPath}/admin/dashboard.jsp" class="btn">Dashboard</a>
    <a href="${pageContext.request.contextPath}/logout" class="btn">Logout</a>
  </nav>
  <main class="container">
      <h2 style="text-align: center">Manage Doctors</h2><br>
<table border=1><tr><th>Id</th><th>Name</th><th>Specialization</th><th>Fee</th><th>Action</th></tr>
<%
  List<Doctor> doctors = (List<Doctor>) request.getAttribute("doctorsList");
  if (doctors != null) {
    for (Doctor d : doctors) {
%>
<tr>
  <td><%=d.getId()%></td>
  <td><%=d.getName()%></td>
  <td><%=d.getSpecialization()%></td>
  <td><%=d.getFee()%></td>
  <td>
    <form method="post" action="${pageContext.request.contextPath}/admin/manage-doctors"
      style="display:inline">
      <input type="hidden" name="action" value="delete">
      <input type="hidden" name="doctorId" value="<%=d.getId()%>">
      <button>Delete</button>
    </form>
  </td>
</tr>
<%
    }  
  }    
%>
</table><br>
<h3 >Add Doctor</h3><br>
<form method="post" action="${pageContext.request.contextPath}/admin/manage-doctors">
  <input type="hidden" name="action" value="save">
  
  Name:   <input name="name" required><br>
  Spec    :   <input name="specialization" required><br>
  Fee:    <input name="fee" required><br>
  Password: <input name="password" required/><br>
  <button>Add</button>
</form>
  </main>
  <footer>
       <section id="contact">
      <h2>Contact Us</h2>
      <p><strong>Address:</strong> 123 Health Ave, Wellness City</p>
      <p><strong>Phone:</strong> +1 (555) 123-4567</p>
      <p><strong>Email:</strong> info@ourhospital.com</p>
      
    </section>&copy; 2025 Hospital Management System — All Rights Reserved</footer>
</body></html>
