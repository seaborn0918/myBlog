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
      // 로그인 확인
      <c:choose>
      <c:when test="${empty userId}">
      $("#btn-write").hide();
      $("#empty-btn-write").hide();
      $("#btn-edit").hide();
      $("#btn-delete").hide();
      </c:when>
      <c:otherwise>
      $("#btn-write").show();
      $("#btn-edit").show();
      $("#btn-delete").show();
      </c:otherwise>
      </c:choose>

      // 수정, 삭제 : 가장 최신 글 출력 페이지와 제목 클릭 시 출력된 페이지 구분
      // 수정
      <c:choose>
      <c:when test="${not empty cateBoard}">
      $("#btn-edit").on("click", function () {
        const postIdx = $("#post-idx").val();
        const cateNo = $("#cate-no").val();
        location.href = "/view/edit.do?idx=" + postIdx + "&cateNo=" + cateNo;
      });
      </c:when>
      <c:otherwise>
      $("#btn-edit").on("click", function () {
        const postIdx = $("#post-max-idx").val();
        const cateNo = $("#max-cate-no").val();
        location.href = "/view/edit.do?idx=" + postIdx + "&cateNo=" + cateNo;
      });
      </c:otherwise>
      </c:choose>

      // 삭제 확인
      <c:choose>
      <c:when test="${not empty cateBoard}">
      $("#btn-delete").on("click", function () {
        const deleteCheck = confirm("정말 삭제하시겠습니까?");
        if (deleteCheck) {
          const postIdx = $("#post-idx").val();
          const cateNo = $("#cate-no").val();
          location.href = "/view/delete.do?idx=" + postIdx + "&cateNo=" + cateNo;
        } else {
          return false;
        }
      });
      </c:when>
      <c:otherwise>
      $("#btn-delete").on("click", function () {
        const deleteCheck = confirm("정말 삭제하시겠습니까?");
        if (deleteCheck) {
          const postIdx = $("#post-max-idx").val();
          const cateNo = $("#max-cate-no").val();
          location.href = "/view/delete.do?idx=" + postIdx + "&cateNo=" + cateNo;
        } else {
          return false;
        }
      });
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
        <table class="table table-sm table-hover table-fontsize caption-top">
          <c:choose>
            <c:when test="${not empty cateBoard}">
              <caption>${cateBoard.getPostCate()} - 총 ${totalCateCount}개의 글이 있습니다.</caption>
            </c:when>
            <c:otherwise>
              <caption>${cateMaxPostIdxBoard.getPostCate()} - 총 ${totalCateCount}개의 글이 있습니다.</caption>
            </c:otherwise>
          </c:choose>
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
                       href="<c:url value="/view/cateView.do?idx=${item.postIdx}&cateNo=${item.cateNo}&pageNum=${pageNum}"/>"
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
        ${pagingBlock}
      </div>
      <%-- 게시글 내용 --%>
      <div class="bg-white my-3 p-4 rounded-4">
        <c:choose>
          <c:when test="${empty cateBoardList}">
            <div></div>
          </c:when>
          <%-- 상단의 전체 글 목록에서 제목 클릭했을 시 해당 게시글 출력--%>
          <c:when test="${not empty cateBoard}">
            <div class="article-header">
              <div class="article-title text-center my-3">
                <h1>${cateBoard.getPostTitle()}</h1>
              </div>
              <div class="writer-info">
                <span>${cateBoard.getPostWriter()}</span>
                <br>
                <input type="hidden" id="post-idx" name="postIdx" value="${cateBoard.getPostIdx()}">
                <span>글번호 ${cateBoard.getPostIdx()}</span>
                <input type="hidden" id="cate-no" name="cateNo" value="${cateBoard.getCateNo()}">
                <span>| ${cateBoard.getPostCate()}</span>
                <span>| ${cateBoard.getPostDate()}</span>
                <span>| 조회 ${cateBoard.getPostVisits()}</span>
              </div>
              <hr>
            </div>
            <div class="article-container">
              <p class="pt-3 pb-5">${cateBoard.getPostContent()}</p>
            </div>
            <%-- 첨부파일이 있을 경우에만 화면에 첨부파일 다운로드 출력--%>
            <c:if test="${not empty cateBoard.getPostOfile()}">
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
            </c:if>
          </c:when>
          <%-- (카테고리의 기본화면)카테고리 클릭했을 시 카테고리 글 중 가장 최신 글 출력 --%>
          <c:otherwise>
            <div class="article-header">
              <div class="article-title text-center my-3">
                <h1>${cateMaxPostIdxBoard.getPostTitle()}</h1>
              </div>
              <div class="writer-info">
                <span>${cateMaxPostIdxBoard.getPostWriter()}</span>
                <br>
                <input type="hidden" id="post-max-idx" name="postIdx" value="${cateMaxPostIdxBoard.getPostIdx()}">
                <span>글번호 ${cateMaxPostIdxBoard.getPostIdx()}</span>
                <input type="hidden" id="max-cate-no" name="maxCateNo" value="${cateMaxPostIdxBoard.getCateNo()}">
                <span>| ${cateMaxPostIdxBoard.getPostCate()}</span>
                <span>| ${cateMaxPostIdxBoard.getPostDate()}</span>
                <span>| 조회 ${cateMaxPostIdxBoard.getPostVisits()}</span>
              </div>
              <hr>
            </div>
            <div class="article-container">
              <p class="pt-3 pb-5">${cateMaxPostIdxBoard.getPostContent()}</p>
            </div>
            <c:if test="${not empty cateMaxPostIdxBoard.getPostOfile()}">
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
            </c:if>
          </c:otherwise>
        </c:choose>
      </div>
      <c:choose>
        <c:when test="${empty cateBoardList}">
          <div class="article-bottom-button mb-5 row">
            <div class="col-sm">
              <a href="/view/write.do?cateNo=${cateNo}" id="empty-btn-write" class="btn btn-sm btn-primary">글쓰기</a>
            </div>
          </div>
        </c:when>
        <c:otherwise>
          <div class="article-bottom-button mb-5 row">
            <div class="col-sm">
              <a href="/view/write.do?cateNo=${cateNo}" id="btn-write" class="btn btn-sm btn-primary">글쓰기</a>
            </div>
            <div class="col-sm d-flex justify-content-end">
              <button type="button" id="btn-edit" class="btn btn-sm btn-dark me-2">수정</button>
              <button type="button" id="btn-delete" class="btn btn-sm btn-secondary">삭제</button>
            </div>
          </div>
        </c:otherwise>
      </c:choose>
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
