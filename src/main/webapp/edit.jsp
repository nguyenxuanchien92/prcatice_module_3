<%--
  Created by IntelliJ IDEA.
  User: nguye
  Date: 1/15/2021
  Time: 4:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit product</title>
</head>
<body>
    <form method="post" action="?action=edit&id=${requestScope.product.idProduct}">
        <fieldset>
            <legend>Edit Product</legend>
            Name:<input type="text" value="${requestScope.product.nameProduct}">
            <br>
            Price:<input type="text" value="${requestScope.product.price}">
            <br>
            Quantity:<input type="text" value="${requestScope.product.quantity}">
            <br>
            Color:<input type="text" value="${requestScope.product.color}">
            <br>
            Description:<input type="text" value="${requestScope.product.des}">
            <br>
            Category:<input type="text" value="${requestScope.product.category.nameCategory}">
            <br>
            <input type="submit" value="Save">
        </fieldset>
    </form>
</body>
</html>
