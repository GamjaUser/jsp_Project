jQuery(document).ready(function() {
	// 처음에 이전 버튼을 숨김
	jQuery('.mm-prev-btn').hide();
	
	var x;        // 현재 슬라이드 번호를 저장하는 변수
	var count;    // 슬라이드의 총 개수를 저장하는 변수
	var current;  // 현재 슬라이드 번호를 저장하는 변수
	var percent;  // 진행률을 저장하는 변수
	var z = [];   // 추가 데이터 저장을 위한 배열
	
	// 설문 초기화 및 필요한 설정
	init();
	getCurrentSlide();   // 현재 슬라이드를 가져옴 O
	goToNext();          // 다음 슬라이드로 이동하는 기능 설정 O
	goToPrev();          // 이전 슬라이드로 이동하는 기능 설정 O
	getCount();          // 슬라이드 총 개수를 가져옴 O
	buildStatus();       // 각 슬라이드의 상태 설정 O
	deliverStatus();     // 각 슬라이드의 상태 전달
	// submitData();        // 설문 끝에서 데이터 제출 처리 O
	// goBack();            // 결과 페이지에서 설문으로 돌아가는 기능 설정 X
	
	// 설문을 초기화하는 함수
	function init() {
			// 각 설문 페이지를 순회하면서 페이지 번호에 따라 클래스를 추가
			jQuery('.mm-survey-container .mm-survey-page').each(function() {
					var item;
					var page;
	
					item = jQuery(this);
					page = item.data('page');
	
					item.addClass('mm-page-' + page);
					// item.html(page); // 페이지 번호를 HTML에 표시하려면 이 줄을 주석 해제
			});
	}
	
	// 설문 페이지의 총 개수를 가져오는 함수
	function getCount() {
			count = jQuery('.mm-survey-page').length;
			return count;
	}
	
	// 다음 슬라이드로 이동하는 함수
	function goToNext() {
			jQuery('.mm-next-btn').on('click', function() {
					if (!isCurrentSlideComplete()) {
							alert('모든 필수 항목을 입력해 주세요.');
							return;
					}
					goToSlide(x);
					getCount();
					current = x + 1;
					var g = current / count;
					buildProgress(g);
					var y = (count + 1);
					getButtons();
					jQuery('.mm-survey-page').removeClass('active');
					jQuery('.mm-page-' + current).addClass('active');
					getCurrentSlide();
					checkStatus();
					if (jQuery('.mm-page-' + count).hasClass('active')) {
							if (jQuery('.mm-page-' + count).hasClass('pass')) {
									jQuery('.mm-finish-btn').addClass('active');
							} else {
									jQuery('.mm-page-' + count + ' .mm-survery-content .mm-survey-item').on('click', function() {
											jQuery('.mm-finish-btn').addClass('active');
									});
							}
					} else {
							jQuery('.mm-finish-btn').removeClass('active');
							if (jQuery('.mm-page-' + current).hasClass('pass')) {
									jQuery('.mm-survey-container').addClass('good');
									jQuery('.mm-survey').addClass('okay');
							} else {
									jQuery('.mm-survey-container').removeClass('good');
									jQuery('.mm-survey').removeClass('okay');
							}
					}
					buttonConfig();
			});
	}
	
	// 현재 슬라이드의 필수 입력이 완료되었는지 확인하는 함수
	function isCurrentSlideComplete() {
			var isComplete = true;
			jQuery('.mm-page-' + x + ' .required').each(function() {
					if (!jQuery(this).val()) {
							isComplete = false;
					}
			});
			return isComplete;
	}
	
	// 이전 슬라이드로 이동하는 함수
	function goToPrev() {
			jQuery('.mm-prev-btn').on('click', function() {
					goToSlide(x);
					getCount();
					current = (x - 1);
					var g = current / count;
					buildProgress(g);
					var y = count;
					getButtons();
					jQuery('.mm-survey-page').removeClass('active');
					jQuery('.mm-page-' + current).addClass('active');
					getCurrentSlide();
					checkStatus();
					jQuery('.mm-finish-btn').removeClass('active');
					if (jQuery('.mm-page-' + current).hasClass('pass')) {
							jQuery('.mm-survey-container').addClass('good');
							jQuery('.mm-survey').addClass('okay');
					} else {
							jQuery('.mm-survey-container').removeClass('good');
							jQuery('.mm-survey').removeClass('okay');
					}
					buttonConfig();
			});
	}
	
	// 진행률을 업데이트하는 함수
	function buildProgress(g) {
			if (g > 1) {
					g = g - 1;
			} else if (g === 0) {
					g = 1;
			}
			g = g * 100;
			jQuery('.mm-survey-progress-bar').css({ 'width': g + '%' });
	}
	
	// 주어진 슬라이드 번호로 이동하는 함수 (현재는 단순히 x를 반환)
	function goToSlide(x) {
			return x;
	}
	
	// 현재 슬라이드를 가져오는 함수
	function getCurrentSlide() {
			jQuery('.mm-survey-page').each(function() {
					var item;
					item = jQuery(this);
					if (jQuery(item).hasClass('active')) {
							x = item.data('page');
					}
					return x;
			});
	}
	
	// 버튼 상태를 업데이트하는 함수
	function getButtons() {
			if (current === 0) {
					current = y;
			}
			if (current === count) {
					jQuery('.mm-next-btn').hide();
			} else if (current === 1) {
					jQuery('.mm-prev-btn').hide();
			} else {
					jQuery('.mm-next-btn').show();
					jQuery('.mm-prev-btn').show();
			}
	}
	
	// 각 질문 항목을 클릭했을 때의 이벤트 설정
	jQuery('.mm-survey-q li input').each(function() {
			var item;
			item = jQuery(this);
			jQuery(item).on('click', function() {
					if (jQuery('input:checked').length > 0) {
							jQuery('label').parent().removeClass('active');
							item.closest('li').addClass('active');
					}
			});
	});
	
	// 진행률을 계산하고 업데이트
	percent = (x / count) * 100;
	jQuery('.mm-survey-progress-bar').css({ 'width': percent + '%' });
	
	// 현재 슬라이드 상태를 확인하는 함수
	function checkStatus() {
			jQuery('.mm-survery-content .mm-survey-item').on('click', function() {
					var item;
					item = jQuery(this);
					item.closest('.mm-survey-page').addClass('pass');
			});
	}
	
	// 슬라이드 상태를 설정하는 함수
	function buildStatus() {
			jQuery('.mm-survery-content .mm-survey-item').on('click', function() {
					var item;
					item = jQuery(this);
					item.addClass('bingo');
					item.closest('.mm-survey-page').addClass('pass');
					jQuery('.mm-survey-container').addClass('good');
			});
	}
	
	// 설문 상태를 전달하는 함수
	function deliverStatus() {
			jQuery('.mm-survey-item').on('click', function() {
					if (jQuery('.mm-survey-container').hasClass('good')) {
							jQuery('.mm-survey').addClass('okay');
					} else {
							jQuery('.mm-survey').removeClass('okay');
					}
					buttonConfig();
			});
	}
	
	
	
	// 버튼 설정을 업데이트하는 함수
	function buttonConfig() {
			if (jQuery('.mm-survey').hasClass('okay')) {
					jQuery('.mm-next-btn button').prop('disabled', false);
			} else {
					jQuery('.mm-next-btn button').prop('disabled', true);
			}
	}
	
// 	// 데이터를 제출하는 함수
// function submitData() {
// 	// jQuery('.mm-finish-btn').on('click', function() {
// 	// 		// collectData();
// 	// 		// // 데이터를 저장한 후 확인 페이지로 리다이렉트
// 	// 		// window.location.href = 'data.java';
// 	// });
// }
	
	// 설문 데이터를 수집하는 함수
	// function collectData() {
	// 		var map = {};
	// 		jQuery('.mm-survey-item input:checked').each(function() {
	// 				var item = jQuery(this);
	// 				var data = item.val();
	// 				var name = item.data('item');
	// 				map[name] = data;
	// 		});
	// 		// 수집된 데이터를 로컬 스토리지에 저장
	// 		localStorage.setItem('surveyData', JSON.stringify(map));
	// }
	
	// // 설문으로 돌아가는 함수
	// function goBack() {
	// 		// 구현 필요
	// }
	
	
});

