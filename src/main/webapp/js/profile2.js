$(document).ready(function() {
  $("#toggleMealRecommendation").click(function() {
    var mealContent = $(".meal-recommendation-content");
    mealContent.slideToggle();
   });
});
