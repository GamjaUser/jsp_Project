<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>mainprofile</title>
  <link href="https://cdn.jsdelivr.net/npm/reset-css@5.0.2/reset.min.css" rel="stylesheet">
  <link rel="stylesheet" type="text/css" href="../css/profile.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

  <script src="../js/profile.js"></script>
</head>
<script>
$(document).ready(function() {
    $("#toggleMealRecommendation").click(function() {
        $.ajax({
            url: "/profile/dietguide.do",
            type: "GET",
            dataType: "json",
            success: function(response) {
                document.getElementById("bmValue").innerText = response.bm + "kcal";
                document.getElementById("amValue").innerText = response.am + "kcal";
                document.getElementById("imValue").innerText = response.im + "kcal";
                document.getElementById("carValue").innerText = response.car + "g";
                document.getElementById("proValue").innerText = response.pro + "g";
                document.getElementById("fatValue").innerText = response.fat + "g";
                document.getElementById("carValue2").innerText = response.car2 + "g";
                document.getElementById("proValue2").innerText = response.pro2 + "g";
                document.getElementById("fatValue2").innerText = response.fat2 + "g";
                document.getElementById("mealValue").innerText = response.meal + "kcal";

                renderFoods(response.carbohydrateFoods, "carbohydrateFoods");
                renderFoods(response.proteinFoods, "proteinFoods");
                renderFoods(response.fatFoods, "fatFoods");
            },
            error: function(xhr, status, error) {
                console.error("AJAX 요청 실패:", error);
            }
        });
    });
});

function renderFoods(foods, containerId) {
    var container = document.getElementById(containerId);
    container.innerHTML = "";
    foods.forEach(function(food) {
        var foodItem = document.createElement("div");
        foodItem.classList.add("food-item");
        var img = document.createElement("img");
        img.src = food.image;
        var name = document.createElement("p");
        name.innerText = food.name;
        var nutrient = document.createElement("p");
        nutrient.innerText =  food.nutrient + "g";
        var calories = document.createElement("p");
        calories.innerText = food.calories + "kcal";
        foodItem.appendChild(img);
        foodItem.appendChild(name);
        foodItem.appendChild(nutrient);
        foodItem.appendChild(calories);
        container.appendChild(foodItem);
    });
}
</script>
<body>
  <div class="container">
    <div id="modal_menubar">
      <div id="modalContent_menubar">
        <%@ include file="../login&profile/page.jsp" %>
      </div>
    </div>
    <div class="summary-column">
    	<div>
	      <div class="profile-img" id="profileImage">
	        
	        <div class="name"><br>${dto.id}님의 회원 프로필 <br>성별 : ${dto.gender}<br>운동 목표: ${goals}</div>
	        <form action="${pageContext.request.contextPath}/profile/logout" method="post">
	          <button type="submit" id="btnlogout" class="sub">로그아웃</button>
	        </form>
	      </div>
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
      </div> 
        <p>변경날짜 : ${dtoinfo.sdate}</p>
      <div class="float-none1"></div>
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
          <h1>${dto.id} 님의 식단 가이드</h1>
          <p>기초 대사량 <br><span id="bmValue"></span> <br><br><br><br>활동 대사량 <br><span id="amValue"></span></p>
          <div class="meal">
            일일 섭취 열량 : <span id="imValue"></span> <br>
            = <span id="mealValue"></span> X 3끼니
          </div>
          <div class="kcalguide">
            <p>끼니당 영양소 <br> 섭취 목표</p>
            <div class="kcalguide1"><br>탄수화물 <br><br> <span id="carValue"></span></div>
            <div class="kcalguide1"><br>단백질 <br><br> <span id="proValue"></span></div>
            <div class="kcalguide1"><br>지방 <br><br> <span id="fatValue"></span></div>
          </div>
          <div class="meal-recommendation-content-food">
            <p>탄수화물 <span id="carValue2"></span> 섭취</p> <br>
            <div id="carbohydrateFoods"></div>
          </div>
          <div class="meal-recommendation-content-food">
            <p>단백질 <span id="proValue2"></span> 섭취</p> <br>
            <div id="proteinFoods"></div>
          </div>
          <div class="meal-recommendation-content-food">
            <p>지방 <span id="fatValue2"></span> 섭취</p> <br>
            <div id="fatFoods"></div>
          </div>
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
      <div class="float-none"></div> <br>
      <div class="split-container">
   		 <div class="split bottom">
        	<div class="appointments">
            	<!-- 운동 루틴 추가 -->
          <div class="workout-routine">
            

                <h3>운동 목표: ${goals}</h3>
            <h2>운동 루틴</h2>
                <ul>
                  <c:forEach var="exercise" items="${selectedRoutine}">
                    <li>${exercise}</li>
                  </c:forEach>
                </ul>
              </div>
           
          </div>
        </div>
      
        </div>
    </div>
</div>
    </div>
    <div class="promotion">
      <div class="split">
         <%@ include file="../login&profile/profile_slide.jsp" %>
      </div>
    </div>

</body>

</html>
