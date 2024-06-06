<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>댓글 보기</title>
<link rel="stylesheet" type="text/css" href="../css/free_board_comments.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="../js/free_board_comments.js"></script>
</head>
<body>
<%
    String boardIdx = request.getParameter("boardIdx");
%>
<h2>댓글 목록</h2>
<input type="hidden" id="boardIdx" value="<%= boardIdx %>">
<div id="commentsContainer">
    <jsp:include page="comments.jsp">
        <jsp:param name="boardIdx" value="<%= boardIdx %>"/>
    </jsp:include>
</div>


<form id="commentForm" method="post" action="../mvcboard/comments.do">
<hr>
<h3>댓글 작성</h3>
    <input type="hidden" id="commentId" value="">
    <label for="name">작성자: </label> <input id="name" type="text" value="${id}" readonly/></br>
    <label for="content">내용: </label><textarea id="content" required></textarea><br>
    <button type="submit" class="custom-btn btn-8"><span>댓글 등록</span></button>
</form>

</body>
</html>
