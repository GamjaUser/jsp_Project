package DTO;

public class FoodItemDTO {
    private String name;
    private String image;
    private double nutrient; // 탄수화물, 단백질, 지방 중 하나
    private int calories;

    // 생성자
    public FoodItemDTO(String name, String image, double nutrient, int calories) {
        this.name = name;
        this.image = image;
        this.nutrient = nutrient;
        this.calories = calories;
    }

    // 게터와 세터
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }
    public double getNutrient() { return nutrient; }
    public void setNutrient(double nutrient) { this.nutrient = nutrient; }
    public int getCalories() { return calories; }
    public void setCalories(int calories) { this.calories = calories; }
}