<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>QA_board</title>
<link rel="stylesheet" type="text/css" href="../css/freeBoard_button.css">
<link rel="stylesheet" type="text/css" href="../css/QA_board.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="../js/page.js"></script>
</head>
<body>
    <div id="modal_menubar">
      <div id="modalContent_menubar"></div>
    </div>
    <p class="infos">
	Q&A Board
	</p>

	<div class="search-box">
		<form method="get">
		    <table border="1" width="100%">
			    <tr>
			        <td align="center">
			            <select name="searchField"> 
			                <option value="title">Title</option> 
			                <option value="content">Writer</option>
			            </select>
			            <input type="text" name="searchWord" />
			            <input type="submit" value="Search" />
			        </td>
			    </tr>   
		    </table>
	    </form>
	</div>

  <div class="freeboard-column">

<%@ include file="./static_board.jsp" %>
<button class="bubbly-button">writing</button>
  </div>
  <script src="../js/free_board.js"></script>
  <script src="../js/freeBoard_button.js"></script>
</body>
</html>