<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta http-equiv="x-ua-compatible" content="ie=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  
  <link rel="stylesheet" type="text/css" href="../css/cart.css">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
  
  
  
  
  <title>Basket</title>
  
 
  <style>
    .orderTable {
        border-collapse: collapse;
        border: 1px solid #ddd;
        width: 100%;
    }
    .orderTable th, .orderTable td {
        border: 1px solid #ddd;
        padding: 8px;
        text-align: left;
    }
    .orderTable th {
        background-color: #f2f2f2;
        width: 30%;
    }
    .orderinput {
        width: 100%;
        padding: 6px;
        box-sizing: border-box;
    }
  </style>
</head>

<body>

  <div class="container">
    <div id="modal_menubar">
      <div id="modalContent_menubar"></div>
    </div>

    <main class="m">
      <div class="basket">
        <div class="basket-labels">
          <ul>
            <li class="item item-heading">Item</li>
            <li class="price">Price</li>
            <li class="quantity">Quantity</li>
            <li class="subtotal">Subtotal</li>
          </ul>
        </div>
        <c:choose>
          <c:when test="${empty products}">
            <h2>없음</h2>
          </c:when>
          <c:otherwise>
            <c:forEach var="product" items="${products}" varStatus="loop">
              <div class="basket-product">
                <div class="product" data-id="${product.productId}">
                  <div class="item">
                    <div class="product-image">
                      <img src="http://img1.exportersindia.com/product_images/bc-small/dir_55/1620613/cannondale-jekyll-1-2011-mountain-bike-309779.jpg" alt="Placeholder Image 2" class="product-frame">
                    </div>
                    <div class="product-details">
                      <h1 style="margin-bottom: 10px"><strong><span class="item-quantity">${product.cnt}</span>X</strong> ${product.name}</h1>
                      <p><strong>${product.comment}</strong></p>
                    </div>
                  </div>
                  <div class="price">${product.price}</div>
                  <div class="quantity">
                    <input type="number" value="${product.cnt}" min="1" class="quantity-field">
                  </div>
                  <div class="subtotal">${product.priceSum}</div>
                  <div class="remove">
                    <button>Remove</button>
                  </div>
                </div>
              </div>
            </c:forEach>
          </c:otherwise>
        </c:choose>
      </div>
      <aside>
        <div class="summary">
          <div class="summary-total-items"><span class="total-items"></span> Items in your Bag</div>
          <div class="summary-total">
            <div class="total-title">Total</div>
            <div class="total-value final-value" id="basket-total"></div>
          </div>
          <div class="summary-checkout">
<!--             <button class="checkout-cta">Go to Secure Checkout</button> -->
				<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
			    	Pay
				</button>
          </div>
        </div>
      </aside>
    </main>
  </div>

<!--   <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal"> -->
<!--     Launch demo modal -->
<!--   </button> -->

  <!-- Modal -->
  <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel">결제</h5>
          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>
        <div class="modal-body">
        <form action="" method="post">
        
        <c:set var="order" scope="request">
          <table class="orderTable">
            <tr>
              <th>회원</th>
              <td>user01</td>
            </tr>
            <tr>
              <th>주문일</th>
              <td>2024-05-29</td>
            </tr>
            <tr>
              <th>상품 이름</th>
              <td>John Doe</td>
            </tr>
            <tr>
              <th>카드</th>
              <td>
                <select class="orderinput">
                  <option value="KB">KB국민</option>
                  <option value="SH">신한</option>
                  <option value="BC">부산</option>
                  <option value="VISA">VISA</option>
                </select>
              </td>
            </tr>
            <tr>
              <th>우편번호</th>
              <td><input type="text" class="orderinput"></td>
            </tr>
            <tr>
              <th>주소</th>
              <td><input type="text" class="orderinput"></td>
            </tr>
            <tr>
              <th>상세주소</th>
              <td><input type="text" class="orderinput"></td>
            </tr>
            <tr>
              <th>전화번호</th>
              <td><input type="text" class="orderinput"></td>
            </tr>
            <tr>
              <th>요청사항</th>
              <td><input type="text" class="orderinput"></td>
            </tr>
            <tr>
              <th>상품 갯수</th>
              <td>3</td>
            </tr>
            <tr>
              <th>가격</th>
              <td>1000000</td>
            </tr>
          </table>
          </c:set>
          
          </form>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-primary">결제하기</button>
        </div>
      </div>
    </div>
  </div>
  
  
 <script src="http://code.jquery.com/jquery-3.5.1.min.js"></script> <!-- jQuery  -->
  
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
 <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
  
 <script src="../js/cart.js"></script>
 <script src="../js/page.js"></script>
  
</body>

</html>
