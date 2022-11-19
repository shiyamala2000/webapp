<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
           
            <title>Document</title>
        </head>

        <body>
            <a href="Login.jsp">Login</a> |
            <a href="LogoutServlet">Logout</a> |
            <a href="ProfileServlet">Profile</a>
        </hr>
            ${invalid}
            ${text}
            ${logout}
        </body>

        </html>