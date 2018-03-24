<%--
  Created by IntelliJ IDEA.
  User: Steph
  Date: 2/24/2018
  Time: 4:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Homepage</title>
    <link rel="stylesheet" type="text/css" href="/css/styles.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body class="center">
    <h1>Welcome ${user.fullName}!</h1>
    <a href="#">Search for Items</a>
    <a href="#">List an Item for Sale</a>
    <a href="#">View Auction Results</a>
    <c:if test="${user['class'].simpleName eq 'AdminUser'}">
        <a href="#">View Category Report</a>
        <a href="#">View User Report</a>
    </c:if>
</body>
</html>
