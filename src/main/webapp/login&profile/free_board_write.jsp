<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>free_board_write</title>
<script type="text/javascript">
    function validateForm(form) {  // 필수 항목 입력 확인
        if (form.name.value == "") {
            alert("작성자를 입력하세요.");
            form.name.focus();
            return false;
        }
        if (form.title.value == "") {
            alert("제목을 입력하세요.");
            form.title.focus();
            return false;
        }
        if (form.content.value == "") {
            alert("내용을 입력하세요.");
            form.content.focus();
            return false;
        }
    }
</script>
<link rel="stylesheet" type="text/css" href="../css/free_board.css">
<link rel="stylesheet" type="text/css" href="../css/free_board_write.css">
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
		<form name="writeFrm" method="post" enctype="multipart/form-data"
      action="../mvcboard/write.do" onsubmit="return validateForm(this);">
<table border="1" width="90%">
    <tr>
        <td>작성자</td>
        <td>
            <input type="text" name="name" style="width:150px; height:30px;" />
        </td>
    </tr>
    <tr>
        <td>제목</td>
        <td>
            <input type="text" name="title" style="width:90%; height:30px;" />
        </td>
    </tr>
    <tr>
        <td>내용</td>
        <td>
            <textarea name="content" style="width:90%;height:130px;"></textarea>
        </td>
    </tr>
    <tr>
        <td>첨부 파일</td>
        <td>
            <input type="file" name="ofile" />
        </td>
    </tr>
    <tr>
        <td colspan="2" align="center">
            <button type="submit" class="custom-btn btn-3"><span>작성 완료</span></button>
            <button type="reset" class="custom-btn btn-3"><span>RESET</span></button>
            <button type="button" class="custom-btn btn-3" onclick="location.href='../mvcboard/list.do'"><span>목록 바로가기</span></button>
        </td>
    </tr>
</table>    
</form>
	</div>
</body>
</html>