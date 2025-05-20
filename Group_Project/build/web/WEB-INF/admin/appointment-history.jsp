<%-- 
    Document   : appointment-history
    Created on : Apr 27, 2025, 12:39:50 AM
    Author     : 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>



<!DOCTYPE html>
<html>
<head>
    <title>Appointment History | Hospital Management System</title>
</head>
<body>
    <h2>Your Appointment History</h2>

    <table border="1" cellpadding="5" cellspacing="0">
        <thead>
            <tr>
                <th>Appointment ID</th>
                <th>Doctor ID</th>
                <th>Date</th>
                <th>Time</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="appt" items="${historyList}">
                <tr>
                    <td>${appt.id}</td>
                    <td>${appt.doctorId}</td>
                    <td><fmt:formatDate value="${appt.date}" pattern="yyyy-MM-dd"/></td>
                    <td><fmt:formatDate value="${appt.time}" pattern="HH:mm"/></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <p><a href="${pageContext.request.contextPath}/dashboard">Back to Dashboard</a></p>
</body>
</html>

