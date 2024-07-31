<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Registration Form</title>
    <style>
        body {
            font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif;
            background-color: #f0f0f0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            overflow: hidden;
        }
        .form-container {
            background: white;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            max-width: 500px;
            width: 90%;
            max-height: 90vh;
            overflow-y: auto;
            display: flex;
            flex-direction: column;
        }
        h2 {
            text-align: center;
            margin-bottom: 20px;
        }
        label {
            display: block;
            margin-bottom: 5px;
            color: #333;
        }
        input[type="text"],
        input[type="password"],
        input[type="date"],
        select {
            width: 100%;
            padding: 10px;
            margin: 5px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
            font-size: 14px;
        }
        button {
            width: 100%;
            background-color: #28a745;
            color: white;
            padding: 14px 20px;
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
    </style>
</head>
<body>
<div class="form-container">
    <form action="${pageContext.request.contextPath}/registration" method="post" enctype="multipart/form-data">
        <h2>Registration Form</h2>
        <label for="first_name">First Name:
            <input type="text" name="first_name" id="first_name">
        </label>
        <label for="last_name">Last Name:
            <input type="text" name="last_name" id="last_name">
        </label>
        <label for="patronymic">Patronymic:
            <input type="text" name="patronymic" id="patronymic">
        </label>
        <label for="birthday">Birthday:
            <input type="date" name="birthday" id="birthday" required>
        </label>
        <label for="country">Country:
            <input type="text" name="country" id="country">
        </label>
        <label for="passport">Passport:
            <input type="text" name="passport" id="passport">
        </label>
        <label for="emailId">Email:
            <input type="text" name="email" id="emailId">
        </label>
        <label for="password">Password:
            <input type="password" name="password" id="password">
        </label>
        <label for="role">Role:
            <select name="role" id="role">
                <c:forEach var="role" items="${requestScope.roles}">
                    <option value="${role}">${role}</option>
                </c:forEach>
            </select>
        </label>
        <label>Gender:
            <c:forEach var="gender" items="${requestScope.genders}">
                <input type="radio" name="gender" value="${gender}"> ${gender}
            </c:forEach>
        </label>
        <button type="submit">Send</button>
        <c:if test="${not empty requestScope.errors}">
            <div class="error">
                <c:forEach var="error" items="${requestScope.errors}">
                    <span>${error.message}</span>
                </c:forEach>
            </div>
        </c:if>
    </form>
</div>
</body>
</html>
