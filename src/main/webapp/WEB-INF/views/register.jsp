<%--
  Created by IntelliJ IDEA.
  User: tjiang
  Date: 3/28/18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>GTBay Registration</title>
    <link rel="stylesheet" type="text/css" href="/css/styles.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="/js/register.js"></script>
</head>

<body class="center">
<img src="/images/GTBay%20Logo.png"/>
<form action="/" id="registrationForm" method="POST" onsubmit="return verifyRegisterFields();">
    <table class="table">
        <tr>
            <td>
                First Name
            </td>
            <td>
                <input type="text" name="firstname" id="txtFirstname"/>
            </td>
        </tr>
        <tr>
            <td>
                Last Name
            </td>
            <td>
                <input type="text" name="firstname" id="txtLastname"/>
            </td>
        </tr>
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
        <tr>
            <td>
                Confirm Password
            </td>
            <td>
                <input type="password" name="pass" id="txtConfirmpass"/>
            </td>
        </tr>
    </table>
    <div class="alignCenter">
        <input class="btn btn-success" type="button" value="Cancel" onclick="location.href = '/'" />
        <input class="btn btn-success" type="submit" value="Register" />
    </div>
</form>

<br/>

<c:if test="${not empty error}">
    <div class="alignCenter">
        <label class="error">Registration Failed.</label>
    </div>
</c:if>
</body>
</html>
