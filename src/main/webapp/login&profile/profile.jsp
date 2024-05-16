<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mainprofile</title>
<link rel="stylesheet" type="text/css" href="../css/profile.css">
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
	
	
	
  <div class="summary-column">
    <div class="profile-img" id="profileImage"><img src="https://placeimg.com/400/400/face"/>
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
      <h2 class="allergies">allergies</h2>
      <div class="row">peanuts
        <div class="severity">
          <div class="fill" style="width: 45%; height: inherit;"></div>
        </div>
      </div>
      <div class="row">penicilin
        <div class="severity">
          <div class="fill" style="width: 80%; height: inherit;"></div>
        </div>
      </div>
    </div>
  </div>
  <div class="content-column">
    <div class="header-container" id="headerContainer">
      <div class="nav">
        <div class="content">
          <p>
             안녕하세요 <span class="name">회원 님</span>환영합니다</p><span class="shape score">Healthy</span><span class="shape"> life</span>
        </div>
      </div>
      
      <div class="float-none"></div>
      <div class="graph">
        <canvas id="bpChart" style="position: relative; z-index: 100;"></canvas>
      </div>
    </div>
    <div class="split-container">
      <div class="split">
        <div class="kcalfood">식단 추천</div>
        <div class="split-graph">
          <canvas id="temperatureGraph"></canvas>
        </div>
      </div>
      <div class="split">
        <div class="healthyroutine">운동루틴 추천</div>
        <div class="split-graph">
          <canvas id="calorieGraph"></canvas>
        </div>
      </div>
    </div>
    <div class="daybmi">
      <div class="totals">
        <div class="weight">체중
          <input type='text' name="weight">
          <input type="submit" value="입력" name="bmiupdate">
        </div>
        <div class="sleep-graph">
        <div class="sleep-graph-bmi">
          <h2>당신의 BMI는</h2>
          <h2>입니다</h2>
        </div>
        </div>
        <div class="split">    
          
        </div>
      </div>
      <div class="sleep-graph">
        <div class="sleep-graph-container">
          <h2> BMI 측정</h2>
          <div class="sleep-select-wrapper">
            <select>
              <option value="today">Today</option>
            </select>
          </div>
          <div class="chart-container">
            <canvas id="sleepChart"></canvas>
            
          </div>
        </div>
      </div>
    </div>
    <div class="float-none"></div>
    <div class="split-container">
      <div class="split bottom">
        <h2>Appointments</h2>
        <div class="appointments">
          <div class="calendar-container">
            <div class="calendar">25<span class="date">th</span><span class="month">Jul</span></div>
            <div class="content">
              <table class="appointment-table">
                <tr>
                  <td id="time">13:00</td>
                </tr>
                <tr>
                  <td id="title">Dentist</td>
                </tr>
                <tr>
                  <td id="name">Jozef Novotny</td>
                </tr>
              </table>
            </div>
          </div>
        </div>
      </div>
      <div class="split bottom">
        <h2>Doctors around</h2>
        <table class="doctor-grid">
          <tr>
            <td height="65"><img src="https://placeimg.com/65/65/people"/></td>
            <td><img src="https://placeimg.com/65/65/face"/></td>
            <td><img src="https://placeimg.com/65/65/people"/></td>
          </tr>
          <tr>
            <td><img src="https://placeimg.com/65/65/face"/></td>
            <td><img src="https://placeimg.com/65/65/people"/></td>
            <td id="expand">
              <div class="background">
                +8
                
              </div>
            </td>
          </tr>
        </table>
      </div>
      <div class="split bottom">
        <div id="map"></div>
        <div class="map-overlay">
          <h2>Steps today</h2><span class="steps">4578</span><span class="distance">1.7 km</span>
        </div>
      </div>
    </div>
  </div>
  
</div>
</body>
</html>