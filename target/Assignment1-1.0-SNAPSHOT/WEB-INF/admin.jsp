<%--
  Created by IntelliJ IDEA.
  User: warren
  Date: 10/17/20
  Time: 11:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin</title>
</head>
<body>
    <h1>Home Inventory</h1>
    <h2>Admin Summary</h2>
    <p>${priceMessage}</p>
    <form method="post" name="form1">
        <p><a href="${pageContext.request.contextPath}/login?message=You have successfully logged out.">Logout</a></p>
    </form>
</body>
</html>
