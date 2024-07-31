<%--
  Created by IntelliJ IDEA.
  User: Digital space
  Date: 24.07.2024
  Time: 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div>
  <c:if test="${not empty sessionScope.user}">
    <div id="container">
      <h3>Welcome, ${sessionScope.user.first_name} ${sessionScope.user.last_name}!</h3>
      <p>Email: ${sessionScope.user.email}</p>
    </div>
    <div id="logout">
      <form action="${pageContext.request.contextPath}/logout" method="post">
        <button type="submit">Logout</button>
      </form>
    </div>
  </c:if>

  <div id="locale">
    <form action="${pageContext.request.contextPath}/locale" method="post">
      <button type="submit" name="lang" value="ru_RU">RU</button>
      <button type="submit" name="lang" value="en_US">EN</button>
    </form>
  </div>
  <fmt:setLocale value="${sessionScope.lang != null ? sessionScope.lang : (param.lang != null ? param.lang: 'en_US')}"/>
  <fmt:setBundle basename="translations"/>
</div>
