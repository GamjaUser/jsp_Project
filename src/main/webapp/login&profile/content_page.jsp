<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>static_content</title>
<link rel="stylesheet" type="text/css" href="../css/content_page.css">
<link rel="stylesheet" type="text/css" href="../css/freeBoard_button.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="../js/page.js"></script>
</head>
<body>
    <div id="modal_menubar">
      <div id="modalContent_menubar"></div>
    </div>
	<div class="table-container" style="--data-limit: 9">
	<select id="board_type" onchange="isShowDiv(this.value)">
	    <option value="">-- select board --</option>
	    <option value="freeBoard">free_board</option>
	    <option value="reviewBoard">review_board</option>
	    <option value="QABoard">Q&A_board</option>
	</select> 
	<div id="subcontainer1" class="sub_container" style="display:block">
		<input type="text" id="title_input" name="title" placeholder="     Enter Your Title" required>
		<textarea id="content_input1" placeholder="     Enter Your Content" required></textarea>
		<div id="file_input">
			첨부파일 : <input type="file" name="ofile"/>
		</div>
	</div>
	<div id="subcontainer2" class="sub_container" style="display:none">
		<div id="titleField">
			<select name="searchField" id="searchField" class="sub_titleField">
                <option value="productID">상품ID</option>
                <option value="productName">상품명</option>
            </select>
            <input type="text" name="searchWord" />
            <input type="submit" value="검색하기" />
            
			<div class="star-rating" class="sub_titleField">
			  <input type="radio" id="5-stars" name="rating" value="5" />
			  <label for="5-stars" class="star">&#9733;</label>
			  <input type="radio" id="4-stars" name="rating" value="4" />
			  <label for="4-stars" class="star">&#9733;</label>
			  <input type="radio" id="3-stars" name="rating" value="3" />
			  <label for="3-stars" class="star">&#9733;</label>
			  <input type="radio" id="2-stars" name="rating" value="2" />
			  <label for="2-stars" class="star">&#9733;</label>
			  <input type="radio" id="1-star" name="rating" value="1" />
			  <label for="1-star" class="star">&#9733;</label>
			</div>
		</div>
            
            <div id="contentBox">
            	<div id="product_box" class="child_contentBox"></div>
		<textarea id="content_input2" class="child_contentBox" placeholder="     Enter Your Content" required></textarea>
        </div>
            
        <div id="file_input">
			첨부파일 : <input type="file" name="ofile"/>
		</div>
	</div>
</div>
	<button class="bubbly-button" type="submit" id="enroll_button">Enroll</button>
	<button class="bubbly-button" type="submit" id="golist_button">List</button>
	<script src="../js/content_page.js"></script>
</body>
</html>