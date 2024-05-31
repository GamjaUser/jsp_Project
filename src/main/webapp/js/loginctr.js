$(document).ready(function() {
	    
	    //중복검사
		  var isIdValid = false; // 아이디 중복 여부 플래그
			
	    function validatePassword() {
	      var password = $('#password-signup').val();
	      var passwordCheck = $('#password-signup-check').val();

	      if (password !== passwordCheck) {
	        alert('비밀번호가 일치하지 않습니다.');
	        return false;
	      }
	      return true;
	    }
			
	    $('#checkId').on('click', function() {
	      var id = $('#sign-id').val();
				var url = '/login/idCheck.do';
	      if (id === '') {
	        alert('아이디를 입력해주세요.');
	        return;
	      }
	      $.ajax({
	        type: 'POST',
	        url: url,
	        data: { id: id },
	        success: function(response) {
	          if (response.trim() === 'available') {
	            alert('사용 가능한 아이디입니다.');
	            
	            isIdValid = true;
	          } else {
	            alert('이미 사용 중인 아이디입니다.');
	            isIdValid = false;
	          }
	        },
	        error: function(xhr, status, error) {
	        	  var errorMessage = xhr.status + ': ' + xhr.statusText;
	        	  alert('아이디 중복 검사에 실패했습니다. 오류: ' + errorMessage);
	        	}
	      });
	    });
	    
	  //로그인
	    $('#logIn').on('click', function(e) {
	        e.preventDefault();

	        var id = $('#login-id').val();
	        var password = $('#password-login').val();
	        var url = '/login/login.do'
	        if (id === '') {
	            alert('아이디를 입력해주세요.');
	            return;
	        }
	        if (password === '') {
	            alert('비밀번호를 입력해주세요.');
	            return;
	        }
	        $.ajax({
	            type: 'POST',
	            url: url,
	            data: {
	                id: id, // username이 아닌 id로 수정
	                password: password
	            },
	            success: function(response) {
	                if (response.trim() === 'success') {
	                    alert('로그인 성공! 환영합니다.');
	                    window.location.href = '/HealthyCareLife/profile.do'; // 로그인 성공 시 프로필 페이지로 이동
	                } else if (response.trim() === 'fail') {
	                    alert('로그인 실패 아이디 또는 비밀번호를 확인해주세요.');
	                } else {
	                    alert('아이디 또는 비밀번호를 정확히 입력해주세요.');
	                    // 페이지를 초기화해줘야 할 때는 아래와 같이 사용
	                    // window.location.href = 'login.jsp';
	                }
	            },
	            error: function() {
	                alert('오류발생! 다시 시도해주세요.');
	            }
	        });
	    });

	    
				    //회원가입 
				    $('#signUp').on('click', function(e) {
			  e.preventDefault();
			  
			  if (!isIdValid) {
			    alert('아이디 중복 검사를 통과해야 합니다.');
			    return;
			  }
			
			  if (!validatePassword()) {
			    return;
			  }
			
			  var id = $('#sign-id').val();
			  var password = $('#password-signup').val();
			  var age = sessionStorage.getItem('age');
			  var gender = sessionStorage.getItem('gender');
			  var height = sessionStorage.getItem('height');
			  var weight = sessionStorage.getItem('weight');
			  var exerciseEXP = sessionStorage.getItem('exerciseEXP');
			  var goals = sessionStorage.getItem('goals');
			  var level = 1;
			  var url = '/login/signup.do';
			
			  var currentDate = new Date();
	      var sdate = currentDate.toISOString();
			  sessionStorage.clear();
			  $.ajax({
			    type: 'POST',
			    url: url,
			    data: {
			      id: id,
			      password: password,
			      age: age,
			      gender: gender,
			      height: height,
			      weight: weight,
			      exerciseEXP: exerciseEXP,
			      goals: goals,
			      level: level,
			      sdate: sdate // YYYY-MM-DD 형식으로 변환된 날짜를 전달
			    },
			    success: function(response) {
			      if (response.trim() === 'success') {
			        alert('환영합니다');
			        sessionStorage.clear();
			        window.location.href = 'login.jsp';
			      } else  {
			        alert('아이디 및 비밀번호를 다시 입력해주세요');
			        sessionStorage.clear();
			        window.location.href = 'login.jsp';
			      }
			    },
			    error: function(xhr, status, error) {
			      console.error("Error: ", status, error);
			      alert('아이디 및 비밀번호, 설문조사에 정보를 정확히 기입해주세요.');
			      history.back();
			    }
			  });
			});
	  });