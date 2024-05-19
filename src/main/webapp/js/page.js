window.onload = function () {
        // 페이지가 로드될 때 모달을 열도록 합니다.
        openModal_menubar();
      };
      
      // 모달을 여는 함수
      function openModal_menubar() {
        // 다른 JSP 파일의 URL
        const popupUrl = '../login&profile/page.jsp';
      
        // AJAX 요청을 통해 다른 JSP 파일의 내용을 가져옵니다.
        $.get(popupUrl, function (response) {
          // 모달 내부에 가져온 내용을 표시합니다.
          $('#modalContent_menubar').html(response);
      
          // 모달을 표시합니다.
          $('#modal_menubar').css('display', 'block');
        });
      }
      