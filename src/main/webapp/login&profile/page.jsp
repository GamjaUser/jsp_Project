<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
  <meta charset="UTF-8">
  <title>page</title>
  <link href="
  https://cdn.jsdelivr.net/npm/reset-css@5.0.2/reset.min.css
  " rel="stylesheet">
  <link rel="stylesheet" type="text/css" href="../css/page.css">
</head>

<body>
  <div class="menu-container">
    <section>

      <article>
        <div class="menu">
          <input id="menu--toggle" type="checkbox" />
          <!-- /#menu--toggle -->
          <label class="menu--toggle__trigger" for="menu--toggle"></label>
          <!-- /.menu--toggle__trigger -->
          <label class="menu--toggle__burger" for="menu--toggle"></label>
          <!-- /.menu--toggle__burger -->


          <ul class="menu__body">
            <li class="menu__body-element">
              <a class="menu__body-link" href="">
                <h3>게시판</h3>
              </a>
              <ol>
                <li><a class="menu__body-link" href="">자유 게시판</a></li>
                <li><a class="menu__body-link" href="">리뷰 게시판</a></li>
                <li><a class="menu__body-link" href="">질문 게시판</a></li>
              </ol>
              <!-- /.menu__body-link -->

            </li>

            <!-- /.menu__body-element -->

            <li class="menu__body-element">
              <a class="menu__body-link" href="">
                <h3>Calendar</h3>
              </a>
              <!-- /.menu__body-link -->
            </li>
            <!-- /.menu__body-element -->

            <li class="menu__body-element">
              <a class="menu__body-link" href="">
                <h3>shop</h3>
              </a>
              <!-- /.menu__body-link -->
            </li>
            <li class="menu__body-element">
              <a class="menu__body-link" href="" arget="_blank">
                <h3>setting</h3>
              </a>
              <!-- /.menu__body-link -->
            </li>
            <!-- /.menu__body-element -->
          </ul>
          <!-- /.menu__body -->
        </div>
        <!-- /.menu -->
      </article>


      <article>
        <div class="promotion">
        </div>
        <!-- /.promotion -->
      </article>

    </section>





    <div class="menu-column">
      <ul class="nav">
        <a href="../login&profile/profile.jsp">
          <li class="profile-img"></li>
        </a>
        <li class="board"></li>
        <a href="../calender/calender.jsp">
          <li class="calendar"></li>
        </a>
        <a href="../shopping/shopMain.jsp"><li class="shop"></li></a>
        <a href="../shopping/cartMain.jsp"><li class="shopping-cart"></li></a>
        <li class="settings"></li>
      </ul>
    </div>
  </div>

</body>

</html>