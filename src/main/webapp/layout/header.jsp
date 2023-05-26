<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023-05-25
  Time: 오전 9:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
  $(document).ready(function () {
    <c:choose>
    <c:when test="${empty userId}">
    $("#welcome-msg").hide()
    $("#btn-admin-contact").hide()
    $("#btn-contact").show();
    $("#btn-login").show();
    $("#btn-logout").hide();
    </c:when>
    <c:otherwise>
    $("#welcome-msg").show()
    $("#btn-admin-contact").show()
    $("#btn-contact").hide();
    $("#btn-login").hide();
    $("#btn-logout").show();
    </c:otherwise>
    </c:choose>
  });
</script>
<header>
  <nav class="navbar navbar-expand-md fixed-top bg-white">
    <div class="container">
      <a href="/view/main.do" class="navbar-brand fw-semibold px-2">나의 개발학습일지</a>
      <div>
        <span id="welcome-msg" class="navbar-text">공부 중인 ${userName}</span>
        <a href="<c:url value="/view/adminContactBoard.jsp"/>" id="btn-admin-contact"
           class="text-decoration-none fw-bolder nav-text px-2 py-2">contact-list</a>
        <a href="contact.jsp" id="btn-contact"
           class="text-decoration-none fw-bolder nav-text px-2 py-2">contact</a>
        <a href="login.jsp" id="btn-login" class="text-decoration-none fw-bolder nav-text px-2 py-2">login</a>
        <a href="/view/logout.do" id="btn-logout" class="text-decoration-none fw-bolder nav-text px-2 py-2">logout</a>
      </div>
    </div>
  </nav>
  <div class="header-image py-5">
  </div>
</header>

