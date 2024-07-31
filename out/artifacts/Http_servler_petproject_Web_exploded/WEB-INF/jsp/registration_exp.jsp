
<%--
  Created by IntelliJ IDEA.
  User: Digital space
  Date: 24.07.2024
  Time: 14:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<img src="${pageContext.request.contextPath}/images/users/143672843-288-k508919.jpg" alt="User image">--%>
<%--<img src="https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_640.jpg" alt="User image">--%>
<form action="/registration" method="post" enctype="multipart/form-data">
    <label for="first_name">FirstName:
        <input type="text" name="first_name" id="first_name">
    </label><br>
    <label for="last_name">LastName:
        <input type="text" name="last_name" id="last_name">
    </label><br>
    <label for="patronymic">Patronymic:
        <input type="text" name="patronymic" id="patronymic">
    </label><br>
    <label for="birthday">Birthday:
        <input type="date" name="birthday" id="birthday" required>
    </label><br>
    <label for="country">Country:
        <input type="text" name="country" id="country">
    </label><br>
    <label for="passport">Passport:
        <input type="text" name="passport" id="passport">
    </label><br>
    <label for="emailId">Email:
        <input type="text" name="email" id="emailId">
    </label><br>
<%--    <label for="imageId">Image:--%>
<%--        <input type="file" name="image" id="imageId" required>--%>
<%--    </label><br>--%>
    <label for="password">Password:
        <input type="password" name="password" id="password">
    </label><br>

    <select name="role" id="role">
        <c:forEach var="role" items="${requestScope.roles}">
            <option value="${role}">${role}</option>
        </c:forEach>
    </select><br>
    <c:forEach var="gender" items="${requestScope.genders}">
        <input type="radio" name="gender" value = "${gender}"> ${gender}
        <br>
    </c:forEach>

    <button type="submit">Send</button>
    <c:if test="${not empty requestScope.errors}">
        <div style="color: red">
            <c:forEach var="error" items="${requestScope.errors}">
                <span>${error.message}</span>
            </c:forEach>
        </div>
    </c:if>
</form>
</body>
</html>
