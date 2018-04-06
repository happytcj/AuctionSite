<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>GTBay Login</title>
    <link rel="stylesheet" type="text/css" href="/css/styles.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="/js/login.js"></script>
</head>

<body class="center">
<img src="/images/GTBay%20Logo.png"/>
<form action="/" id="loginForm" method="POST" onsubmit="return verifyFields();">
    <table class="table">
        <tr>
            <td>
                User Name
            </td>
            <td>
                <input type="text" name="username" id="txtUsername"/>
            </td>
        </tr>
        <tr>
            <td>
                Password
            </td>
            <td>
                <input type="password" name="pass" id="txtPass"/>
            </td>
        </tr>
    </table>
    <div class="alignCenter">
        <input class="btn btn-success" type="button" value="Register" onclick="location.href = '/register'" />
        <input class="btn btn-success" type="submit" value="Login" />
    </div>
</form>

<br/>

<c:if test="${not empty error}">
    <div class="alignCenter">
        <label class="error">Invalid Login.</label>
    </div>
</c:if>
</body>
</html>