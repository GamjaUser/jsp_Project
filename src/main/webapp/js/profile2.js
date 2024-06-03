$(document).ready(function() {
    $("#toggleMealRecommendation").click(function() {
        var mealContent = $(".meal-recommendation-content");
        mealContent.slideToggle();
    });
   
//    $("#toggleMealRecommendation").click(function() {
//        $.ajax({
//            url: "/profile/dietguide.do",
//            type: "GET",
//            success: function(response) {
//                // 서버에서 응답을 받아와서 필요한 처리 수행
//                // 예를 들어, 받은 데이터를 이용하여 웹 페이지의 일부분 업데이트
//                $("#someDiv").html(response);
//            },
//            error: function(xhr, status, error) {
//                console.error("AJAX 요청 실패:", error);
//            }
//        });
//    });
});
