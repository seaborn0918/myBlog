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
      $("#btn-edit").hide();
      $("#btn-delete").hide();
      </c:when>
      <c:otherwise>
      $("#btn-write").show();
      $("#btn-edit").show();
      $("#btn-delete").show();
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
        <table class="table table-sm table-hover table-fontsize">
          <colgroup>
            <col style="width: 75%">
            <col style="width: 25%">
          </colgroup>
          <thead class="table-dark">
          </thead>
          <tbody>
          <c:choose>
            <c:when test="${empty cateBoardList}">
              <tr>
                <td colspan="2">등록된 게시물이 없습니다.</td>
              </tr>
            </c:when>
            <c:otherwise>
              <c:forEach items="${cateBoardList}" var="item" varStatus="loop">
                <tr>
                  <td class="text-start text-nowrap">
                    <a id="board-title"
                       href="<c:url value="/view/cateView.do?idx=${item.postIdx}&cateNo=${item.cateNo}"/>"
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
      <%--       게시글 내용 --%>
      <div class="bg-white my-4 p-5 rounded-4">
        <c:choose>
          <c:when test="${empty cateBoardList}">
            <div>게시물이 없음</div>
          </c:when>
          <c:when test="${not empty cateBoard}">
            <div class="article-header">
              <div class="article-title text-center my-3">
                <h1>${cateBoard.getPostTitle()}</h1>
              </div>
              <div class="writer-info">
                <span>${cateBoard.getPostWriter()}</span>
                <br>
                <span>글번호 ${cateBoard.getPostIdx()}</span>
                <span>| ${cateBoard.getPostCate()}</span>
                <span>| ${cateBoard.getPostDate()}</span>
                <span>| 조회 ${cateBoard.getPostVisits()}</span>
              </div>
              <hr>
            </div>
            <div class="article-container">
              <p class="pt-3 pb-5">${cateBoard.getPostContent()}</p>
            </div>
            <c:choose>
              <c:when test="${empty cateBoard.getPostOfile()}"/>
              <c:otherwise>
                <div class="article-file">
                  <div class="input-group input-group-sm">
                    <span class="input-group-text">첨부파일</span>
                    <input type="button" class="form-control text-start" name="postOfile"
                           value="${cateBoard.getPostOfile()}" readonly
                           onclick="location.href='/view/download.do?ofile=${cateBoard.getPostOfile()}&sfile=${cateBoard.getPostSfile()}&idx=${cateBoard.getPostIdx()}'">
                    <input type="hidden" value="${cateBoard.getPostSfile()}">
                    <span class="input-group-text">다운로드 수</span>
                    <span class="input-group-text">${cateBoard.getPostDnCount()}</span>
                  </div>
                </div>
              </c:otherwise>
            </c:choose>
          </c:when>
          <c:otherwise>
            <div class="article-header">
              <div class="article-title text-center my-3">
                <h1>${cateMaxPostIdxBoard.getPostTitle()}</h1>
              </div>
              <div class="writer-info">
                <span>${cateMaxPostIdxBoard.getPostWriter()}</span>
                <br>
                <span>글번호 ${cateMaxPostIdxBoard.getPostIdx()}</span>
                <span>| ${cateMaxPostIdxBoard.getPostCate()}</span>
                <span>| ${cateMaxPostIdxBoard.getPostDate()}</span>
                <span>| 조회 ${cateMaxPostIdxBoard.getPostVisits()}</span>
              </div>
              <hr>
            </div>
            <div class="article-container">
              <p class="pt-3 pb-5">${cateMaxPostIdxBoard.getPostContent()}</p>
            </div>
            <c:choose>
              <c:when test="${empty cateMaxPostIdxBoard.getPostOfile()}"/>
              <c:otherwise>
                <div class="article-file">
                  <div class="input-group input-group-sm">
                    <span class="input-group-text">첨부파일</span>
                    <input type="button" class="form-control text-start" name="postOfile"
                           value="${cateMaxPostIdxBoard.getPostOfile()}" readonly
                           onclick="location.href='/view/download.do?ofile=${cateMaxPostIdxBoard.getPostOfile()}&sfile=${cateMaxPostIdxBoard.getPostSfile()}&idx=${cateMaxPostIdxBoard.getPostIdx()}'">
                    <input type="hidden" value="${cateMaxPostIdxBoard.getPostSfile()}">
                    <span class="input-group-text">다운로드 수</span>
                    <span class="input-group-text">${cateMaxPostIdxBoard.getPostDnCount()}</span>
                  </div>
                </div>
              </c:otherwise>
            </c:choose>
          </c:otherwise>
        </c:choose>
      </div>
      <div class="mb-5 text-end">
        <a href="/view/write.do?cateNo=${cateNo}" id="btn-write" class="btn btn-sm btn-primary">글쓰기</a>
        <a href="#" id="btn-edit" class="btn btn-sm btn-dark">수정</a>
        <a href="#" id="btn-delete" class="btn btn-sm btn-secondary">삭제</a>
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
