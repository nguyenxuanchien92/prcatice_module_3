<%--
  Created by IntelliJ IDEA.
  User: nguye
  Date: 1/15/2021
  Time: 4:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit product</title>
</head>
<body>
<form method="post" action="?action=edit&id=${requestScope.product.idProduct}">
    <fieldset>
        <legend>Edit Product</legend>
        Name:<input type="text" value="${requestScope.product.nameProduct}" name="nameProduct">
        <br>
        Price:<input type="text" value="${requestScope.product.price}" name="price">
        <br>
        Quantity:<input type="text" value="${requestScope.product.quantity}" name="quantity">
        <br>
        Color:<input type="text" value="${requestScope.product.color}" name="color">
        <br>
        Description:<input type="text" value="${requestScope.product.des}" name="desc">
        <br>
        Category:<select name="selectCategory">
        <c:forEach items="${sessionScope.categoryList}" var="category">
            <option value="${category.idCategory}">${category.nameCategory}</option>
        </c:forEach>
        </select>
        <br>
        <input type="submit" value="Save">
    </fieldset>
</form>
</body>
</html>
