<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <title>Servlet Login Example</title>
        </head>

        <body>
            <h1>Login App using HttpSession</h1>
            <form action="LoginServlet" method="post">
                <a href="/Login.jsp">Login</a>|
                <a href="/LogoutServlet">Logout</a>|
                <a href="/ProfileServlet">Profile</a>
                </form>
                ${invalid}
        </body>

        </html>