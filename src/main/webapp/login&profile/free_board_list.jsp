<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>free_board_list</title>
<link rel="stylesheet" type="text/css" href="../css/free_board.css">
<link rel="stylesheet" type="text/css" href="../css/free_board_list.css">
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
        <!-- 검색 폼 -->
        <form method="get">  
        <table border="1" width="90%">
        <tr>
            <td align="center">
                <select name="searchField">
                    <option value="title">제목</option>
                    <option value="content">내용</option>
                </select>
                <input type="text" name="searchWord" />
                <input type="submit" value="검색하기" />
            </td>
        </tr>
        </table>
        </form>

        <!-- 목록 테이블 -->
        <table border="1" width="90%" class="context_list">
            <tr>
                <th width="10%">번호</th>
                <th width="*">제목</th>
                <th width="15%">작성자</th>
                <th width="10%">조회수</th>
                <th width="15%">작성일</th>
                <th width="8%">첨부</th>
            </tr>
            <c:choose>
                <c:when test="${empty boardLists}">
                    <tr>
                        <td colspan="6" align="center">
                            등록된 게시물이 없습니다^^*
                        </td>
                    </tr>
                </c:when>
                <c:otherwise>
                    <c:forEach var="row" items="${boardLists}" varStatus="loop"> 
                        <tr align="center">
                            <td>${map.totalCount - (map.pageSize * (map.pageNum - 1)) - loop.index}</td>
                            <td>
                                <a href="../mvcboard/view.do?idx=${row.idx}">${row.title}</a>
                            </td>
                            <td>${row.name}</td>
                            <td>${row.visitcount}</td>
                            <td>${row.postdate}</td>
                            <td>${row.ofile}</td>
                        </tr>    
                    </c:forEach>
                </c:otherwise>
            </c:choose>
        </table>

        <!-- 하단 메뉴(바로가기, 글쓰기) -->
        <table border="1" width="90%" class="paging_bar">
            <tr align="center">
                <td>
                    <c:out value="${pagingStr}" escapeXml="false" />
                </td>
                <td width="100">
                    <button type="button" class="custom-btn btn-12" onclick="location.href='../mvcboard/write.do'"><span>Click!</span><span>Write</span></button>
                </td>
            </tr>
        </table>
    </div>
</body>
</html>
