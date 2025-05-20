<%-- 
    Document   : manage-nurses
    Created on : Apr 30, 2025, 12:49:15 AM
    Author     : 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List,com.hospital.model.Nurse" %>
<!DOCTYPE html>
<html>
<head><title>Manage Nurses</title>
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

      <h2 style="text-align: center">Manage Nurses</h2><br>
<table>
  <tr><th>Id</th><th>Name</th><th>Email</th><th>Spec</th><th>Action</th></tr>
  <%
    List<Nurse> nurses = (List<Nurse>) request.getAttribute("nursesList");
    if (nurses != null) {
      for (Nurse n: nurses) {
  %>
  <tr>
    <td><%= n.getId() %></td>
    <td><%= n.getName() %></td>
    <td><%= n.getEmail() %></td>
    <td><%= n.getSpecialization() %></td>
    <td>
      <form method="post" action="<%=request.getContextPath()%>/admin/manage-nurses" style="display:inline">
        <input type="hidden" name="action" value="delete"/>
        <input type="hidden" name="nurseId" value="<%=n.getId()%>"/>
        <button>Delete</button>
      </form>
    </td>
  </tr>
  <%   }
    }
  %>
</table>

<h3>Add Nurse</h3>
<form method="post" action="<%=request.getContextPath()%>/admin/manage-nurses">
  <input type="hidden" name="action" value="save"/>
  Name: <input name="name" required/><br/>
  Email: <input name="email" required/><br/>
  Password: <input type="password" name="password" required/><br/>
  Specialization: <input name="specialization"/><br/>
  <button>Add</button>
</form>

<p><a href="<%=request.getContextPath()%>/admin/dashboard">Back to Admin Dashboard</a></p>
 </main>
  <footer>
       <section id="contact">
      <h2>Contact Us</h2>
      <p><strong>Address:</strong> 123 Health Ave, Wellness City</p>
      <p><strong>Phone:</strong> +1 (555) 123-4567</p>
      <p><strong>Email:</strong> info@ourhospital.com</p>
      <div id="map"><!-- Embed your map here --></div>
    </section>&copy; 2025 Hospital Management System — All Rights Reserved</footer>
</body>
</html>