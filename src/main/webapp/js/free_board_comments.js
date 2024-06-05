$(document).ready(function() {
	console.log('document ready start');
    const boardIdx = $("#boardIdx").val();
    console.log('document 의 boardIdx : ' + boardIdx);
    loadComments(boardIdx);

    $("#commentForm").submit(function(event) {
        event.preventDefault();
        const commentId = $("#commentId").val();
        if (commentId) {
            updateComment(boardIdx, commentId);
        } else {
            addComment(boardIdx);
        }
    });

    function loadComments(boardIdx) {
        $.ajax({
            url: `comments.jsp`,
            type: 'GET',
            data: { boardIdx: boardIdx },
            success: function(data) {
                $("#commentsContainer").html(data);
                attachEventHandlers();
            }
        });
    }

    function attachEventHandlers() {
        $(".editComment").click(function() {
            const comment = $(this).closest(".comment");
            $("#commentId").val(comment.data("id"));
            $("#name").val(comment.find(".name").text());
            $("#content").val(comment.find(".content").text());
        });

        $(".deleteComment").click(function() {
            const commentId = $(this).closest(".comment").data("id");
            deleteComment(boardIdx, commentId);
        });
    }

    function addComment(boardIdx) {
    $.ajax({
        url: `../mvcboard/comments.do`,
        type: 'POST',
        contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
        data: {
            boardIdx: boardIdx,
            name: $("#name").val(),
            content: $("#content").val()
        },
        success: function(result) {
            $("#commentForm")[0].reset();
            loadComments(boardIdx);
        },
        error: function(xhr, status, error) {
            console.error("Error: " + error);
        }
    });
}

    
    $(".editComment").click(function(){
		console.log('this is editcomment');
		let idx = $(this).parent().data('id');
		let boardIdx = $("#boardIdx").val();
		
		console.log('editComment의 idx : ' + idx + ' / boardIdx : ' + boardIdx);
		
		updateComment(boardIdx, idx);
	});

    function updateComment(boardIdx, idx) {
    $.ajax({
        url: `../mvcboard/comments.do`,
        type: 'PUT',
        contentType: 'application/json; charset=UTF-8',
        data: JSON.stringify({
            idx: idx,
            name: $("#name").val(),
            content: $("#content").val()
        }),
        success: function(result) {
            $("#commentForm")[0].reset();
            $("#commentId").val('');
            loadComments(boardIdx);
        },
        error: function(xhr, status, error) {
            console.error("Error: " + error);
        }
    });
}
	$(".deleteComment").click(function(){
		console.log('this is deletecomment');
		let idx = $(this).parent().data('id');
		let boardIdx = $("#boardIdx").val();
		
		deleteComment(boardIdx, idx);
	});

    function deleteComment(boardIdx, idx) {
    $.ajax({
        url: `../mvcboard/comments.do`,
        type: 'DELETE',
        contentType: 'application/json; charset=UTF-8',
        data: JSON.stringify({ idx: idx }),
        success: function(result) {
            loadComments(boardIdx);
        },
        error: function(xhr, status, error) {
            console.error("Error: " + error);
        }
    });
}
});
