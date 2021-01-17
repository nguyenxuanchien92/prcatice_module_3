<%--
  Created by IntelliJ IDEA.
  User: nguye
  Date: 1/17/2021
  Time: 4:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create a product</title>
</head>
<body>
<form method="post" action="?action=create">
    <fieldset>
        <legend>Create Product</legend>
        Name:<input type="text" name="nameProduct">
        <br>
        Price:<input type="text" name="price">
        <br>
        Quantity:<input type="text" name="quantity">
        <br>
        Color:<input type="text" name="color">
        <br>
        Description:<input type="text" name="desc">
        <br>
        Category:<select name="selectCategory">
        <c:forEach items="${sessionScope.categoryList}" var="category">
            <option value="${category.idCategory}">${category.nameCategory}</option>
        </c:forEach>
    </select>
        <br>
        <input type="submit" value="Create">
        <br>
        <a href="show.jsp">
            <input type="submit" value="Back">
        </a>
    </fieldset>
</form>
</body>
</html>
