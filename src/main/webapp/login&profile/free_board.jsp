<%@ page import="java.util.List"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Map"%>
<%@ page import="model1.board.BoardDAO"%>
<%@ page import="model1.board.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%
	//DAO를 생성해 DB에 연결
	BoardDAO dao = new BoardDAO(application);
	
	// 사용자가 입력한 검색 조건을 Map에 저장
	Map<String, Object> param = new HashMap<String, Object>();
	String searchField = request.getParameter("searchField");
	String searchWord = request.getParameter("searchWord");
	if(searchField != null){
		param.put("searchField", searchField);
		param.put("searchWord", searchWord);
	}
		
	// 게시물 목록 받기
	List<BoardDTO> boardList = dao.selectList(param);
	int total = dao.selectCount(param);
	dao.close();
%> 


<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>free_board</title>
<link rel="stylesheet" type="text/css" href="../css/freeBoard_button.css">
<link rel="stylesheet" type="text/css" href="../css/free_board.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="../js/page.js"></script>
</head>
<body>
    <div id="modal_menubar">
      <div id="modalContent_menubar"></div>
    </div>
   <p class="infos">
	Free Board
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