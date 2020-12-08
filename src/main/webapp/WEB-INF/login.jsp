<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <h1>Home Inventory</h1>
    <h2>Login</h2>
    <form action="loginCheck" method="post">
        User name: <input type="text" name="username" id="username" required autofocus>  <br>
        Password: <input type="password" name="password" id="password" required >   <br>
        <input id="login" type="submit" value="Submit">
        <p>${message}</p>
    </form>
</body>
</html>
