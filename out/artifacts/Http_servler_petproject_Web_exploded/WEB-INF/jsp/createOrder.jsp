<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Digital space
  Date: 29.07.2024
  Time: 13:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <form action="${pageContext.request.contextPath}/create_order" method="post" enctype="multipart/form-data">
        <h2>Order Form</h2>
        <label for="first_name">First Name: ${sessionScope.user.first_name}
            <input type="hidden" name="first_name" id="first_name" value="${sessionScope.user.first_name}">
        </label>
        <p>Last Name: ${sessionScope.user.last_name}</p>
        <input type="hidden" name="last_name" value="${sessionScope.user.last_name}">
        <c:if test="${not empty sessionScope.user.patronymic}">
            <p>Patronymic: ${sessionScope.user.patronymic}</p>
            <input type="hidden" name="patronymic" value="${sessionScope.user.patronymic}">
        </c:if>
        <p>Passport: ${sessionScope.user.passport}</p>
        <input type="hidden" name="passport" value="${sessionScope.user.passport}">

        <label for="model">Model:
            <select name="model" id="model">
                <c:forEach var="model" items="${requestScope.models}">
                    <option value="${model.description}">${model.description}</option>
                </c:forEach>
            </select>
        </label>
        <label for="start_rent">Start rent:
            <input type="date" name="start_rent" id="start_rent" required>
        </label>
        <label for="finish_rent">Finish rent:
            <input type="date" name="finish_rent" id="finish_rent" required>
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

</body>
</html>
