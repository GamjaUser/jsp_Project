<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>free_board_view</title>

<link rel="stylesheet" type="text/css" href="../css/free_board.css">
<link rel="stylesheet" type="text/css" href="../css/free_board_view.css">
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
	<div class="table-container" style="--data-limit: 9">
		<table border="1" width="90%">
    <colgroup>
        <col width="15%"/> <col width="35%"/>
        <col width="15%"/> <col width="*"/>
    </colgroup>

    <!-- 게시글 정보 -->
    <tr>
        <td>번호</td> <td>${dto.idx }</td>
        <td>작성자</td> <td>${dto.name }</td>
    </tr>
    <tr>
        <td>작성일</td> <td>${dto.postdate }</td>
        <td>조회수</td> <td>${dto.visitcount }</td>
    </tr>
    <tr>
        <td>제목</td>
        <td colspan="3">${dto.title }</td>
    </tr>
    <tr class="content_box">
        <td>내용</td>
        <td colspan="3" height="100">${dto.content }</td>
    </tr>

    <!-- 첨부파일 -->
    <tr>
        <td>첨부파일</td>
        <td>
            <c:if test="${ not empty dto.ofile }">
            ${ dto.ofile }
            <a href="../mvcboard/download.do?ofile=${ dto.ofile }&sfile=${ dto.sfile }&idx=${ dto.idx }">
                [다운로드]
            </a>
            </c:if>
        </td>
         <td>다운로드수</td>
        <td>${ dto.downcount }</td>
    </tr>

    <!-- 하단 메뉴(버튼) -->
    <tr>
        <td colspan="4" align="center">
            <button type="button" onclick="location.href='../mvcboard/edit.do?idx=${ param.idx }';">
                수정하기
            </button>
            <button type="button" onclick="location.href='../mvcboard/delete.do?idx=${ param.idx }';">
                삭제하기
            </button>
            <button type="button" onclick="location.href='../mvcboard/list.do';">
                목록 바로가기
            </button>
            <button type="button" id="commentLook_btn" onclick="openCommentPopup(${dto.idx});">
			    댓글 보기
			</button>
        </td>
    </tr>
</table>
</div>
<!-- 모달 배경 -->
<div id="modalBackground" style="display:none; position:fixed; top:0; left:0; width:100%; height:100%; background:rgba(0,0,0,0.5); z-index:1000;"></div>
<!-- 모달 창 -->
<div id="commentModal" style="display:none; position:fixed; top:50%; left:50%; transform:translate(-50%, -50%); width:80%; max-width:600px; height:650px; background:#fff; z-index:1001; overflow:auto;">
  <!-- 모달 내용은 여기에 동적으로 로드됩니다. -->
  <button id="closeModal" style="position:absolute; top:10px; right:8px; background-color:white; border:0; outline:0;">X</button>
</div>
	<script src="../js/free_board_view.js"></script>
</body>
</html>