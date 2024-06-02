


/* Set values + misc */
var promoCode;
var promoPrice;
var fadeTime = 300;

/* Assign actions */
$(function() {
  $('.quantity input').change(function() {
    updateQuantity(this);
  });
});

$(function(){
  $('.remove button').click(function() {
	
    removeItem(this);    
  });
});

$(document).ready(function() {
  updateSumItems();
});

$('.promo-code-cta').click(function() {

  promoCode = $('#promo-code').val();

  if (promoCode == '10off' || promoCode == '10OFF') {
    //If promoPrice has no value, set it as 10 for the 10OFF promocode
    if (!promoPrice) {
      promoPrice = 10;
    } else if (promoCode) {
      promoPrice = promoPrice * 1;
    }
  } else if (promoCode != '') {
    alert("Invalid Promo Code");
    promoPrice = 0;
  }
  //If there is a promoPrice that has been set (it means there is a valid promoCode input) show promo
  if (promoPrice) {
    $('.summary-promo').removeClass('hide');
    $('.promo-value').text(promoPrice);
    recalculateCart(true);
  }
});

$(document).ready(function() {
	recalculateCart(true);
});

/* Recalculate cart */
function recalculateCart(onlyTotal) {
  var subtotal = 0;

  /* Sum up row totals */
  $('.subtotal').each(function() {
	if(!isNaN(parseInt($(this).text()))) subtotal += parseInt($(this).text());
    //subtotal += parseFloat($(this).children('.subtotal').text());
  });

  /* Calculate totals */
  var total = subtotal;

  //If there is a valid promoCode, and subtotal < 10 subtract from total
  /*var promoPrice = parseFloat($('.promo-value').text());
  if (promoPrice) {recalculateCart
    if (subtotal >= 1) {
      total -= promoPrice;
    } else {
      alert('Order must be more than £10 for Promo code to apply.');
      $('.summary-promo').addClass('hide');
    }
  }*/

  /*If switch for update only total, update only total display*/
  if (onlyTotal) {
    /* Update total display */
    $('.total-value').fadeOut(fadeTime, function() {
      $('#basket-total').html(total);
      $('.total-value').fadeIn(fadeTime);
    });
  } else {
    /* Update summary display. */
    $('.final-value').fadeOut(fadeTime, function() {
      $('#basket-subtotal').html(subtotal);
      $('#basket-total').html(total);
      if (total == 0) {
        $('.checkout-cta').fadeOut(fadeTime);
      } else {
        $('.checkout-cta').fadeIn(fadeTime);
      }
      $('.final-value').fadeIn(fadeTime);
    });
    
    console.log("Subtotal:", subtotal);
	console.log("Total:", total);
  }
}

/* Update quantity */
function updateQuantity(quantityInput) {
  /* Calculate line price */
  var productRow = $(quantityInput).parent().parent();
  var price = parseFloat(productRow.children('.price').text());
  var quantity = $(quantityInput).val(); // 상품 갯수
  var linePrice = price * quantity;
  var productId = productRow.data('product-id'); //상품 고유번호
  
  
  
  updateCnt(productId, quantity).then(check =>{
  console.log("ProductId ", productId)
	if(check){
	  /* Update line price display and recalc cart totals */
	  productRow.children('.subtotal').each(function() {
	    $(this).fadeOut(fadeTime, function() {
	      $(this).text(linePrice);
	      recalculateCart();
	      $(this).fadeIn(fadeTime);
	    });
	  });
	
	  productRow.find('.item-quantity').text(quantity);
	  updateSumItems();			
	}
	
	});

  

}

function updateSumItems() {
  var sumItems = 0;
  $('.quantity input').each(function() {
    sumItems += parseInt($(this).val());
  });
  $('.total-items').text(sumItems);
}



/* Remove item from cart */
//function removeItem(removeButton) {
//  /* Remove row from DOM and recalc cart total */
//  const productRow = $(removeButton).parent().parent().parent();
//  const productId = $(removeButton).parent().parent().attr('data-id');
//  // 물품 아이디
//  // controller 회원 아이디 세션에서 가져와 함
//  removeProduct(productId).then(check => {
//	if(check){
//	    productRow.slideUp(fadeTime, function() {
//	      productRow.remove();
//	      recalculateCart();
//	      updateSumItems();
//	    });	
//	}
//  });
//}
//
//const removeProduct = async (productId) => {
//	let check = false;
//  console.log('productid: ' + productId);
//    await axios.post('/removeProduct.do', { productId })
//        .then(response => {
//            if (response.data.success) {
//				check = true;
//            } else {
//                alert('Failed to remove product');
//            }
//        })
//        .catch(error => {
//            console.error('There was an error!', error);
//        });
//        
//    return check
//}


function removeItem(removeButton) {
  /* Remove row from DOM and recalc cart total */
  const productRow = $(removeButton).parent().parent().parent();
  const productId = $(removeButton).parent().parent().attr('data-product-id');
  // 물품 아이디
  // controller 회원 아이디 세션에서 가져와 함
  removeProduct(productId).then(check => {
    if (check) {
      productRow.slideUp(fadeTime, function() {
        productRow.remove();
        recalculateCart();
        updateSumItems();
      }); 
    }
  });
}

const removeProduct = async (productId) => {
  let check = false;
  console.log('productid: ' + productId);
  
  try {
    await $.ajax({
      url: '/removeProduct.do',
      type: 'POST',
      data: { productId: productId }, // 데이터는 폼 데이터 형식으로 전송
      success: function(response) {
        if (response.success) {
          check = true;
        } else {
          alert('Failed to remove product');
        }
      },
      error: function(xhr, status, error) {
        console.error('There was an error!', error);
      }
    });
  } catch (error) {
    console.error('There was an error!', error);
  }

  return check;
}

const updateCnt = async(productId,quantity) =>{
	let check = false;
	
	console.log("productCnt : ", quantity)
	
	try{
		await   $.ajax({
		    url: '/shopping/Cartupdate.do', // Controller의 경로
		    type: 'POST',
		    data: {
		      productId: productId, // 제품 ID
		      cnt: quantity// 업데이트된 수량
		    },
		    success: function(response) {
		      // 성공적으로 처리됐을 때의 로직
		    	if (response.success) {
			          check = true;
		        } else {
		          alert('Failed to update product');
		        }
		    },
		    error: function(xhr, status, error) {
		      // 오류 처리
		      console.error('수량 업데이트 실패:', error);
		    }
		  });	
	} catch (error) {
  	  console.error('There was an error!', error);
  	}
	
	return check;
}
