<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>mainprofile</title>
  <link href="https://cdn.jsdelivr.net/npm/reset-css@5.0.2/reset.min.css" rel="stylesheet">
  <link rel="stylesheet" type="text/css" href="../css/profile.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="../js/page.js"></script>
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
        </div>
        <div class="statistics">
          <h2>summary</h2>
          <div class="age"><span class="title title-age">22</span></div>
          <div class="weight"><span class="title title-weight">53 kg</span></div>
          <div class="float-none"></div>
          <div class="height">
            <div class="icon"></div>
            <div class="data"><span>172 cm</span></div>
          </div>
          <div class="bmi"><span class="title title-bmi">20.4</span></div>
          <div class="fat"><span class="title title-fat">11<span class="percentage">%</span></span></div>
          <div class="float-none"></div>
        </div>
      </div>
      <div class="content-column">
        <div class="header-container" id="headerContainer">
          <div class="nav">
            <div class="content">
              <p>안녕하세요 <span class="name">회원 님</span>환영합니다</p>
              <span class="shape score">Healthy</span><span class="shape">life</span>
            </div>
          </div>
          <div class="float-none"></div>
          <div class="graph">
            <canvas id="bpChart" style="position: relative; z-index: 100;"></canvas>
          </div>
        </div>
        <div class="split">
         식단 추천
          
        </div>
        <div class="split">
          운동루틴 추천
          
        </div>
        <div class="split">
          <h2>BMI 측정</h2>
          <div class="weight">체중
            <input type='text' name="weight">
            <input type="submit" value="입력" name="bmiupdate">
          </div>
          
          <h2>당신의 BMI는</h2>
          <h2>입니다</h2>
          
          
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
        <div class="split">dwdw</div>
      </div>
    </div>
  </div>
</body>

</html>
