<%@ page import="com.bitc.jsp_myblog.model.DBConnPool" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="kr">
<head>
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title><></title>
  <link rel="stylesheet" href="../bootstrap-5.2.3/css/bootstrap.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" type="text/css">
  <script src="../bootstrap-5.2.3/js/bootstrap.bundle.js"></script>

  <script>
    $(document).ready(function (){
      $("#btn-cancel").on("click", function (){
        location.href = "/view/main.do"
      });
    });
  </script>

</head>
<body>
<c:import url="../layout/header.jsp"/>
<main class="container-md">
  <div class="row">
    <div class="col-md-4 mx-auto mt-5">
      <p class="fs-1 text-center">LOGIN</p>
      <form action="/view/login.do" method="post" class="row g-3">
        <div class="d-grid gap-2">
          <input type="text" id="user-id" name="userId" class="form-control" placeholder="아이디를 입력해주세요" required>
          <input type="password" id="user-pw" name="userPw" class="form-control" placeholder="비밀번호를 입력해주세요" required>
          <button type="submit" class="btn btn-dark" id="btn-login">로그인</button>
          <button type="reset" class="btn btn-secondary" id="btn-cancel">취소</button>
        </div>
      </form>
    </div>
  </div>
</main>
<footer class="container-fluid bg-white py-5 text-center">
  <span>made by KSH</span><br>
  <a href="#" class="text-dark fs-1 lead"><i class="bi bi-github"></i></a>
</footer>
</body>
</html>
