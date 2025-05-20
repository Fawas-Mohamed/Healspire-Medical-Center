<%-- 
    Document   : manage-users
    Created on : Apr 27, 2025, 12:38:25 AM
    Author     : 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Manage Users | Hospital Management System</title>
</head>
<body>
    <h2>Manage Users</h2>

    <table border="1" cellpadding="5" cellspacing="0">
        <thead>
            <tr>
                <th>User ID</th>
                <th>Full Name</th>
                <th>Email</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="user" items="${usersList}">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.fullName}</td>
                    <td>${user.email}</td>
                    <td>
                        <form method="post" action="${pageContext.request.contextPath}/admin/manage-users" style="display:inline;">
                            <input type="hidden" name="userId" value="${user.id}" />
                            <button type="submit">Delete</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <p><a href="${pageContext.request.contextPath}/dashboard">Back to Dashboard</a></p>
</body>
</html>
