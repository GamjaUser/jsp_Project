<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>For your Healthy life</title>
<link rel="stylesheet" type="text/css" href="../css/login.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/paper.js/0.12.15/paper-full.min.js"></script>
<script>
        // 모달을 여는 함수
        function openModal() {
            // 다른 JSP 파일의 URL
            const popupUrl = '../login&profile/survey_popup.jsp';
            
            // AJAX 요청을 통해 다른 JSP 파일의 내용을 가져옵니다.
            $.get(popupUrl, function(response) {
                // 모달 내부에 가져온 내용을 표시합니다.
                $('#modalContent').html(response);
                
                // 모달을 표시합니다.
                $('#modal').css('display', 'block');
            });
        }
        
        // 모달을 닫는 함수
        function closeModal() {
            $('#modal').css('display', 'none');
        }
    </script>
    
</head>
<body>

<div id="back">
  <canvas id="canvas" class="canvas-back"></canvas>
  <div class="backRight">    
  </div>
  <div class="backLeft">
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
            <input id="email" type="email" name="email">
          </div>
          <div class="form-element form-stack">
            <label for="username-signup" class="form-label">Username</label>
            <input id="username-signup" type="text" name="username">
          </div>
          <div class="form-element form-stack">
            <label for="password-signup" class="form-label">Password</label>
            <input id="password-signup" type="password" name="password">
          </div>
          
          
          <div class="form-element form-checkbox">
            <input id="confirm-terms" type="checkbox" name="confirm" value="yes"  onclick="openModal()">
            <label for="confirm-terms">서비스 약관 및 개인 정보 보호 정책에 동의합니다</label>
                    
      
          </div>
          <div id="modal">
        <div id="modalContent">
            <span id="closeBtn" onclick="closeModal()"></span>
            <!-- 모달 내용이 AJAX로 로드됩니다. -->
        </div>
    </div>
          <div class="form-element form-submit">
            <button id="signUp" class="signup" type="submit" name="signup" >Sign up</button>
            <button id="goLeft" class="signup off" >Log In</button> <br /><br /><br /><br /><br />
            
            

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




<script>
/* ====================== *
 *  Toggle Between        *
 *  Sign Up / Login       *
 * ====================== */
$(document).ready(function(){
    $('#goRight').on('click', function(){
        $('#slideBox').animate({
            'marginLeft' : '0'
        });
        $('.topLayer').animate({
            'marginLeft' : '100%'
        });
    });

    $('#goLeft').on('click', function(){
        if (window.innerWidth > 769){
            $('#slideBox').animate({
                'marginLeft' : '50%'
            });
        } else {
            $('#slideBox').animate({
                'marginLeft' : '20%'
            });
        }
        $('.topLayer').animate({
            'marginLeft': '0'
        });
    });
});

// Paper.js 코드를 포함합니다.
paper.install(window);
paper.setup(document.getElementById("canvas"));

var canvasWidth, 
    canvasHeight,
    canvasMiddleX,
    canvasMiddleY;

var shapeGroup = new Group();
var positionArray = [];

function getCanvasBounds() {
    // 캔버스 크기 가져오기
    canvasWidth = view.size.width;
    canvasHeight = view.size.height;
    canvasMiddleX = canvasWidth / 2;
    canvasMiddleY = canvasHeight / 2;
    var position1 = { x: (canvasMiddleX / 2) + 100, y: 100 };
    var position2 = { x: 200, y: canvasMiddleY };
    var position3 = { x: (canvasMiddleX - 50) + (canvasMiddleX / 2), y: 150 };
    var position4 = { x: 0, y: canvasMiddleY + 100 };
    var position5 = { x: canvasWidth - 130, y: canvasHeight - 75 };
    var position6 = { x: canvasMiddleX + 80, y: canvasHeight - 50 };
    var position7 = { x: canvasWidth + 60, y: canvasMiddleY - 50 };
    var position8 = { x: canvasMiddleX + 100, y: canvasMiddleY + 100 };
    positionArray = [position3, position2, position5, position4, position1, position6, position7, position8];
}

function initializeShapes() {
    getCanvasBounds();
    var shapePathData = [
        'M231,352l445-156L600,0L452,54L331,3L0,48L231,352',
        'M0,0l64,219L29,343l535,30L478,37l-133,4L0,0z',
        'M0,65l16,138l96,107l270-2L470,0L337,4L0,65z',
        'M333,0L0,94l64,219L29,437l570-151l-196-42L333,0',
        'M331.9,3.6l-331,45l231,304l445-156l-76-196l-148,54L331.9,3.6z',
        'M389,352l92-113l195-43l0,0l0,0L445,48l-80,1L122.7,0L0,275.2L162,297L389,352',
        'M 50 100 L 300 150 L 550 50 L 750 300 L 500 250 L 300 450 L 50 100',
        'M 700 350 L 500 350 L 700 500 L 400 400 L 200 450 L 250 350 L 100 300 L 150 50 L 350 100 L 250 150 L 450 150 L 400 50 L 550 150 L 350 250 L 650 150 L 650 50 L 700 150 L 600 250 L 750 250 L 650 300 L 700 350 '
    ];

    for (var i = 0; i <= shapePathData.length; i++) {
        var headerShape = new Path({
            strokeColor: 'rgba(255, 255, 255, 0.5)',
            strokeWidth: 2,
            parent: shapeGroup,
        });
        headerShape.pathData = shapePathData[i];
        headerShape.scale(2);
        headerShape.position = positionArray[i];
    }
}

initializeShapes();

view.onFrame = function(event) {
    if (event.count % 4 === 0) {
        for (var i = 0; i < shapeGroup.children.length; i++) {
            if (i % 2 === 0) {
                shapeGroup.children[i].rotate(-0.1);
            } else {
                shapeGroup.children[i].rotate(0.1);
            }
        }
    }
};

view.onResize = function() {
    getCanvasBounds();

    for (var i = 0; i < shapeGroup.children.length; i++) {
        shapeGroup.children[i].position = positionArray[i];
    }

    if (canvasWidth < 700) {
        shapeGroup.children[3].opacity = 0;
        shapeGroup.children[2].opacity = 0;
        shapeGroup.children[5].opacity = 0;
    } else {
        shapeGroup.children[3].opacity = 1;
        shapeGroup.children[2].opacity = 1;
        shapeGroup.children[5].opacity = 1;
    }
};
</script>

</body>
</html>