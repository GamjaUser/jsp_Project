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
   
   
   
   
	$(document).ready(function() {
	    // Product delete AJAX
	    $('.delete-product-btn').on('click', function() {
	        const productId = $(this).data('id');
	        
	        console.log("id : " + productId)
            $.ajax({
                url: '/deleteProduct.do',
                type: 'POST',
                data: { productId: productId },
                success: function(response) {
					console.log(response.success)
                    if (response.trim() === "success") {
                        alert('Product deleted successfully.');
                        location.reload(); // or you can remove the row from the table
                    } else {
                        alert('Failed to delete product.');
                    }
                },
                error: function() {
                    alert('Error deleting product.');
                }
            });
	        
	    });
	
	    // Similar AJAX handlers can be created for boards and comments
	});

   
   
});


