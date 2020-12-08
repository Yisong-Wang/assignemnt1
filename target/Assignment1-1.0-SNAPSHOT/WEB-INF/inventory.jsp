<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Inventory</title>
</head>
<body>
    <h1>Home Inventory for ${username}</h1>
    <h2>Add Item</h2>
    <form action="addItem" method="post">
        <input type="hidden" name="username" value=${username} />
        Category:
        <select name="category">
            <option>bedroom</option>
            <option>garage</option>
            <option>kitchen</option>
            <option>living room</option>
        </select> <br>
        Item Name: <input type="text" name="itemName" id="itemName" required >   <br>
        Price: <input type="text" name="price" id="price" required >   <br><br>
        <input id="addItem" type="submit" value="Add">${addMessage}
    </form>
    <p>${priceMessage}</p>

    <form method="post" name="form1">
        <p><a href="${pageContext.request.contextPath}/login?message=You have successfully logged out.">Logout</a></p>
    </form>
</body>
</html>
