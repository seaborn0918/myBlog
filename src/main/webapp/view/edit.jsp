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
    $(document).ready(function () {
      $("#btn-cancel").on("click", function () {
        history.back();
      })
    });
  </script>
</head>
<body>
<c:import url="../layout/header.jsp"/>
<main class="container-md my-3">
  <div class="row d-flex justify-content-center my-5">
    <div class="col-md-8">
      <form action="/view/edit.do" method="post" enctype="multipart/form-data">
        <div class="input-group mt-3">
          <select class="form-select form-select-sm" name="cateBox">
            <c:forEach items="${category}" var="category" varStatus="loop">
              <option value="${category.cateNo}">${category.postCate}</option>
            </c:forEach>
          </select>
          <input type="text" class="form-control w-75" id="title" name="title" value="${cateBoard.getPostTitle()}"
                 placeholder="제목을 입력하세요" required>
        </div>
        <hr>
        <div class="writer-info">
          <span>${cateBoard.getPostWriter()}</span>
          <br>
          <input type="hidden" id="post-idx" name="idx" value="${cateBoard.getPostIdx()}">
          <span>글번호 ${cateBoard.getPostIdx()}</span>
          <span>| ${cateBoard.getPostCate()}</span>
          <span>| ${cateBoard.getPostDate()}</span>
          <span>| 조회 ${cateBoard.getPostVisits()}</span>
        </div>
        <hr>
        <div class="my-3">
          <textarea name="content" id="content" rows="20" class="form-control" placeholder="글내용을 입력하세요"
                    required>${cateBoard.getPostContent()}</textarea>
          <c:if test="${not empty cateBoard.getPostOfile()}">
            <div class="input-group input-group-sm mt-1">
              <span class="input-group-text">첨부파일</span>
              <input type="text" class="form-control text-start" value="${cateBoard.getPostOfile()}" readonly>
            </div>
          </c:if>
        </div>
        <div class="input-group">
          <span class="input-group-text">첨부파일</span>
          <input type="file" class="form-control" id="file" name="file">
        </div>
        <hr>
        <div class="mt-3 mb-5">
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
  </div>
</main>
<footer class="container-fluid bg-white py-5 text-center">
  <span>made by KSH</span><br>
  <a href="#" class="text-dark fs-1"><i class="bi bi-github"></i></a>
</footer>
</body>
</html>
