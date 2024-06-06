<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>view</title>
<link rel="stylesheet" type="text/css" href="../css/view.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

</head>
<body>
	<div id="modal_menubar">
      <div id="modalContent_menubar"><%@ include file="../login&profile/page.jsp" %></div>
    </div>
    
    <div class="table-container" style="--data-limit: 9">
		 <table border="1" class="styled-table">
    <colgroup>
        <col width="15%"/> <col width="35%"/>
        <col width="15%"/> <col width="*"/>
    </colgroup>

    <!-- 게시글 정보 -->
    <tr>
        <td>num</td> <td></td>
        <td>writer</td> <td></td>
    </tr>
    <tr>
        <td>date</td> <td></td>
        <td>views</td> <td></td>
    </tr>
    <tr>
        <td>title</td>
        <td colspan="3"></td>
    </tr>
    <tr>
        <td>content</td>
        <td colspan="3" height="100"></td>
    </tr>

    <!-- 첨부파일 -->
    <tr>
        <td>file</td>
        <td>
            <c:if test="">
            
            <a href="">
                [download]
            </a>
            </c:if>
        </td>
         <td>downloads</td>
        <td></td>
    </tr>

    <!-- 하단 메뉴(버튼) -->
    <tr>
        <td colspan="4" align="center">
            <button type="button" onclick="">
                edit
            </button>
            <button type="button" onclick="">
                delete
            </button>
            <button type="button" onclick="">
                list
            </button>
        </td>
    </tr>
</table>
	</div>
</body>
</html>