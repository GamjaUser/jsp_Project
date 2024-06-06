$(document).ready(function() {
    $('#productbtn').click(function() {;
        let form = $('#productform')[0];
        let formData = new FormData(form);
        
		console.log(form);
		console.log(formData);
        $.ajax({
            url: '/insertProduct.do', // 서버의 실제 경로로 변경해야 합니다.
            type: 'POST',
            data: formData,
          contentType: false,
          processData: false,
            success: function(response) {
				console.log("1")
                // 서버 응답에 따른 처리 (예: 성공 메시지 표시)
                $('#addProductModal').modal('hide');
                location.reload(); // 페이지 새로 고침
            },
            error: function(xhr, status, error) {
                // 에러 처리 (예: 에러 메시지 표시)
                alert('An error occurred: ' + error);
            }
        });
    });
   
});


