<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>
            Product
        </title>
    </head>
   <body>
    <center>
        <h1>Reseller Management System</h1>
        <h2>
            <a href="/new">Add New product</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/list">List All products</a>
        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="7">
            <caption><h2>List of products</h2></caption>
            <tr>
                <th>Product Id</th>
                <th>product Name</th>
                <th>product Quantity</th>
                <th>Product Price</th>
                <th>Manufactured Date</th>
                <th>Expiry Date</th>
            </tr>
            <c:forEach var="product" items="${productlist}">
                <tr>
                    <td><c:out value="${product.product_id}" /></td>
                    <td><c:out value="${product.product_name}" /></td>
                    <td><c:out value="${product.product_quantity}" /></td>
                    <td><c:out value="${product.product_price}" /></td>
                    <td><c:out value="${product.pro_manufactured_date}" /></td>
                    <td><c:out value="${product.pro_expiry_date}" /></td>
                    <td>
                        <a href="/edit?product_id=<c:out value='${product.product_id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/delete?product_id=<c:out value='${product.product_id}' />">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</htm