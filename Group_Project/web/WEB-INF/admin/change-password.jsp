<%-- 
    Document   : change-password
    Created on : Apr 27, 2025, 12:41:29 AM
    Author     : 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>Change Password | Hospital Management System</title>
</head>
<body>
    <h2>Change Password</h2>

    <form method="post" action="${pageContext.request.contextPath}/change-password">
        <div>
            <label>New Password:</label>
            <input type="password" name="newpassword" required />
        </div>
        <div>
            <label>Confirm New Password:</label>
            <input type="password" name="confirmpassword" required />
        </div>
        <div>
            <button type="submit">Change Password</button>
        </div>
    </form>

    <c:if test="${not empty error}">
        <div style="color: red;">${error}</div>
    </c:if>

    <p><a href="${pageContext.request.contextPath}/dashboard">Back to Dashboard</a></p>
</body>
</html>
