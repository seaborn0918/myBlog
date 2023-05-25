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
    <div class="col-md-10">
      <h1>방명록</h1>
      <table class="table table-bordered text-center table-hover">
        <colgroup>
          <col style="width: 5%">
          <col style="width: 60%">
          <col style="width: 10%">
          <col style="width: 15%">
          <col style="width: 10%">
        </colgroup>
        <thead>
        <tr>
          <th class="text-nowrap">번호</th>
          <th>내용</th>
          <th class="text-nowrap">작성자</th>
          <th>메일</th>
          <th>작성일</th>
        </tr>
        </thead>
        <tbody class="table-group-divider">
        <tr>
          <td>1</td>
          <td class="text-start">안녕하세요</td>
          <td class="text-nowrap">사용자1</td>
          <td>abc@gmail.com</td>
          <td>2023.05.24</td>
        </tr>
        </tbody>
      </table>
    </div>
  </div>
</main>
<footer class="container-fluid bg-white py-5 text-center">
  <span>made by KSH</span><br>
  <a href="#" class="text-dark fs-1"><i class="bi bi-github"></i></a>
</footer>
</body>
</html>
