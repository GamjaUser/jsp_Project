<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>mainprofile</title>
  <link href="https://cdn.jsdelivr.net/npm/reset-css@5.0.2/reset.min.css" rel="stylesheet">
  <link rel="stylesheet" type="text/css" href="../css/profile2.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="../js/page.js"></script>
  <script src="../js/profile2.js"></script>
</head>

<body>
  <div class="container">
    <div id="modal_menubar">
      <div id="modalContent_menubar"></div>
    </div>
    <div id="main_content">
      <div class="summary-column">
        <div class="profile-img" id="profileImage"><img src="https://placeimg.com/400/400/face" />
          <div class="name">회원 <br> 프로필</div>
          
          <form action="${pageContext.request.contextPath}/profile/logout" method="post">
            <button type="submit" id="btnlogout" class="sub">로그아웃</button>
          </form>
        </div>
        <br><br>
        <div class="statistics">
          <h2>summary</h2>
          <div class="age"><span class="title title-age">${dto.age}</span></div>
          <div class="weight"><span class="title title-weight">${dtoinfo.weight}kg</span></div>
          <div class="float-none"></div>
          <div class="height">
            <div class="icon"></div>
            <div class="data"><span>${dtoinfo.height}cm</span></div>
          </div>
          <div class="bmi"><span class="title title-bmi">${bmi}</span></div>
          <div class="bmi"><span class="title title-fat">${bmiStatus}</span></div>
          <div class="float-none"></div>
        </div>변경 날짜: ${dtoinfo.sdate}
      </div>
      <div class="content-column">
        <div class="header-container" id="headerContainer">
          <div class="nav_profile">
            <div class="content">
              <p>안녕하세요 <span class="name">${dto.id} 님</span>환영합니다</p>
              <span class="shape score">Healthy</span><span class="shape">life</span>
            </div>
          </div>
          <div class="float-none"></div>
          <div class="graph">
            <canvas id="bpChart" style="position: relative; z-index: 100;"></canvas>
          </div>
        </div>
        <div class="split-food">
          <button id="toggleMealRecommendation" class="toggle-button">식단 추천 보기</button>
          <div class="meal-recommendation-content">
            <!-- 식단 추천 내용 -->
            dddddddddddddddddddddddddddddddddddddddddddddddddddddddddd
            <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
          </div>
        </div>
        
       <div class="split-container">
    <div class="split left">
        <h2>BMI 측정</h2>
        <form action="${pageContext.request.contextPath}/profile/updateBMI" method="post">
            <div class="form-group">
                <label for="weight">체중 (kg)</label>
                <input type="number" id="weight" name="weight" required>
            </div>
            <div class="form-group">
                <label for="height">신장 (cm)</label>
                <input type="number" id="height" name="height" required>
            </div>
            <div class="form-right">
                <button type="submit" id="btnstyle" class="sub">입력</button>
            </div>
        </form>
    </div>
    <div class="split right">
        <h2>당신의 BMI는 ${bmi2}입니다</h2>
        <h2>${bmiStatus2}</h2>
    </div>
</div>

      
      
      
      

        <div class="float-none"></div>
        <div class="split-container">
          <div class="split bottom">
            <div class="appointments">
              <div class="calendar-container">광고</div>
            </div>
          </div>
          <div class="split bottom">
            <div class="appointments">
              <div class="calendar-container">게시판</div>
            </div>
          </div>
          <div class="split bottom">
            <div class="appointments">
              <div class="calendar-container"></div>
            </div>
          </div>
        </div>
      </div>
      <div class="promotion">
        <div class="split">
        <h1>테스트</h1>
			    <p>아이디: ${dto.id}</p>
			    <p>나이: ${dto.age}</p>
			    <p>성별: ${dto.gender}</p>
			    <p>키: ${dtoinfo.height}</p>
			    <p>몸무게: ${dtoinfo.weight}</p>
			    <p>운동 경력: ${dto.exerciseEXP}</p>
			    <p>목표: ${dto.goals}</p>
			    <p>레벨: ${dto.level}</p>
			    <p>변경 날짜: ${dtoinfo.sdate}</p>
          <h2>광고페이지</h2>
          </div>
      </div>
    </div>
  </div>
</body>

</html>
