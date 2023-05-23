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
      <%-- 상단 게시글 목록 --%>
      <div class="board-list">
        <table class="table table-sm table-hover table-fontsize">
          <colgroup>
            <col style="width: 75%">
            <col style="width: 25%">
          </colgroup>
          <tbody>
          <tr>
            <td><a href="#" class="text-decoration-none text-dark">게시글 제목1</a></td>
            <td class="text-end">2023.05.23</td>
          </tr>
          <tr>
            <td>게시글 제목2</td>
            <td class="text-end">2023.05.23</td>
          </tr>
          <tr>
            <td>게시글 제목3</td>
            <td class="text-end">2023.05.23</td>
          </tr>
          </tbody>
        </table>
      </div>
      <%-- 게시글 내용 --%>
      <div class="bg-white my-3 p-4 rounded-4">
        <h1>글 제목1</h1>
        <p class="mb-0">Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus. Phasellus viverra nulla ut metus varius laoreet. Quisque rutrum. Aenean imperdiet. Etiam ultricies nisi vel augue. Curabitur ullamcorper ultricies nisi. Nam eget dui. Etiam rhoncus. Maecenas tempus, tellus eget condimentum rhoncus, sem quam semper libero, sit amet adipiscing sem neque sed ipsum. Nam quam nunc, blandit vel, luctus pulvinar, hendrerit id, lorem. Maecenas nec odio et ante tincidunt tempus.

          Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim.

          Our team
          Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem.

          Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante.

          Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem.

          Donec quam felis
          Consectetuer adipiscing
          Donec quam felis
          Consectetuer adipiscing
          Donec quam felis
          Consectetuer adipiscing
          Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus. Phasellus viverra nulla ut metus varius laoreet. Quisque rutrum. Aenean imperdiet. Etiam ultricies nisi vel augue. Curabitur ullamcorper ultricies nisi. Nam eget dui. Etiam rhoncus. Maecenas tempus, tellus eget condimentum rhoncus, sem quam semper libero, sit amet adipiscing sem neque sed ipsum. Nam quam nunc, blandit vel, luctus pulvinar, hendrerit id, lorem. Maecenas nec odio et ante tincidunt tempus.</p>
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
