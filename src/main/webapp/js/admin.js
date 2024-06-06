// 삭제 확인을 위한 JavaScript
function deletePost(postId) {
    if (confirm('Are you sure you want to delete this post?')) {
        window.location.href = `/deletePost?postId=${postId}`;
    }
}

function deleteComment(commentId) {
    if (confirm('Are you sure you want to delete this comment?')) {
        window.location.href = `/deleteComment?commentId=${commentId}`;
    }
}

// 문서가 준비되면 실행
$(document).ready(function() {
    // 테이블의 행을 클릭하면 발생하는 이벤트 처리
    $('.table tbody tr').on('click', function() {
        alert('Row clicked!');
    });
});
