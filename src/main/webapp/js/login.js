/* ====================== *
 *  Toggle Between        *
 *  Sign Up / Login       *
 * ====================== */
$(document).ready(function () {
  $('#goRight').on('click', function () {
    $('#slideBox').animate({
      'marginLeft': '0'
    });
    $('.topLayer').animate({
      'marginLeft': '100%'
    });
  });
  $('#goLeft').on('click', function () {
    if (window.innerWidth > 769) {
      $('#slideBox').animate({
        'marginLeft': '50%'
      });
    } else {
      $('#slideBox').animate({
        'marginLeft': '20%'
      });
    }
    $('.topLayer').animate({
      'marginLeft': '0'
    });
  });
});


// 모달을 여는 함수
function openModal() {
  // 다른 JSP 파일의 URL
  const popupUrl = '../login&profile/surveyPopup.jsp';

  // AJAX 요청을 통해 다른 JSP 파일의 내용을 가져옵니다.
  $.get(popupUrl, function (response) {
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

function handleCheckboxChange() {
  var checkbox = document.getElementById("confirm-terms");
  if (checkbox.checked) {
    openModal();
  } else {
    closeModal();
  }
}





window.onload = function () {
  // 페이지가 로드될 때 모달을 열도록 합니다.
  openModal_slide();
};

// 모달을 여는 함수
function openModal_slide() {
  // 다른 JSP 파일의 URL
  const popupUrl = '../login&profile/slidingpage.jsp';

  // AJAX 요청을 통해 다른 JSP 파일의 내용을 가져옵니다.
  $.get(popupUrl, function (response) {
    // 모달 내부에 가져온 내용을 표시합니다.
    $('#modalContent_slide').html(response);

    // 모달을 표시합니다.
    $('#modal_slide').css('display', 'block');
  });
}




