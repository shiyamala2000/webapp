<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<body>
    <h2>Hello World!</h2>
    <form action="/servlet1">
        Name:<input type="text" name="name" /><br />
        Password:<input type="password" name="password" /><br />
        <input type="submit" value="login">
        ${invalid}
    </form>
</body>
</html>