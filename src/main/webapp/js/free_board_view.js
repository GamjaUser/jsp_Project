/**
 * 
 */
//function openCommentPopup(boardIdx) {
//    const url = `../mvcboard/comments.do?boardIdx=${boardIdx}`;
//    const popupWidth = 600;
//    const popupHeight = 650;
//    const left = (window.screen.availWidth - popupWidth) / 2;
//    const top = (window.screen.availHeight - popupHeight) / 2;
//    window.open(url, '댓글 보기', `width=${popupWidth},height=${popupHeight},top=${top},left=${left}`);
//}
//

function openCommentPopup(boardIdx) {
    const url = `../mvcboard/comments.do?boardIdx=${boardIdx}`;
    $.get(url, function(data) {
        $('#commentModal').html(data);
        $('#commentModal').append('<button id="closeModal" style="position:absolute; top:10px; right:8px; background-color:white; border:0; outline:0;">X</button>');
        $('#modalBackground').show();
        $('#commentModal').show();

        // 닫기 버튼 클릭 시 모달 닫기
        $('#closeModal').click(function() {
            $('#modalBackground').hide();
            $('#commentModal').hide();
        });
    });
}

$(document).ready(function() {
    // 모달 배경 클릭 시 모달 닫기
    $('#modalBackground').click(function() {
        $('#modalBackground').hide();
        $('#commentModal').hide();
    });
});

