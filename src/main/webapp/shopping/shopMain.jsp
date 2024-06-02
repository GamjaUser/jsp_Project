<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>page</title>
<link rel="stylesheet" type="text/css" href="../css/shop.css">

<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="../js/shop.js"></script>
<script src="../js/page.js"></script>
</head>

<!-- <body> -->

 <div class="container">
    <div id="modal_menubar">
      <div id="modalContent_menubar"></div>
    </div>
  
  
	<div class = "shopCloumn">
		<!-- wrapper -->
		<div class="wrapper">
		
		<div class="wiki">
			<input type="search" name="search" id="search" placeholder="search">
			<button class="search">Search</button>
		</div>
		<div class="outcome"></div>
			<!-- <h1>Bike Stock</h1> -->
	<!-- 	 	<span ><a href="cartMain.jsp"><i class="shopping-cart"> </i></a></span> -->
		
			<div class="clear"></div>
			<!-- items -->
			<div class="items">
		        <c:choose>
		          <c:when test="${empty products}">
		            <h2>없음</h2>
		          </c:when>
					<c:otherwise>
            			<c:forEach var="product" items="${products}" varStatus="loop">
							<!-- single item -->
							<div class="item" data-product-id="${product.productId}">
								<img src="http://img1.exportersindia.com/product_images/bc-small/dir_55/1620613/cannondale-jekyll-1-2011-mountain-bike-309779.jpg" alt="item" />
								<h2>${product.name}</h2>
								<p>가격: <em>${product.price}</em></p>
								<button class="add-to-cart" type="button">Add to cart</button>
							</div>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</div>
			<!--/ items -->
		</div>
		<!--/ wrapper -->
	</div>
</div>
</body>
</html>
