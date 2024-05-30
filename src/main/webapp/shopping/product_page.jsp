<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>상품 상세 페이지</title>
    <link href="https://cdn.jsdelivr.net/npm/reset-css@5.0.2/reset.min.css" rel="stylesheet">
    <link rel="stylesheet" href="../css/product_page.css">
     <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script> 
  	<script src="../js/page.js"></script>
</head>
<body>
		

     <div id="modal_menubar"><!-- 모달출력코드 -->
      <div id="modalContent_menubar">
        <!-- 모달출력 -->
      </div>
    </div>

    <div id="main_content">
      <!-- 본 내용 코드 작성 -->
      <div class="home"><br />
		<span class="shape score">Healthy</span><span class="shape">life</span>
      </div>
    <div class="vip-content">
        <div class="item-topinfowrap">
            <!-- 왼쪽: 상품 이미지 -->
            <div class="thumb-gallery uxecarousel alone">
                <img src="//gdimg.gmarket.co.kr/2006325732/still/600?ver=1655887922" width="600" height="600" alt="상품이미지">
            </div>
            
            
        </div>
        <!-- 오른쪽: 상품 정보 -->
        <div class="item-topinfo item-topinfo--additional box__item-info--vip">
          <div class="item-topinfo_headline box__info-color-unify">
              <div id="itemcase_basic">
                  <div class="box__item-title">
                  <!-- 상품명 -->
                      <h1 class="itemtit">602호 짐수레 접이식 핸드카 장바구니 캐리어 핸들카</h1>
                  </div>
                  <!-- 가격 정보 -->
                  <div class="price">
                      <span class="box__icon"></span>
                      <span class="price_innerwrap">
                          <strong class="price_real">33,890<span class="unit">원</span></strong>
                      </span>
                  </div>
              </div>
          </div>
          <div class="section_seleted_list" id="coreSelectedList" style="display:none;">
              <ul class="selected-list list__color-unify"></ul>
          </div>
          <!-- 하단: 장바구니와 구매 버튼 -->
          <div class="form_bottom">
              <div class="section_bottombtns section_bottombtns-layout">
                  <button class="btn_primary btn_white btn_mycart" id="coreAddCartBtn"><em>장바구니</em></button>
                  <button class="btn_primary btn_blue" id="coreInsOrderBtn"><em>구매하기</em></button>
              </div>
          </div><br>
    </div>
    </div>
      </div>
 
</body>
</html>
