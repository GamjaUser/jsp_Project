/*
	Add to cart fly effect with jQuery. - May 05, 2013
	(c) 2013 @ElmahdiMahmoud - fikra-masri.by
	license: https://www.opensource.org/licenses/mit-license.php
*/   
$(function(){
	$('.add-to-cart').on('click', function () {
        var cart = $('.shopping-cart');
        var imgtodrag = $(this).parent('.item').find("img").eq(0);
        let productId = $(this).parent().attr('data-product-id');
        
        console.log("productId" , productId);
        
        
        
      console.log(1);
      insertItem(productId).then(check =>{
      if(check){
	
            if (imgtodrag) {
                var imgclone = imgtodrag.clone()
                    .offset({
                    top: imgtodrag.offset().top,
                    left: imgtodrag.offset().left
                })
                  .css({
                  'opacity': '0.5',
                      'position': 'absolute',
                      'height': '150px',
                      'width': '150px',
                      'z-index': '100'
                })
                  .appendTo($('body'))
                  
                  .animate({
                  'top': cart.offset().top + 10,
                      'left': cart.offset().left + 10,
                      'width': 75,
                      'height': 75
                }, 700);

                imgclone.animate({
                    'width': 0,
                        'height': 0
                }, function () {
                    $(this).detach()
                });
              }
        }
      });
	});
});
	

const insertItem = async(productId) =>{
	let check = false;
	
	try{
		await  $.ajax({
            url: '/shopping/Cartupdate.do', // Controller의 URL로 변경하세요.
            type: 'POST', // 또는 'GET', 서버에서 요구하는 방식에 맞춰서 설정하세요.
            data: {
                productId: productId // 서버로 전송할 데이터
            },
          	success: function(response) {
		        if (response.success) {
		          check = true;
		        } else {
		          alert('Failed to remove product');
		        }
            },
            error: function(xhr, status, error) {
                // 요청 실패 시 실행될 코드
                console.error(error); // 오류 메시지 출력
            }
        });
		
	}catch(error){
    	console.error('There was an error!', error);
	}
	
	return check;
}