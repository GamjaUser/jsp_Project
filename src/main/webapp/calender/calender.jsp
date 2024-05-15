<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Calendar"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>캘린더</title>
<link rel="stylesheet" type="text/css" href="../css/calender.css">
<style>
    .calendar-cal {
        margin-bottom: 20px;
    }
    .calendar h1 {
        display: inline-block;
    }
    .calendar .nav {
        display: inline-block;
        float: right;
    }
    .nav button {
        margin: 5px;
    }
</style>
<script>
    function changeDate(deltaYear, deltaMonth) {
        var yearInput = document.getElementById("year");
        var monthInput = document.getElementById("month");

        var year = parseInt(yearInput.value) + deltaYear;
        var month = parseInt(monthInput.value) + deltaMonth;

        if (month < 1) {
            month = 12;
            year--;
        } else if (month > 12) {
            month = 1;
            year++;
        }

        yearInput.value = year;
        monthInput.value = month;
        document.getElementById("dateForm").submit();
    }
</script>
</head>
<body>
<section>

  <article>
    <div class="menu">
      <input id="menu--toggle"
             type="checkbox" />
      <!-- /#menu--toggle -->
      <label class="menu--toggle__trigger"
             for="menu--toggle"></label>
      <!-- /.menu--toggle__trigger -->
      <label class="menu--toggle__burger"
             for="menu--toggle"></label>
      <!-- /.menu--toggle__burger -->


      <ul class="menu__body">
        <li class="menu__body-element">
          <a class="menu__body-link"
             href="">
            <h3>게시판</h3>   
          </a>
			  <ol>
			  	<li><a class="menu__body-link"href="">자유 게시판</a></li>
			  	<li><a class="menu__body-link"href="">질문 게시판</a></li>
			  	<li><a class="menu__body-link"href="">리뷰 게시판</a></li>
			  </ol>
          <!-- /.menu__body-link -->
          
        </li>
        
        <!-- /.menu__body-element -->

        <li class="menu__body-element">
          <a class="menu__body-link"
             href=""
             >
				 <h3>Calendar</h3>
          </a>
          <!-- /.menu__body-link -->
        </li>
        <!-- /.menu__body-element -->

        <li class="menu__body-element">
          <a class="menu__body-link"
             href="">
            <h3>shop</h3>
          </a>
          <!-- /.menu__body-link -->
        </li>
        <li class="menu__body-element">
          <a class="menu__body-link"
             href="" arget="_blank">
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

  
  
  
<div class="container">
  <div class="menu-column">
    <ul class="nav">
    	<a href="../login&profile/profile.jsp">
      <li class="profile-img"></li>
    	</a>
      <li class="board"></li>
      <a href="../calender/calender.jsp">
      <li class="calendar"></li>
      </a>
      <li class="shop"></li>
      <li class="settings"></li>
    </ul>
  </div>
	</div>






<%
// 현재 년도 설정
Calendar cal = Calendar.getInstance();
int currentYear = cal.get(Calendar.YEAR);
int currentMonth = cal.get(Calendar.MONTH) + 1;

// 입력된 년도와 월 가져오기
int inputYear = (request.getParameter("year") != null) ? Integer.parseInt(request.getParameter("year")) : currentYear;
int inputMonth = (request.getParameter("month") != null) ? Integer.parseInt(request.getParameter("month")) : currentMonth;

// 입력된 년도와 월에 해당하는 달력 출력
cal.set(inputYear, inputMonth - 1, 1); // 해당 년도와 월의 1일로 설정
%>

<div class="calendar-cal">
   
    <div class="nav-cal">
    	<h1>
    <button type="button" class="nav-button" onclick="changeDate(0, -1)"> <- </button>
    <%= inputYear %>년 <%= inputMonth %>월 달력 
    <button type="button" class="nav-button" onclick="changeDate(0, 1)">-></button>
</h1>
      <br />  
    </div>
    <table>
        <thead>
            <tr>
                <th>일</th>
                <th>월</th>
                <th>화</th>
                <th>수</th>
                <th>목</th>
                <th>금</th>
                <th>토</th>
            </tr>
        </thead>
        <tbody>
            <%
            // 해당 월의 시작 요일로 설정
            int startDayOfWeek = cal.get(Calendar.DAY_OF_WEEK);

            // 해당 월의 시작 날짜로 설정
            cal.set(Calendar.DAY_OF_MONTH, 1);

            // 해당 월의 달력 출력
            while (cal.get(Calendar.MONTH) + 1 == inputMonth) {
                out.println("<tr>");
                for (int i = 1; i <= 7; i++) {
                    if (cal.get(Calendar.DAY_OF_WEEK) == i) {
                        // 해당 요일에 해당하는 날짜 출력
                        out.println("<td>" + cal.get(Calendar.DAY_OF_MONTH) + "</td>");
                        cal.add(Calendar.DAY_OF_MONTH, 1);
                    } else {
                        // 빈 셀 출력
                        out.println("<td></td>");
                    }
                }
                out.println("</tr>");
            }
            %>
        </tbody>
    </table>
    <form id="dateForm" action="" method="post">
        <input type="hidden" id="year" name="year" value="<%= inputYear %>">
        <input type="hidden" id="month" name="month" value="<%= inputMonth %>">
    </form>
</div>

</body>
</html>