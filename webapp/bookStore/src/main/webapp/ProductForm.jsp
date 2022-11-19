<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>poioipjhijhpoipjh
<head>
    <title>Reseller Management System</title>
</head>
<body>
    <center>
        <h1>Products Management</h1>
        <h2>
            <a href="/new">Add New Product</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/list">List All Products</a>
             
        </h2>
    </center>
    <div align="center">
        <c:if test="${product != null}">
            <form action="update" method="post">
        </c:if>
        <c:if test="${product == null}">
            <form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    <c:if test="${product != null}">
                        Edit Product
                    </c:if>
                    <c:if test="${product == null}">
                        Add New Product
                    </c:if>
                </h2>
            </caption>
                <c:if test="${product != null}">
                    <input type="hidden" name="product_id" value="<c:out value='${product.product_id}' />" />
                </c:if>           
            <tr>
                <th>Product Name</th>
                <td>
                    <input type="text" name="product_name" size="45"
                            value="<c:out value='${product.product_name}' />"
                        />
                </td>
            </tr>
            <tr>
                <th>Product Quantity</th>
                <td>
                    <input type="text" name="product_quantity" size="45"
                            value="<c:out value='${product.product_quantity}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Product Price</th>
                <td>
                    <input type="text" name="product_price" size="5"
                            value="<c:out value='${product.product_price}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Manufactured Date</th>
                <td>
                    <input type="text" name="pro_manufactured_date" size="11"
                            value="<c:out value='${product.pro_manufactured_date}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Expiry Date</th>
                <td>
                    <input type="text" name="pro_expiry_date" size="11"
                            value="<c:out value='${product.pro_expiry_date}' />"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save" />
                </td>
            </tr>
        </table>
        </form>
    </div>   
</body>
</html>