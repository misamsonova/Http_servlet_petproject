<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Digital space
  Date: 02.08.2024
  Time: 19:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Profile</title>
</head>
<body>
    <h2>Order</h2>
    <label for="first_name">First Name: ${sessionScope.order.first_name}
        <input type="hidden" name="first_name" id="first_name" value="${sessionScope.order.first_name}">
    </label>
    <p>Last Name: ${sessionScope.order.last_name}</p>
    <input type="hidden" name="last_name" value="${sessionScope.order.last_name}">
    <c:if test="${not empty sessionScope.order.patronymic}">
        <p>Patronymic: ${sessionScope.order.patronymic}</p>
        <input type="hidden" name="patronymic" value="${sessionScope.order.patronymic}">
    </c:if>
    <p>Passport: ${sessionScope.order.passport}</p>
    <input type="hidden" name="passport" value="${sessionScope.order.passport}">
    <p>Model: ${sessionScope.order.model}</p>
    <input type="hidden" name="model" value="${sessionScope.order.model}">
    <p>Number: ${sessionScope.order.number}</p>
    <input type="hidden" name="number" value="${sessionScope.order.number}">
    <p>Price: ${sessionScope.order.price}</p>
    <input type="hidden" name="price" value="${sessionScope.order.price}">
    <p>Time order: ${sessionScope.order.time_order}</p>
    <input type="hidden" name="time_order" value="${sessionScope.order.time_order}">
    <p>Start rent: ${sessionScope.order.start_rent}</p>
    <input type="hidden" name="start_rent" value="${sessionScope.order.start_rent}">
    <p>Finish rent: ${sessionScope.order.finish_rent}</p>
    <input type="hidden" name="finish_rent" value="${sessionScope.order.finish_rent}">
    <a href="${pageContext.request.contextPath}/profile">Download as TXT</a>

</body>
</html>
