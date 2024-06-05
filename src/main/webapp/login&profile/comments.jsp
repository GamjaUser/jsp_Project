<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="boardIdx" style="display:none;"><c:out value="${boardIdx}"/></div>
<c:forEach var="comment" items="${comments}">
    <div class="comment" data-id="${comment.idx}">
        <p><span class="name">${comment.name}</span></br></br>
        <span class="content">${comment.content}</span></p>
        <button class="editComment">수정</button>
        <button class="deleteComment">삭제</button>
        
        <!-- Hidden form for editing comments -->
        <div class="editForm" style="display:none;">
            <input type="text" id="editName" value="${comment.name}">
            <input type="text" id="editContent" value="${comment.content}">
            <button class="saveEdit">저장</button>
            <button class="cancelEdit">취소</button>
        </div>
    </div>
</c:forEach>
