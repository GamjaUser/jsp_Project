<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
  <meta charset="UTF-8">
  <title>For your Healthy life</title>
  <link href="
https://cdn.jsdelivr.net/npm/reset-css@5.0.2/reset.min.css
" rel="stylesheet">
  <link rel="stylesheet" type="text/css" href="../css/login.css">
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/paper.js/0.12.15/paper-full.min.js"></script>
  <script src="../js/login.js"></script>

</head>

<body>

  <div id="back">
    <canvas id="canvas" class="canvas-back"></canvas>
    <div class="backRight">

    </div>
    <div class="backLeft">
      <div id="modal_slide">
        <div id="modalContent_slide">

        </div>
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
              <label for="username-signup" class="form-label">Username</label>
              <input id="username-signup" type="text" name="username">
            </div>
            <div class="form-element form-stack">
              <label for="password-signup" class="form-label">Password</label>
              <input id="password-signup" type="password" name="password">
            </div>
            <div class="form-element form-stack">
              <label for="password-signup-check" class="form-label">Password check</label>
              <input id="password-signup-check" type="password" name="password">
            </div>
           


            <div class="form-element form-checkbox">
              <input id="confirm-terms" type="checkbox" name="confirm" value="yes" onchange="handleCheckboxChange()">
              <label for="confirm-terms">서비스 약관 및 개인 정보 보호 정책에 동의합니다</label>
            </div>
            <div id="modal">
              <div id="modalContent">
                <span id="closeBtn" onclick="closeModal()"></span>
                <!-- 모달 내용이 AJAX로 로드됩니다. -->
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
