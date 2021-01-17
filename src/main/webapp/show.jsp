<%--
  Created by IntelliJ IDEA.
  User: nguye
  Date: 1/15/2021
  Time: 2:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>Product</title>
  </head>
  <body>
    <div align="center">
      <form action="?action=create">
        <input type="submit" value="+ Add new product">
      </form>
      <form method="post" action="?action=search">
        <input type="text" placeholder="Enter your product" name="productTxt">
        <input type="submit" value="Search">
      </form>
    </div>
    <table border="1" align="center">
      <thead>
        <tr>
          <td>#</td>
          <td>Product Name</td>
          <td>Price</td>
          <td>Quantity</td>
          <td>Color</td>
          <td>Category</td>
          <td colspan="2" align="center">Action</td>
        </tr>
      </thead>
      <tbody>
        <c:forEach items="${requestScope.productList}" var="product">
          <tr>
            <td>${product.idProduct}</td>
            <td>${product.nameProduct}</td>
            <td>${product.price}</td>
            <td>${product.quantity}</td>
            <td>${product.color}</td>
            <td>${product.category.nameCategory}</td>
            <td>
              <a href="?action=edit&id=${product.idProduct}">
                <input type="submit" value="edit">
              </a>
            </td>
            <form method="post" action="?action=delete&id=${product.idProduct}">
              <td>
                <input type="submit" value="delete">
              </td>
            </form>
          </tr>
        </c:forEach>
      </tbody>
    </table>
  </body>
</html>
