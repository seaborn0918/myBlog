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
<header>
  <nav class="navbar navbar-expand-md fixed-top bg-white">
    <div class="container">
      <a href="/view/main.do" class="navbar-brand fw-semibold">take your marks</a>
      <div>
        <a href="contact.jsp" class="text-decoration-none text-dark fw-bolder me-1">contact</a>
        <a href="login.jsp" class="text-decoration-none text-dark fw-bolder">login</a>
      </div>
    </div>
  </nav>
  <div class="header-image py-5">
  </div>
</header>
<h1><%=session.getAttribute("userId")%></h1>
<main class="container-md my-3">
  <div class="row d-flex justify-content-center">
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
    <div class="col-md-8">
      <%-- 글쓰기 페이지 --%>
        <form action="/view/write.do" method="post" enctype="multipart/form-data">
          <div class="mt-3">
            <input type="text" class="form-control" id="title" name="title" placeholder="제목을 입력하세요">
          </div>
          <hr>
          <div class="mt-3">
            <textarea name="content" id="content" rows="20" class="form-control" placeholder="글내용을 입력하세요"></textarea>
          </div>
          <div class="input-group mt-1 write-file">
            <span class="input-group-text">첨부파일</span>
            <input type="file" class="form-control" id="file" name="file" placeholder="글과 함께 등록할 파일을 선택하세요">
          </div>
          <hr>
          <div class="my-3">
            <div class="row">
              <div class="col-sm d-grid">
                <button type="submit" class="btn btn-dark">글 등록</button>
              </div>
              <div class="col-sm d-grid">
                <button type="reset" class="btn btn-secondary" id="btn-cancel">취소</button>
              </div>
            </div>
          </div>
        </form>
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
