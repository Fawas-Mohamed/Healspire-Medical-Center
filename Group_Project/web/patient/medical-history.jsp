<%-- 
    Document   : medical-history
    Created on : Apr 28, 2025, 1:37:03 AM
    Author     : 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.hospital.model.MedicalRecord" %>
<%@ page import="java.util.List, com.hospital.model.MedicalRecord" %>
<html><head><title>Medical History</title></head><body>
<h2>Medical History</h2>
<ul>
<%
 List<MedicalRecord> h = (List<MedicalRecord>) request.getAttribute("history");
 for(MedicalRecord r: h) {
%>
  <li><%= r.getRecordDate() %> - <%= r.getDescription() %></li>
<% } %>
</ul>
<a href="patientdashboard.jsp">Back to Dashboard</a>
</body></html>
