<%@ page import="com.bitc.jsp_myblog.util.BoardPage" %>
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
      <c:choose>
      <c:when test="${empty userId}">
      $("#btn-write").hide();
      </c:when>
      <c:otherwise>
      $("#btn-write").show();
      </c:otherwise>
      </c:choose>
    });
  </script>
</head>
<body>
<c:import url="../layout/header.jsp"/>
<main class="container-md mt-3">
  <div class="row d-flex justify-content-center">
    <div class="col-md-2 d-flex justify-content-end px-0">
      <c:import url="../layout/category.jsp"/>
    </div>
    <div class="col-md-8">
      <%-- 상단 게시글 목록 --%>
      <div class="board-list">
        <table class="table table-sm table-hover table-fontsize mb-1">
          <colgroup>
            <col style="width: 75%">
            <col style="width: 25%">
          </colgroup>
          <thead class="table-dark">
          </thead>
          <tbody>
          <c:choose>
            <c:when test="empty boardList">
              <tr>
                <td colspan="2">등록된 게시물이 없습니다.</td>
              </tr>
            </c:when>
            <c:otherwise>
              <c:forEach items="${boardList}" var="item" varStatus="loop">
                <tr>
                  <td class="text-start text-nowrap">
                    <a id="board-title" href="/view/view.do?idx=${item.postIdx}"
                       class="text-decoration-none text-dark">${item.postTitle}</a>
                  </td>
                  <td class="text-end text-nowrap">${item.postDate}</td>
                </tr>
              </c:forEach>
            </c:otherwise>
          </c:choose>
          </tbody>
        </table>
      </div>
      <div class="paging text-center my-0">
        ${pagingImg}
      </div>
      <%-- 게시글 내용 --%>
      <div class="bg-white my-3 p-4 rounded-4">
        <c:choose>
          <c:when test="${not empty mainBoard}">
            <div>
              <h1>${mainBoard.getPostTitle()}</h1>
              <p class="mb-0">${mainBoard.getPostContent()}</p>
            </div>
          </c:when>
          <c:otherwise>
            <div>
              <h1>${maxPostIdxBoard.getPostTitle()}</h1>
              <p class="mb-0">${maxPostIdxBoard.getPostContent()}</p>
            </div>
          </c:otherwise>
        </c:choose>
      </div>
      <div class="text-end">
        <a href="/view/write.do?cateNo=${maxPostIdxBoard.cateNo}" id="btn-write" class="btn btn-dark">글쓰기</a>
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