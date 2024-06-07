$(function() {
    $('.add-to-cart').on('click', function () {
	f(this);
    });
});

function f(addCartBtn) {
        let cart = $('.shopping-cart-page'); // 쇼핑 카트 아이콘의 선택자
        let imgtodrag = $(addCartBtn).closest('.item').find("img").eq(0); // 현재 아이템의 이미지를 찾습니다.
        let productId = $(addCartBtn).closest('.item').data('product-id'); // 제품 ID를 가져옵니다.
		
		console.log("cart : ", cart)
        console.log("img : ", imgtodrag);
        console.log($(addCartBtn).closest('.item'));
        console.log("productId: " + productId);
        
      insertItem(productId).then(check =>{
      if(check){
        if (cart.length > 0 && imgtodrag.length > 0) {
            let cartOffset = cart.offset(); // 카트 아이콘의 위치를 계산합니다.
            
            let imgtodragOffset = imgtodrag.offset(); // 이미지의 위치를 계산합니다.

            let imgclone = imgtodrag.clone()
                .css({
                    'opacity': '0.5',
                    'position': 'absolute',
                    'height': '150px',
                    'width': '150px',
                    'z-index': '100',
                    'top': imgtodragOffset.top,
                    'left': imgtodragOffset.left
                })
                .appendTo($('body'))
                .animate({
                    'top': cartOffset.top + 10,
                    'left': cartOffset.left + 10,
                    'width': 75,
                    'height': 75
                }, 700, 'swing', function () { // 기본 제공 easing 함수 사용
                    $(this).detach();
                });

            imgclone.animate({
                'width': 0,
                'height': 0
            }, function () {
              //  $(addCartBtn).detach();
            });
        } else {
            alert('Failed to locate cart icon or image element');
        }
        
        }
        }); 
}

const insertItem = async (productId) => {
    console.log("inserItem")
    let check = false;

	console.log(productId )
    try {
        await $.ajax({
            url: '/shopping/Cartupdate.do', // Controller의 URL로 변경하세요.
            type: 'POST', // 또는 'GET', 서버에서 요구하는 방식에 맞춰서 설정하세요.
            data: {
                productId: productId // 서버로 전송할 데이터
            },
            success: function(response) {
                if (response.success) {
					console.log("연결 성공")
                    check = true;
                } else {
                    alert('Failed to add product to cart');
                    console.error('Response Error:', response); // 응답 오류 출력
                }
            },
            error: function(xhr, status, error) {
                console.error('Request Error:', error); // 요청 실패 시 오류 메시지 출력
                console.error('Status:', status); // 상태 코드 출력
                console.error('Response:', xhr.responseText); // 서버 응답 출력
                alert('An error occurred while adding the product to the cart');
            }
        });
    } catch(error) {
        console.error('There was an error!', error);
    }
    
    return check;
}

$(document).ready(function() {
    $('.search').on('click', function() {
        let searchTerm = $('#search').val().trim(); // 검색어를 가져옵니다.

        if (searchTerm === "") {
            alert("검색어를 입력하세요.");
            return;
        }

        // URL에 검색어를 쿼리 파라미터로 추가합니다.
        let url = '/shopping/searchProductName.do?name=' + encodeURIComponent(searchTerm);

        $.ajax({
            url: url,
            type: 'GET',
            success: function(response) {
                displayResults(response); // 성공적으로 응답을 받으면 결과를 표시합니다.
                console.log(response)
            },
            error: function(xhr, status, error) {
                console.error('Error:', error); // 오류 메시지 출력
                alert('검색 중 오류가 발생했습니다. 나중에 다시 시도하세요.');
            }
        });
    });

    function displayResults(results) {
        let resultsContainer = $('.row');
        
        console.log("1 : ", resultsContainer)
        
        resultsContainer.empty(); // 이전 결과를 지웁니다.
        if (results.length === 0) {
            resultsContainer.append('<h2 class="text-center">없음</h2>');
            return;
        }

        let resultItems = results.map(function(result) {
            return '<div class="col-md-4 mb-4">' +
                   '<div class="card h-100 item" data-product-id="' + result.productId + '">' +
                   '<a href="/shpping/ProductPage.do?productid="' + result.productId + '"><img class="card-img-top" src="/images/'+  result.productId + '" alt="item"></a>' +
                   '<div class="card-body">' +
                   '<h5 class="card-title">' + result.name + '</h5>' +
                   '<p class="card-text">가격: <em>' + result.price + '</em></p>' +
                   '<button class="btn btn-success add-to-cart" type="button" onclick ="f(this)">Add to Cart</button>' +
                   '</div></div></div>';
        });

        resultsContainer.append(resultItems.join(''));

    }
});
