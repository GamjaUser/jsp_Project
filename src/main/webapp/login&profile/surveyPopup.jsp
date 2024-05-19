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
</head>
<body>
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
					<div class="mm-survey-results-controller">
						<div class="mm-back-btn">
							<button>Back</button>
						</div>
					</div>
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
									<input type="number" id="height" data-item="3" name="height" value="height" min="120" max="300"/>
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
									<input type="number" id="weight" data-item="4" name="weight" value="weight" min="120" max="300"/>
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
									<input type="radio" id="healthyEXP01" data-item="5" name="healthyEXP" value="1" />
									<label for="healthyEXP01"><span></span><p>활동이 적거나 운동을 안하는 경우</p></label>
								</div>
									<div class="mm-survey-item">
									<input type="radio" id="healthyEXP02" data-item="5" name="healthyEXP" value="2" />
									<label for="healthyEXP02"><span></span><p>가벼운 활동 및 운동을 하는 경우(1~3일/1주)</p></label>
								</div>
									<div class="mm-survey-item">
									<input type="radio" id="healthyEXP03" data-item="5" name="healthyEXP" value="3" />
									<label for="healthyEXP03"><span></span><p>보통의 활동 및 운동을 하는 경우(3~5일/1주)</p></label>
								</div>
									<div class="mm-survey-item">
									<input type="radio" id="healthyEXP04" data-item="5" name="healthyEXP" value="4" />
									<label for="healthyEXP04"><span></span><p>적극적인 활동 및 운동을 하는 경우(6~7일/1주)</p></label>
								</div>
									<div class="mm-survey-item">
									<input type="radio" id="healthyEXP05" data-item="5" name="healthyEXP" value="5" />
									<label for="healthyEXP05"><span></span><p>매우 적극적인 활동 및 운동, 운동선수</p></label>
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
							<button id="submit" class="button is-primary" type="button" onclick="closeModal()">입력 완료</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
</body>
</html>