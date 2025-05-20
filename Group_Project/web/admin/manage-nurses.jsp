<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List, com.hospital.model.Nurse" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Manage Nurses</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin-site.css">
</head>
<body>

  <header>
    <img src="${pageContext.request.contextPath}/image/logo.jpg" alt="Hospital Logo" class="logo-right">
    <h1>Healspire Medical Center</h1>
    <p>Inspiring Better Health, Every Day</p>
  </header>

  <nav>
    <a href="${pageContext.request.contextPath}/admin/dashboard.jsp" class="btn">Dashboard</a>
    <a href="${pageContext.request.contextPath}/logout" class="btn">Logout</a>
  </nav>

  <main class="container">
    <h2 style="text-align: center;">Manage Nurses</h2>
    <table>
      <thead>
        <tr>
          <th>Id</th>
          <th>Name</th>
          <th>Email</th>
          <th>Spec</th>
          <th>Action</th>
        </tr>
      </thead>
      <tbody>
        <%
          List<Nurse> nurses = (List<Nurse>) request.getAttribute("nursesList");
          if (nurses != null) {
            for (Nurse n : nurses) {
        %>
        <tr>
          <td><%= n.getId() %></td>
          <td><%= n.getName() %></td>
          <td><%= n.getEmail() %></td>
          <td><%= n.getSpecialization() %></td>
          <td>
            <form method="post" action="${pageContext.request.contextPath}/admin/manage-nurses" style="display:inline">
              <input type="hidden" name="action" value="delete"/>
              <input type="hidden" name="nurseId" value="<%= n.getId() %>"/>
              <button type="submit" class="btn">Delete</button>
            </form>
          </td>
        </tr>
        <%  
            }
          }
        %>
      </tbody>
    </table>

    <h3>Add Nurse</h3>
    <form method="post" action="${pageContext.request.contextPath}/admin/manage-nurses">
      <input type="hidden" name="action" value="save"/>

      <label for="nurse-name">Name</label>
      <input type="text" id="nurse-name" name="name" required/>

      <label for="nurse-email">Email</label>
      <input type="email" id="nurse-email" name="email" required/>

      <label for="nurse-password">Password</label>
      <input type="password" id="nurse-password" name="password" required/>

      <label for="nurse-spec">Specialization</label>
      <input type="text" id="nurse-spec" name="specialization"/>

      <button type="submit" class="btn">Add</button>
    </form>
  </main>

  <footer>
    <section id="contact">
      <h2>Contact Us</h2>
      <p><strong>Address:</strong>MAHENWATHTHA, PITIPANA, HOMAGAMA, SRI LANKA</p>
      <p><strong>Phone:</strong> +1 (555) 123-4567</p>
      <p><strong>Email:</strong> info@ourhospital.com</p>
      <div id="map"><!-- Embed your map here --></div>
    </section>
    &copy; 2025 Hospital Management System — All Rights Reserved
  </footer>

</body>
</html>
