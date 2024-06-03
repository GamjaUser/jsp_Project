package DTO;

import java.util.ArrayList;
import java.util.List;

public class FoodItemService {
    public List<FoodItemDTO> getCarbohydrateFoods() {
        List<FoodItemDTO> carbohydrateFoods = new ArrayList<>();

        // 탄수화물 음식 아이템을 생성하여 리스트에 추가
        // 예제 데이터를 기반으로 작성하였습니다.
        carbohydrateFoods.add(new FoodItemDTO("단호박", "img_url", 7.23, 29));
        carbohydrateFoods.add(new FoodItemDTO("군고구마", "img_url", 28.38, 123));
        carbohydrateFoods.add(new FoodItemDTO("찐고구마", "img_url", 30.36, 128));
        // 필요한 만큼 추가...

        return carbohydrateFoods;
    }

    public List<FoodItemDTO> getProteinFoods() {
        List<FoodItemDTO> proteinFoods = new ArrayList<>();

        // 단백질 음식 아이템을 생성하여 리스트에 추가
        // 예제 데이터를 기반으로 작성하였습니다.
        proteinFoods.add(new FoodItemDTO("닭가슴살", "img_url", 25.6, 110));
        proteinFoods.add(new FoodItemDTO("연어", "img_url", 20.42, 117));
        proteinFoods.add(new FoodItemDTO("계란", "img_url", 6.26, 70));
        // 필요한 만큼 추가...

        return proteinFoods;
    }

    public List<FoodItemDTO> getFatFoods() {
        List<FoodItemDTO> fatFoods = new ArrayList<>();

        // 지방 음식 아이템을 생성하여 리스트에 추가
        // 예제 데이터를 기반으로 작성하였습니다.
        fatFoods.add(new FoodItemDTO("아보카도", "img_url", 14.66, 160));
        fatFoods.add(new FoodItemDTO("캐슈넛", "img_url", 9.16, 553));
        fatFoods.add(new FoodItemDTO("올리브 오일", "img_url", 13.5, 120));
        // 필요한 만큼 추가...

        return fatFoods;
    }
}
