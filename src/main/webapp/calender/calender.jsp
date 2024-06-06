<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Calendar"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>캘린더</title>
<link href="
https://cdn.jsdelivr.net/npm/reset-css@5.0.2/reset.min.css
" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="../css/calender.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="../js/calender.js"></script>



</head>
<body>

<div class="container">
  <div id="modal_menubar">
    <div id="modalContent_menubar">
      <%@ include file="../login&profile/page.jsp" %>
    </div>
  </div>
	<div id="main_content">
            
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
   ${dto.id}
    <div class="nav-cal">
    	<h1>
    <button type="button" class="nav-button1" onclick="changeDate(0, -1)"> < </button>
    <%= inputYear %>년 <%= inputMonth %>월 달력 
    <button type="button" class="nav-button2" onclick="changeDate(0, 1)">></button>
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
		
        </div>
</div>
</body>
</html>