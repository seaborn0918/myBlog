<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="kr">
<head>
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title><></title>
  <link rel="stylesheet" href="bootstrap-5.2.3/css/bootstrap.css">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
  <link rel="stylesheet" href="css/style.css">
  <script src="bootstrap-5.2.3/js/bootstrap.bundle.js"></script>
  <%--  <style>--%>
  <%--    * {border: 1px solid salmon}--%>
  <%--  </style>--%>
</head>
<body>
<header>
  <nav class="navbar navbar-expand-md fixed-top bg-white">
    <div class="container">
      <a href="./index.jsp" class="navbar-brand fw-semibold">take your marks</a>
      <div>
        <a href="./contact.jsp" class="text-decoration-none text-dark fw-bolder me-1">contact</a>
        <a href="#" class="text-decoration-none text-dark fw-bolder">login</a>
      </div>
    </div>
  </nav>
  <div class="header-image py-5">
  </div>
</header>
<main class="container-md mt-3">
  <div class="row">
    <div class="col-md-2 d-flex justify-content-end px-0">
      <div class="position-fixed">
        <span class="fw-bold px-4">category</span>
        <ul class="list-unstyled mt-1">
          <li class="category-item px-4 my-2"><a href="#" class="text-decoration-none text-dark ">JAVA</a></li>
          <li class="category-item px-4 my-2"><a href="#" class="text-decoration-none text-dark ">JavaScript</a></li>
          <li class="category-item px-4 my-2"><a href="#" class="text-decoration-none text-dark ">HTML/CSS</a></li>
        </ul>
      </div>
    </div>
    <div class="col-md">
      <div>
        <label for="">이름</label>
        <input type="text" class="form-control">
      </div>
      <div>
        <label for="">비밀번호</label>
        <input type="text" class="form-control">
      </div>
      <div>
        <label for="">내용</label>
        <input type="text" class="form-control">
      </div>
    </div>
    <div class="col-md-2"></div>
  </div>
</main>
<footer class="container-fluid bg-white py-5 text-center">
  <span>made by KSH</span><br>
  <a href="#" class="text-dark fs-1"><i class="bi bi-github"></i></a>
</footer>
</body>
</html>
