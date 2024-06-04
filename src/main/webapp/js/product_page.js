$(function() {
    $('#coreAddCartBtn').on('click', function() {
        var cart = $('.shopping-cart-page'); // 쇼핑 카트 아이콘의 선택자
        var imgtodrag = $('.thumb-gallery img'); // 현재 아이템의 이미지를 찾습니다.
        let productId = imgtodrag.attr('data-product-id'); // 제품 ID를 가져옵니다.

        // 이미지 URL 가져오기
        let imgSrc = imgtodrag.attr('src');

        console.log("productId: ", productId);
        console.log("img: ", imgSrc);

        // 이미지 URL과 productId를 로컬 스토리지에 저장
        localStorage.setItem('productImage', imgSrc);
        localStorage.setItem('productId', productId);

        insertItem(productId).then(check => {
            if (check) {
                if (cart.length > 0 && imgtodrag.length > 0) {
                    var cartOffset = cart.offset(); // 카트 아이콘의 위치를 계산합니다.
                    var imgtodragOffset = imgtodrag.offset(); // 이미지의 위치를 계산합니다.

                    var imgclone = imgtodrag.clone()
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
                        }, 700, 'swing', function() { // 기본 제공 easing 함수 사용
                            $(this).detach();
                        });

                    imgclone.animate({
                        'width': 0,
                        'height': 0
                    }, function() {
                        $(this).detach();
                    });
                } else {
                    alert('Failed to locate cart icon or image element');
                }
            }
        });
    });

    const insertItem = async (productId) => {
        let check = false;

        try {
            await $.ajax({
                url: '/shopping/Cartupdate.do', // Controller의 URL로 변경하세요.
                type: 'POST', // 또는 'GET', 서버에서 요구하는 방식에 맞춰서 설정하세요.
                data: {
                    productId: productId // 서버로 전송할 데이터
                },
                success: function(response) {
                    if (response.success) {
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
        } catch (error) {
            console.error('There was an error!', error);
        }

        return check;
    }
});