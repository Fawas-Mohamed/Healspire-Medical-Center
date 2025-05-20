<%-- 
    Document   : manage-users
    Created on : May 6, 2025, 9:53:22 PM
    Author     : 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="com.hospital.model.User" %>
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
  <h2>Manage Users</h2>
  <p>
    <a href="<%= request.getContextPath() %>/AddUserServlet">
      + Add New User
    </a>
  </p><br><br>

<%
    // Retrieve the list of users put into the request by the servlet
    @SuppressWarnings("unchecked")
    List<User> users = (List<User>) request.getAttribute("users");

    if (users == null || users.isEmpty()) {
%>
      <p><em>No users found.</em></p>
<%
    } else {
%>
      <table border="1" cellpadding="5">
        <tr>
          <th>ID</th>
          <th>Name</th>
          <th>Email</th>
          <th>Role</th>
          <th>Actions</th>
        </tr>
<%
        for (User u : users) {
%>
        <tr>
          <td><%= u.getId() %></td>
          <td><%= u.getFullname() %></td>
          <td><%= u.getEmail() %></td>
          <td><%= u.getRole() %></td>
          <td>
            <a href="<%= request.getContextPath() %>/admin/delete-user?id=<%= u.getId() %>"
               onclick="return confirm('Delete user <%= u.getFullname() %>?');">
              Delete
            </a>
          </td>
        </tr>
<%
        } // end for
%>
      </table>
<%
    } // end if/else
%>
      </div><!-- comment -->
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
</body>
</html>
