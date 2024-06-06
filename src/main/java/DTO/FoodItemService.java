package DTO;

import java.util.ArrayList;
import java.util.List;


public class FoodItemService {
    public List<FoodItemDTO> getCarbohydrateFoods() {
        List<FoodItemDTO> carbohydrateFoods = new ArrayList<>();

        // 탄수화물 음식 아이템을 생성하여 리스트에 추가
        // 예제 데이터를 기반으로 작성하였습니다.
        carbohydrateFoods.add(new FoodItemDTO("단호박", "../Img_file/food_imgfile/단호박.jpeg",7.23,29));
        carbohydrateFoods.add(new FoodItemDTO("군고구마", "../Img_file/food_imgfile/군고구마.jpeg",28.38,123));
        carbohydrateFoods.add(new FoodItemDTO("찐고구마", "../Img_file/food_imgfile/찐고구마.jpeg",30.36,128));
        carbohydrateFoods.add(new FoodItemDTO("찐감자", "../Img_file/food_imgfile/찐감자.jpeg",29.58,131));
        carbohydrateFoods.add(new FoodItemDTO("흰쌀밥", "../Img_file/food_imgfile/쌀밥.jpg",31.02,143));
        carbohydrateFoods.add(new FoodItemDTO("잡곡밥", "../Img_file/food_imgfile/잡곡밥.jpeg",35.09,163));
        carbohydrateFoods.add(new FoodItemDTO("현미밥", "../Img_file/food_imgfile/현미밥.jpeg",32.83,153));
        carbohydrateFoods.add(new FoodItemDTO("흑미밥", "../Img_file/food_imgfile/흑미밥.jpeg",33.76 ,157));
        carbohydrateFoods.add(new FoodItemDTO("식빵", "../Img_file/food_imgfile/식빵.jpeg",50.61,266));
        carbohydrateFoods.add(new FoodItemDTO("베이글", "../Img_file/food_imgfile/베이글.jpeg",50.5,257));
        carbohydrateFoods.add(new FoodItemDTO("도넛", "../Img_file/food_imgfile/도넛.jpeg",49.7,421));
        carbohydrateFoods.add(new FoodItemDTO("통밀빵", "../Img_file/food_imgfile/통밀빵.jpeg",47.14,259));
        carbohydrateFoods.add(new FoodItemDTO("바나나", "../Img_file/food_imgfile/바나나.jpeg",22.84,89));
        carbohydrateFoods.add(new FoodItemDTO("사과", "../Img_file/food_imgfile/사과.jpeg",13.81,52));
        carbohydrateFoods.add(new FoodItemDTO("오렌지", "../Img_file/food_imgfile/오렌지.jpeg",11.75,47));
        carbohydrateFoods.add(new FoodItemDTO("레몬", "../Img_file/food_imgfile/레몬.jpeg",9.32,29));
        carbohydrateFoods.add(new FoodItemDTO("망고", "../Img_file/food_imgfile/망고.jpeg",17,65));
        carbohydrateFoods.add(new FoodItemDTO("복숭아", "../Img_file/food_imgfile/복숭아.jpeg",9.54,39));
       
        return carbohydrateFoods;
    }

    public List<FoodItemDTO> getProteinFoods() {
        List<FoodItemDTO> proteinFoods = new ArrayList<>();

        // 단백질 음식 아이템을 생성하여 리스트에 추가
        // 예제 데이터를 기반으로 작성하였습니다.
        proteinFoods.add(new FoodItemDTO("닭가슴살", "../Img_file/food_imgfile/닭가슴살.jpeg", 25.6, 110));
        proteinFoods.add(new FoodItemDTO("계란", "../Img_file/food_imgfile/계란.jpeg", 6.26, 70));
        proteinFoods.add(new FoodItemDTO("닭 날개", "../Img_file/food_imgfile/닭날개.jpeg",26.54,288));
        proteinFoods.add(new FoodItemDTO("닭 다리", "../Img_file/food_imgfile/닭다리.jpeg",26.8,214));
        proteinFoods.add(new FoodItemDTO("닭 다리살", "../Img_file/food_imgfile/닭다리살.jpeg",18.7,156));
        proteinFoods.add(new FoodItemDTO("소고기(안심)", "../Img_file/food_imgfile/소고기안심.jpeg",20.78,169));
        proteinFoods.add(new FoodItemDTO("소고기(갈비)", "../Img_file/food_imgfile/소고기갈비.jpeg",19.3,258));
        proteinFoods.add(new FoodItemDTO("소고기(목살)", "../Img_file/food_imgfile/소고기목살.jpeg",19.07,149));
        proteinFoods.add(new FoodItemDTO("소고기(앞다리)", "../Img_file/food_imgfile/소고기앞다리.jpeg",19.61,165));
        proteinFoods.add(new FoodItemDTO("소고기(차돌)", "../Img_file/food_imgfile/소고기차돌.jpeg",19.61,165));
        proteinFoods.add(new FoodItemDTO("돼지고기(안심)", "../Img_file/food_imgfile/돼지고기안심.jpeg",20.54,136));
        proteinFoods.add(new FoodItemDTO("돼지고기(목살)", "../Img_file/food_imgfile/돼지고기목살.jpeg",23.11,269));
        proteinFoods.add(new FoodItemDTO("돼지고기(등심)", "../Img_file/food_imgfile/돼지고기등심.jpeg",22.92,232));
        proteinFoods.add(new FoodItemDTO("돼지고기(갈비)", "../Img_file/food_imgfile/돼지고기갈비.jpeg",27.91,250));
        proteinFoods.add(new FoodItemDTO("돼지고기(삼겹살)", "../Img_file/food_imgfile/돼지고기삼겹살.jpeg",18.21,349));
        proteinFoods.add(new FoodItemDTO("돼지고기(차돌)", "../Img_file/food_imgfile/돼지고기차돌.jpeg",16.27,182));
        proteinFoods.add(new FoodItemDTO("고등어", "../Img_file/food_imgfile/고등어.jpeg",19.32,167));
        proteinFoods.add(new FoodItemDTO("새우", "../Img_file/food_imgfile/새우.jpeg",20.31,106));
        proteinFoods.add(new FoodItemDTO("연어", "../Img_file/food_imgfile/연어.jpeg",21.62,146));
        proteinFoods.add(new FoodItemDTO("광어", "../Img_file/food_imgfile/광어.jpeg",20.44,103));
        proteinFoods.add(new FoodItemDTO("갈치", "../Img_file/food_imgfile/갈치.jpeg",18.73,143));

        return proteinFoods;
    }

    public List<FoodItemDTO> getFatFoods() {
        List<FoodItemDTO> fatFoods = new ArrayList<>();

        // 지방 음식 아이템을 생성하여 리스트에 추가
        // 예제 데이터를 기반으로 작성하였습니다.
        fatFoods.add(new FoodItemDTO("아보카도", "../Img_file/food_imgfile/아보카도.jpeg",14.66,160));
        fatFoods.add(new FoodItemDTO("캐슈넛", "../Img_file/food_imgfile/캐슈넛.jpeg",9.16,553));
        fatFoods.add(new FoodItemDTO("올리브 오일", "../Img_file/food_imgfile/올리브.jpeg",100,884));
        fatFoods.add(new FoodItemDTO("코코넛 오일", "../Img_file/food_imgfile/코코넛오일.jpeg",100,862));
        fatFoods.add(new FoodItemDTO("아몬드", "../Img_file/food_imgfile/아몬드.jpeg",50.64,578));
        fatFoods.add(new FoodItemDTO("호두", "../Img_file/food_imgfile/호두.jpeg",65.21,654));
        fatFoods.add(new FoodItemDTO("피스타치오", "../Img_file/food_imgfile/피스타치오.jpeg",44.44,557));
        fatFoods.add(new FoodItemDTO("해바라기씨", "../Img_file/food_imgfile/해바라기씨.jpeg",49.57,570));
        fatFoods.add(new FoodItemDTO("버터", "../Img_file/food_imgfile/버터.jpeg",81.11,717));
        fatFoods.add(new FoodItemDTO("치즈", "../Img_file/food_imgfile/치즈.jpeg",26.91,350));
        fatFoods.add(new FoodItemDTO("모짜렐라", "../Img_file/food_imgfile/모짜렐라.jpeg",20.03,302));
        fatFoods.add(new FoodItemDTO("크림치즈", "../Img_file/food_imgfile/크림치즈.jpeg",34.87,349));
        fatFoods.add(new FoodItemDTO("요거트", "../Img_file/food_imgfile/요거트.jpeg",1.99,63));
        fatFoods.add(new FoodItemDTO("다크초콜릿", "../Img_file/food_imgfile/다크초콜릿.jpeg",6,120));
        

        return fatFoods;
    }
}
