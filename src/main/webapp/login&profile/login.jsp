<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
  <meta charset="UTF-8">
  <title>For your Healthy life</title>
  <link href="https://cdn.jsdelivr.net/npm/reset-css@5.0.2/reset.min.css" rel="stylesheet">
  <link rel="stylesheet" type="text/css" href="../css/login.css">
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/paper.js/0.12.15/paper-full.min.js"></script>
  <script src="../js/login.js"></script>
  <script>
    $(document).ready(function() {
      // Sign Up 버튼 클릭 시 모든 데이터 전송
      $('#signUp').on('click', function(e) {
        e.preventDefault();

        // form 데이터 수집
        var id = $('#id').val();
        var password = $('#password-signup').val();
        var age = sessionStorage.getItem('age');
        var gender = sessionStorage.getItem('gender');
        var height = sessionStorage.getItem('height');
        var weight = sessionStorage.getItem('weight');
        var exerciseEXP = sessionStorage.getItem('exerciseEXP');
        var goals = sessionStorage.getItem('goals');

        $.ajax({
          type: 'POST',
          url: 'signupProcess.jsp',
          data: {
            id: id,
            password: password,
            age: age,
            gender: gender,
            height: height,
            weight: weight,
            exerciseEXP: exerciseEXP,
            goals: goals
          },
          success: function(response) {
            if (response.trim() === 'success') {
              alert('환영합니다');
              window.location.href = 'profile.jsp';
            } else {
              alert('회원가입에 실패하였습니다');
              history.back();
            }
          },
          error: function() {
            alert('회원가입에 실패하였습니다');
            history.back();
          }
        });
      });
    });
  </script>
</head>

<body>
  <div id="back">
    <canvas id="canvas" class="canvas-back"></canvas>
    <div class="backRight"></div>
    <div class="backLeft">
      <div id="modal_slide">
        <div id="modalContent_slide"></div>
      </div>
    </div>
  </div>

  <div id="slideBox">
    <div class="topLayer">
      <div class="left">
        <div class="content">
          <h2>Sign Up</h2>
          <form id="form-signup" method="post" onsubmit="return false;">
            <div class="form-element form-stack">
              <label for="email" class="form-label">ID</label>
              <input id="id" type="text" name="id">
            </div>
            <div class="form-element form-stack">
              <label for="password-signup" class="form-label">Password</label>
              <input id="password-signup" type="password" name="password">
            </div>
            <div class="form-element form-checkbox">
              <input id="confirm-terms" type="checkbox" name="confirm" value="yes" onchange="handleCheckboxChange()">
              <label for="confirm-terms">서비스 약관 및 개인 정보 보호 정책에 동의합니다</label>
            </div>
            <div id="modal">
              <div id="modalContent">
                <span id="closeBtn" onclick="closeModal()"></span>
              </div>
            </div>
            <div class="form-element form-submit">
              <button id="signUp" class="signup" type="submit" name="signup">Sign up</button>
              <button id="goLeft" class="signup off">Log In</button> <br /><br /><br /><br /><br />
            </div>
          </form>
        </div>
      </div>
      <div class="right">
        <div class="content">
          <h2>Login</h2>
          <form id="form-login" method="post" onsubmit="return false;">
            <div class="form-element form-stack">
              <label for="username-login" class="form-label">Username</label>
              <input id="username-login" type="text" name="username">
            </div>
            <div class="form-element form-stack">
              <label for="password-login" class="form-label">Password</label>
              <input id="password-login" type="password" name="password">
            </div>
            <div class="form-element form-submit">
              <button id="logIn" class="login" type="submit" name="login">Log In</button>
              <button id="goRight" class="login off" name="signup">Sign Up</button>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
  <canvas id="canvas" width="800" height="600"></canvas>
</body>
</html>
