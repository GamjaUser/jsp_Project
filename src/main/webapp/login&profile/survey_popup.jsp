<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/survey_popup.css">
  
</head>
<body>
  
    <form action = "" id="survey-form" method="GET" class="columns column is-4 is-offset-4 form">
        <header>
            <h1 class="title is-2" id="title">설문조사</h1>
            
            <hr>
        </header>
        <fieldset>
            나이
           
         <select class="input-text" name="age" id="age"  required autofocus>
           <option value="" disabled selected></option>
           <option value="1" >1</option>
           <option value="1" >1</option>
           <option value="1" >1</option>
           <option value="1" >1</option>
           
           
           </select>
            성별 <br>
              <td>
            <input  type="radio" name="gender" id="gender" value="남" required>남성
            <input  type="radio" name="gender" id="gender" value="여" required>여성
              </td>
          <br><br>
            신장
            <input class="input-text" type="number" name = "height "id="height" min="120" max="300" required>
            체중
          <input class="input-text" type="number" name="weight" id="weight" min="20" max="300" required>
            

            평소에 운동을 어느정도 하고 있으신가요? 
            <div class="input-click">
                <span><input type="radio" name="healthyEXP" value="1" required>활동이 적거나 운동을 안하는 경우
</span>
                <span><input type="radio" name="healthyEXP" value="2">가벼운 활동 및 운동을 하는 경우(1~3일/1주)</span>
                <span><input type="radio" name="healthyEXP" value="3">보통의 활동 및 운동을 하는 경우(3~5일/1주)
</span>
                <span><input type="radio" name="healthyEXP" value="4">적극적인 활동 및 운동을 하는 경우(6~7일/1주)
</span>
              <span><input type="radio" name="healthyEXP" value="5">매우 적극적인 활동 및 운동, 운동선수
</span>
            </div>


            운동목표
            <div id="goals" class="input-click" >
                <span><input type="radio" name="goals" value="1" required>체중 감소
</span>
                <span><input type="radio" name="goals" value="2">벌크업</span>
                <span><input type="radio" name="goals" value="3">체력 향상
</span>
                <span><input type="radio" name="goals" value="4">유연성 향상
</span>
              
            </div>
            
            <button id="submit" class="button is-primary" type="submit">Submit</button>
        </fieldset>
        
    </form>
    <script>
        function populateAgeOptions() {
            const selectElement = document.getElementById('age');

            // 연령 범위 지정 (예: 1 ~ 100)
            const minAge = 1;
            const maxAge = 100;

            // 옵션을 반복문을 사용하여 생성
            for (let age = minAge; age <= maxAge; age++) {
                const option = document.createElement('option');
                option.value = age; // 옵션 값으로 연령을 지정
                option.textContent = age; // 옵션 표시 텍스트로 연령을 지정
                selectElement.appendChild(option); // 생성한 옵션을 <select> 요소에 추가
            }
        }

        // 페이지 로드 시 옵션을 생성
        window.addEventListener('DOMContentLoaded', populateAgeOptions);
        
        
        
    </script>

</body>
</html>