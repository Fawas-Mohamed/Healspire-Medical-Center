<%-- 
    Document   : book-appointment
    Created on : Apr 27, 2025, 12:40:27 AM
    Author     : 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
    <title>Book Appointment | Hospital Management System</title>
</head>
<body>
    <h2>Book an Appointment</h2>

    <form method="post" action="${pageContext.request.contextPath}/book-appointment">
        <div>
            <label>Choose Doctor:</label>
            <select name="doctorId" required>
                <c:forEach var="doc" items="${doctorsList}">
                    <option value="${doc.id}">${doc.name} (${doc.specialization})</option>
                </c:forEach>
            </select>
        </div>
        <div>
            <label>Date:</label>
            <input type="date" name="date" required />
        </div>
        <div>
            <label>Time:</label>
            <input type="time" name="time" required />
        </div>
        <div>
            <button type="submit">Book Appointment</button>
        </div>
    </form>

    <p><a href="${pageContext.request.contextPath}/dashboard">Back to Dashboard</a></p>
</body>
</html>

