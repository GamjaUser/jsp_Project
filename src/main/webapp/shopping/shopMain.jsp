<%-- <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> --%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>

<!-- <!DOCTYPE html> -->
<!-- <html> -->
<!-- <head> -->
<!-- <meta charset="UTF-8"> -->
<!-- <title>page</title> -->
<!-- <link rel="stylesheet" type="text/css" href="../css/shop.css"> -->

<!-- <script src="http://code.jquery.com/jquery-3.5.1.min.js"></script> -->
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script> -->
<!-- <script src="../js/shop.js"></script> -->
<!-- <script src="../js/page.js"></script> -->
<!-- </head> -->

<!-- <!-- <body> --> -->

<!--  <div class="container"> -->
<!--     <div id="modal_menubar"> -->
<!--       <div id="modalContent_menubar"></div> -->
<!--     </div> -->
  
  
<!-- 	<div class = "shopCloumn"> -->
<!-- 		<!-- wrapper --> -->
<!-- 		<div class="wrapper"> -->
		
<!-- 		<div class="wiki"> -->
<!-- 			<input type="search" name="search" id="search" placeholder="search"> -->
<!-- 			<button class="search">Search</button> -->
<!-- 		</div> -->
<!-- 		<div class="outcome"></div> -->
<!-- 			<!-- <h1>Bike Stock</h1> -->
<!-- 	<!-- 	 	<span ><a href="cartMain.jsp"><i class="shopping-cart"> </i></a></span> --> -->
		
<!-- 			<div class="clear"></div> -->
<!-- 			<!-- items -->
<!-- 			<div class="items"> -->
<%-- 		        <c:choose> --%>
<%-- 		          <c:when test="${empty products}"> --%>
<!-- 		            <h2>없음</h2> -->
<%-- 		          </c:when> --%>
<%-- 					<c:otherwise> --%>
<%--             			<c:forEach var="product" items="${products}" varStatus="loop"> --%>
<!-- 							single item -->
<%-- 							<div class="item" data-product-id="${product.productId}"> --%>
<!-- 								<img src="http://img1.exportersindia.com/product_images/bc-small/dir_55/1620613/cannondale-jekyll-1-2011-mountain-bike-309779.jpg" alt="item" /> -->
<%-- 								<h2>${product.name}</h2> --%>
<%-- 								<p>가격: <em>${product.price}</em></p> --%>
<!-- 								<button class="add-to-cart" type="button">Add to cart</button> -->
<!-- 							</div> -->
<%-- 						</c:forEach> --%>
<%-- 					</c:otherwise> --%>
<%-- 				</c:choose> --%>
<!-- 			</div> -->
<!-- 			<!--/ items -->
<!-- 		</div> -->
<!-- 		<!--/ wrapper --> 
<!-- 	</div> -->
<!-- </div> -->
<!-- </body> -->
<!-- </html> -->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>page</title>
<!-- 부트스트랩 CSS 포함 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="../css/shop.css">

<!-- jQuery와 부트스트랩 JS 포함 -->
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script> <!-- jQuery UI 추가 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="../js/shop.js"></script>
<script src="../js/page.js"></script>
</head>

<body>
<div class="container mt-5">
    <div id="modal_menubar" class="fixed-top">
        <div id="modalContent_menubar"></div>
    </div>
  
    <div class="shopCloumn">
        <div class="wrapper">
            <div class="wiki mb-3">
                <div class="input-group">
                    <input type="search" name="search" id="search" class="form-control" placeholder="Search">
                    <div class="input-group-append">
                        <button class="btn btn-primary search" type="button">Search</button>
                    </div>
                </div>
            </div>
            <div class="outcome"></div>
            
            <div class="row">
                <c:choose>
                    <c:when test="${empty products}">
                        <h2 class="text-center">없음</h2>
                    </c:when>
                    <c:otherwise>
                        <c:forEach var="product" items="${products}" varStatus="loop">
                            <div class="col-md-4 mb-4">
                                <div class="card h-100 item" data-product-id="${product.productId}">
                                    <img class="card-img-top" src="http://img1.exportersindia.com/product_images/bc-small/dir_55/1620613/cannondale-jekyll-1-2011-mountain-bike-309779.jpg" alt="item">
                                    <div class="card-body">
                                        <h5 class="card-title">${product.name}</h5>
                                        <p class="card-text">가격: <em>${product.price}</em></p>
                                        <button class="btn btn-success add-to-cart" type="button">Add to Cart</button>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </div>
</div>
</body>
</html>
