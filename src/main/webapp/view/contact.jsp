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
</head>
<body>
<c:import url="../layout/header.jsp"/>
<main class="container-md mt-3">
  <div class="row d-flex justify-content-center">
    <div class="col-md-8">
      <form action="adminContactBoard.jsp">
        <div class="form-floating my-3">
          <input type="text" id="guest-name" class="form-control" placeholder="이름을 입력하세요" required>
          <label for="guest-name">이름을 입력하세요</label>
        </div>
        <div class="form-floating my-3">
          <input type="email" id="guest-email" class="form-control" placeholder="이메일을 입력하세요" required>
          <label for="guest-email">이메일을 입력하세요</label>
        </div>
        <div class="form-floating my-3">
          <textarea name="" id="guest-content" rows="10" class="form-control" style="height: 20rem" required placeholder="내용을 입력하세요"></textarea>
          <label for="guest-content">내용을 입력하세요</label>
        </div>
        <div class="text-end my-3">
          <button type="submit" class="btn btn-dark">전송</button>
        </div>
      </form>
    </div>
  </div>
</main>
<footer class="container-fluid bg-white py-5 text-center">
  <span>made by KSH</span><br>
  <a href="#" class="text-dark fs-1"><i class="bi bi-github"></i></a>
</footer>
</body>
</html>
