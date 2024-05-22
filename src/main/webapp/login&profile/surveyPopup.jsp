<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <link href="https://cdn.jsdelivr.net/npm/reset-css@5.0.2/reset.min.css" rel="stylesheet">
  <link rel="stylesheet" type="text/css" href="../css/surveyPopup.css">
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <script src="../js/surveyPopup.js"></script>
  <script>
  $(document).ready(function() {
	  $('#submit').on('click', function(e) {
	    e.preventDefault(); // 기본 폼 제출 동작 방지
	    var formData = $('#j').serialize(); // 폼 데이터 직렬화
	    $.ajax({
	      type: 'POST',
	      url: 'signupProcess.jsp',
	      data: formData,
	      success: function(response) {
	        // 성공적으로 전송된 후 수행할 작업
	        $('body').html(response); // JSP 응답을 페이지에 표시
	      },
	      error: function(error) {
	        // 오류 발생 시 수행할 작업
	        alert('폼 전송 중 오류가 발생했습니다.');
	      }
	    });
	  });

	  // 이전 버튼 클릭 이벤트
	  $('.mm-prev-btn button').on('click', function(e) {
	    e.preventDefault();
	    var currentPage = $('.mm-survey-page.active');
	    var prevPage = currentPage.prev('.mm-survey-page');
	    if (prevPage.length > 0) {
	      currentPage.removeClass('active');
	      prevPage.addClass('active');
	    }
	  });

	  // 다음 버튼 클릭 이벤트
	  $('.mm-next-btn button').on('click', function(e) {
	    e.preventDefault();
	    var currentPage = $('.mm-survey-page.active');
	    var nextPage = currentPage.next('.mm-survey-page');
	    if (nextPage.length > 0) {
	      currentPage.removeClass('active');
	      nextPage.addClass('active');
	    }
	  });
	});
  </script>
</head>
<body>
<form action="signupProcess.jsp" id="j">
  <div class="container">
		<div class="col-sm-12">
			<div class="mm-survey">

				<div class="mm-survey-progress">
					<div class="mm-survey-progress-bar mm-progress"></div>
				</div>

				<div class="mm-survey-results">
					<div class="mm-survey-results-container">
						<h3 class="mm-survey-results-score"></h3>
						<ul class="mm-survey-results-list"></ul>
					</div>
					<
				</div>

				<div class="mm-survey-bottom">
					<div class="mm-survey-container">

						<div class="mm-survey-page active" data-page="1">
							<div class="mm-survery-content">
								<div class="mm-survey-question">
									<p>나이를 입력해주세요</p>
								</div>
								<div class="mm-survey-item">
									<input type="number" id="radio01" data-item="1" name="age" value="age" min="1" required/>
									<label for="radio01"><span></span><p>세</p></label>
								</div>
								
							</div>
						</div>
						<div class="mm-survey-page" data-page="2">
							<div class="mm-survery-content">
								<div class="mm-survey-question">
									<p>성별을 입력해주세요</p>
								</div>
								<div class="mm-survey-item">
									<input  type="radio" name="gender" id="gender1" value="남" required>
									
									<label for="gender1"><span></span><p>남성</p></label>
								</div>
								<div class="mm-survey-item">
									<input  type="radio" name="gender" id="gender2" value="여" required>
									<label for="gender2"><span></span><p>여성</p></label>
								</div>
								
							</div>
						</div>
						<div class="mm-survey-page" data-page="3">
							<div class="mm-survery-content">
								<div class="mm-survey-question">
									<p>신장을 입력해주세요</p>
								</div>
								<div class="mm-survey-item">
									<input type="number" id="height" data-item="3" name="height" value="height" required/>
									<label for="height"><span></span><p>cm</p></label>
								</div>
								
							</div>
						</div>
						<div class="mm-survey-page" data-page="4">
							<div class="mm-survery-content">
								<div class="mm-survey-question">
									<p>체중을 입력해주세요</p>
								</div>
								<div class="mm-survey-item">
									<input type="number" id="weight" data-item="4" name="weight" value="weight" required/>
									<label for="weight"><span></span><p>kg</p></label>
								</div>
								
							</div>
						</div>
						<div class="mm-survey-page" data-page="5">
							<div class="mm-survery-content">
								<div class="mm-survey-question">
									<p>평소에 운동을 어느정도 하고 <br> 있으신가요? </p>
								</div>
								<div class="mm-survey-item">
									<input type="radio" id="exerciseEXP01" data-item="5" name="exerciseEXP" value="1" />
									<label for="exerciseEXP01"><span></span><p>활동이 적거나 운동을 안하는 경우</p></label>
								</div>
								<div class="mm-survey-item">
									<input type="radio" id="exerciseEXP02" data-item="5" name="exerciseEXP" value="2" />
									<label for="exerciseEXP02"><span></span><p>가벼운 활동 및 운동을 하는 경우(1~3일/1주)</p></label>
								</div>
								<div class="mm-survey-item">
									<input type="radio" id="exerciseEXP03" data-item="5" name="exerciseEXP" value="3" />
									<label for="exerciseEXP03"><span></span><p>보통의 활동 및 운동을 하는 경우(3~5일/1주)</p></label>
								</div>
								<div class="mm-survey-item">
									<input type="radio" id="exerciseEXP04" data-item="5" name="exerciseEXP" value="4" />
									<label for="exerciseEXP04"><span></span><p>적극적인 활동 및 운동을 하는 경우(6~7일/1주)</p></label>
								</div>
								<div class="mm-survey-item">
									<input type="radio" id="exerciseEXP05" data-item="5" name="exerciseEXP" value="5" />
									<label for="exerciseEXP05"><span></span><p>매우 적극적인 활동 및 운동, 운동선수</p></label>
								</div>
							</div>
						</div>
						<div class="mm-survey-page" data-page="6">
							<div class="mm-survery-content">
								<div class="mm-survey-question">
									<p>운동목표를 정해주세요</p>
								</div>
								<div class="mm-survey-item">
									<input type="radio" id="goals01" data-item="6" name="goals" value="1" />
									<label for="goals01"><span></span><p>체중 감소</p></label>
								</div>
								<div class="mm-survey-item">
									<input type="radio" id="goals02" data-item="6" name="goals" value="2" />
									<label for="goals02"><span></span><p>벌크업</p></label>
								</div>
								<div class="mm-survey-item">
									<input type="radio" id="goals03" data-item="6" name="goals" value="3" />
									<label for="goals03"><span></span><p>체력 향상</p></label>
								</div>
								<div class="mm-survey-item">
									<input type="radio" id="goals04" data-item="6" name="goals" value="4" />
									<label for="goals04"><span></span><p>유연성 향상</p></label>
								</div>
								
							</div>
						</div>
						

					</div>

				   <div class="mm-survey-controller">
                <div class="mm-prev-btn">
                  <button>이전</button>
                </div>
                <div class="mm-next-btn">
                  <button disabled="true">다음</button>
                </div>
                <div class="mm-finish-btn">
                  <button id="submit" class="button is-primary" type="submit">입력 완료</button>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </form>
</body>
</html>