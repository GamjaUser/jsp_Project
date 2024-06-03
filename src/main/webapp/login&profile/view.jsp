<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>view</title>
<link rel="stylesheet" type="text/css" href="../css/view.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="../js/page.js"></script>
</head>
<body>
	<div id="modal_menubar">
      <div id="modalContent_menubar"></div>
    </div>
    
    <div class="table-container" style="--data-limit: 9">
		 <table border="1" class="styled-table">
    <colgroup>
        <col width="15%"/> <col width="35%"/>
        <col width="15%"/> <col width="*"/>
    </colgroup>

    <!-- �Խñ� ���� -->
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

    <!-- ÷������ -->
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

    <!-- �ϴ� �޴�(��ư) -->
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