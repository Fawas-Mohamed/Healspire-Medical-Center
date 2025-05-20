<%-- 
    Document   : header
    Created on : May 2, 2025, 4:42:52 PM
    Author     : 
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header style="background: rgba(0,51,102,0.85); padding: 1em; text-align: center; border-bottom: 4px solid #004080;">
  <h1 style="color: #fff; margin: 0;">Hospital Management System</h1>
  <nav style="margin-top: .5em;">
    <a href="${pageContext.request.contextPath}/doctor/dashboard" style="color: #fff; margin: 0 1em; text-decoration: none; font-weight: bold;">Dashboard</a>
    <a href="${pageContext.request.contextPath}/doctor/view-patients" style="color: #fff; margin: 0 1em; text-decoration: none; font-weight: bold;">Patients</a>
    <a href="${pageContext.request.contextPath}/logout" style="color: #fff; margin: 0 1em; text-decoration: none; font-weight: bold;">Logout</a>
  </nav>
</header>
