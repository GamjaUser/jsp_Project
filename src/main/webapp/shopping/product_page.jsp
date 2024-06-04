<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>상품 상세 페이지</title>
    <link href="https://cdn.jsdelivr.net/npm/reset-css@5.0.2/reset.min.css" rel="stylesheet">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet"> <!-- Bootstrap CSS 추가 -->
    <link rel="stylesheet" href="../css/product_page.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script> <!-- Bootstrap JS 추가 -->
    
    <script src="../js/product_page.js"></script>
    
</head>
<body>
    <div id="modal_menubar"><!-- 모달출력코드 -->
        <div id="modalContent_menubar">
            <!-- 모달출력 --><%@ include file="../login&profile/page.jsp" %>
        </div>
    </div>
    <div class="home text-center mb-4 w-100">
        <span class="shape score">Healthy</span><span class="shape">life</span>
    </div>

    <div id="main_content" class="container mt-5 d-flex flex-column align-items-center">
        <!-- 본 내용 코드 작성 -->
        <div class="content-wrapper text-center">
            <div class="vip-content row" >
                <div class="col-md-6 text-center">
<!--                     왼쪽: 상품 이미지 -->
                    <div class="thumb-gallery">
                        <img src="//gdimg.gmarket.co.kr/2006325732/still/600?ver=1655887922" data-product-id = ${product.productId } class="img-fluid item" alt="item">
                    </div>
                </div>
                <!-- 오른쪽: 상품 정보 -->
                <div class="col-md-6 item-topinfo d-flex flex-column justify-content-between">
                    <div class="item-topinfo_headline">
                        <div id="itemcase_basic">
                            <div class="box__item-title">
                                <!-- 상품명 -->
                                <h1 class="itemtit">${product.name}</h1>
                            </div>
                        </div>
                    </div>
                    <div class="section_seleted_list" id="coreSelectedList" style="display:none;">
                        <ul class="selected-list"></ul>
                    </div>
                    <!-- 상품 설명 추가 -->
                    <div class="product-description mt-4">
                        <h2>상품 설명</h2>
                        <p>${product.comment}</p>
                    </div>
                    <!-- 가격 정보 -->
                    <div class="price mt-4 text-right">
                        <span class="box__icon"></span>
                        <span class="price_innerwrap">
                            <strong class="price_real">${product.price }<span class="unit">원</span></strong>
                        </span>
                    </div>
                    <!-- 하단: 장바구니와 구매 버튼 -->
                    <div class="form_bottom mt-4">
                        <div class="section_bottombtns d-flex justify-content-around">
                            <button class="btn btn-outline-primary btn_mycart" id="coreAddCartBtn"><em>장바구니</em></button>
                            <button class="btn btn-primary" id="coreInsOrderBtn"><em>구매하기</em></button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
