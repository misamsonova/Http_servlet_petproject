<%--
  Created by IntelliJ IDEA.
  User: Digital space
  Date: 24.07.2024
  Time: 13:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Login</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f0f0f0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        form {
            background: white;
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            text-align: center;
            width: 300px;
        }
        label {
            display: block;
            margin: 15px 0;
            font-size: 14px;
            color: #333;
        }
        input[type="text"],
        input[type="password"] {
            width: 100%;
            padding: 10px;
            margin: 5px 0 10px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
            font-size: 14px;
        }
        button {
            width: 100%;
            background-color: #28a745;
            color: white;
            padding: 12px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
        }
        button:hover {
            background-color: #218838;
        }
        .error {
            color: red;
            margin-top: 10px;
        }
        a {
            text-decoration: none;
        }
    </style>
</head>
<body>
<%@include file="header.jsp"%>
<form action="${pageContext.request.contextPath}/login" method="post">
    <label for="email"><fmt:message key="page.login.email"/>:
        <input type="text" name="email" id="email" value="${param.email}" required>
    </label>
    <label for="password"><fmt:message key="page.login.password"/>:
        <input type="password" name="password" id="password" required>
    </label>
    <button type="submit"><fmt:message key="page.login.submit.button"/></button>
    <a href="${pageContext.request.contextPath}/registration">
        <button type="button"><fmt:message key="page.login.register.button"/></button>
    </a>

    <c:if test="${param.error != null}">
        <div class="error">
            <span><fmt:message key="page.login.error"/></span>
        </div>
    </c:if>
</form>
</body>
</html>
