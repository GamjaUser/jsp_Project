package Controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import DTO.FoodItemDTO;
import DTO.FoodItemService;
import DTO.MemberDTO;
import DTO.MemberInfoDTO;

@WebServlet("/profile/dietguide.do")
public class DietGuideController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        MemberDTO memberdto = (MemberDTO) session.getAttribute("member");
        MemberInfoDTO memberInfodto = (MemberInfoDTO) session.getAttribute("member_info");

        String gender = memberdto.getGender();
        int age = memberdto.getAge();
        int exerciseEXP = memberdto.getExerciseEXP();
        int goals = memberdto.getGoals();

        int weight = memberInfodto.getWeight();
        int height = memberInfodto.getHeight();

        int bm = 0; // 기초 대사량 초기값
        int am = 0; // 활동 대사량 초기값
        int im = 0; // 일일 섭취권장 대사량 초기값
        int car = 0;
        int pro = 0;
        int fat = 0;
        int car2 = 0;
        int pro2 = 0;
        int fat2 = 0;
        int mealCalorie = 0;
        
        
        try {
            if (gender.equals("남")) {
                bm += 66.5 + (13.75 * weight) + (5 * height) - (6.76 * age);
            } else if (gender.equals("여")) {
                bm += 655.1 + (9.56 * weight) + (1.85 * height) - (4.68 * age);
            } else {
                System.out.println("성별 정보가 없습니다.");
            }

            switch (exerciseEXP) {
                case 1:
                    am = (int) (bm * 1.2);
                    break;
                case 2:
                    am = (int) (bm * 1.375);
                    break;
                case 3:
                    am = (int) (bm * 1.555);
                    break;
                case 4:
                    am = (int) (bm * 1.725);
                    break;
                case 5:
                    am = (int) (bm * 1.9);
                    break;
                default:
                    System.out.println("활동 대사량을 계산할 수 없습니다.");
            }

            switch (goals) {
                case 1:
                    im = (int) (am * 0.8);
                    break;
                case 2:
                    im = (int) (am * 1.1);
                    break;
                case 3:
                case 4:
                    im = (int) (am * 1.0);
                    break;
                default:
                    System.out.println("유효하지 않은 목표입니다.");
            }

            double carbohydrateRatio = 0.0;
            double proteinRatio = 0.0;
            double fatRatio = 0.0;

            switch (goals) {
                case 1:
                    carbohydrateRatio = 0.3;
                    proteinRatio = 0.4;
                    fatRatio = 0.3;
                    break;
                case 2:
                    carbohydrateRatio = 0.5;
                    proteinRatio = 0.3;
                    fatRatio = 0.2;
                    break;
                case 3:
                case 4:
                    carbohydrateRatio = 0.4;
                    proteinRatio = 0.3;
                    fatRatio = 0.3;
                    break;
                default:
                    System.out.println("유효하지 않은 목표입니다.");
            }

            int carbohydrateIntake = (int) (im * carbohydrateRatio / 4);
            int proteinIntake = (int) (im * proteinRatio / 4);
            int fatIntake = (int) (im * fatRatio / 9);

            mealCalorie = im / 3;

            car = (int) (carbohydrateIntake / 3);
            pro = (int) (proteinIntake / 3);
            fat = (int) (fatIntake / 3);
            car2 = car;
            pro2 = pro;
            fat2 = fat;
            
//            System.out.println("기초 대사량: " + bm);
//            System.out.println("활동 대사량: " + am);
//            System.out.println("일일 섭취 권장 대사량: " + im);
//            System.out.println("일일 섭취 권장 탄수화물: " + carbohydrateIntake);
//            System.out.println("일일 섭취 권장 단백질: " + proteinIntake);
//            System.out.println("일일 섭취 권장 지방: " + fatIntake);
//
//            System.out.println("끼니 섭취 권장 대사량: " + mealCalorie);
//            System.out.println("끼니 섭취 권장 탄수화물: " + car);
//            System.out.println("끼니 섭취 권장 단백질: " + pro);
//            System.out.println("끼니 섭취 권장 지방: " + fat);
            
            // 랜덤으로 음식 아이템 선택하여 영양분 합산
            FoodItemService foodItemService = new FoodItemService();
            List<FoodItemDTO> carbohydrateFoods = foodItemService.getCarbohydrateFoods();
            List<FoodItemDTO> proteinFoods = foodItemService.getProteinFoods();
            List<FoodItemDTO> fatFoods = foodItemService.getFatFoods();
            
            Random random = new Random();
            FoodItemDTO randomCarbohydrateFood = carbohydrateFoods.get(random.nextInt(carbohydrateFoods.size()));
            FoodItemDTO randomProteinFood = proteinFoods.get(random.nextInt(proteinFoods.size()));
            FoodItemDTO randomFatFood = fatFoods.get(random.nextInt(fatFoods.size()));
            
            //랜덤으로 선택한 음식
            String carfood = randomCarbohydrateFood.getName();
            String profood = randomProteinFood.getName();
            String fatfood = randomFatFood.getName();
            
            //랜덤으로 선택한 이미지
            String carimg = randomCarbohydrateFood.getImage();
            String proimg = randomProteinFood.getImage();
            String fatimg = randomFatFood.getImage();
            
            // 랜덤으로 선택한 음식의 100g 당 영양분 함량
            float carbohydratePer100g = (float) randomCarbohydrateFood.getNutrient();
            float proteinPer100g = (float) randomProteinFood.getNutrient();
            float fatPer100g = (float) randomFatFood.getNutrient();
            
            // 음식의 필요한 그램 수 계산
            int cargram = (int) (car2 / (carbohydratePer100g / 100));
            int program = (int) (pro2 / (proteinPer100g / 100));
            int fatgram = (int) (fat2 / (fatPer100g / 100));
            
            System.out.println("랜덤 탄수화물음식 : " + carfood);
            System.out.println("랜덤 단백질음식 : " + profood);
            System.out.println("랜덤 지방음식 : " + fatfood);
          System.out.println("랜덤 탄수화물: " + cargram);
          System.out.println("랜덤 단백질: " + program);
          System.out.println("랜덤 지방: " + fatgram);
        
        } catch (Exception e) {
            System.out.println("Exception[대사량 계산 오류]: " + e.getMessage());
        }
        
        List<FoodItemDTO> carbohydrateFoods = new ArrayList<>();
        List<FoodItemDTO> proteinFoods = new ArrayList<>();
        List<FoodItemDTO> fatFoods = new ArrayList<>();

        try {
            FoodItemService foodItemService = new FoodItemService();
            carbohydrateFoods = foodItemService.getCarbohydrateFoods();
            proteinFoods = foodItemService.getProteinFoods();
            fatFoods = foodItemService.getFatFoods();
        } catch (Exception e) {
            System.out.println("Exception[음식 리스트 오류]: " + e.getMessage());
        }

        List<FoodItemDTO> selectedCarbohydrateFoods = getcarRandomFoods(carbohydrateFoods, 7, car2);
        List<FoodItemDTO> selectedProteinFoods = getRandomFoods(proteinFoods, 5);
        List<FoodItemDTO> selectedFatFoods = getRandomFoods(fatFoods, 4);

        // 나머지 코드는 그대로 사용합니다.
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
        
        String jsonResponse = String.format(
            "{\"bm\": %d, \"am\": %d, \"im\": %d, \"car\": %d, \"pro\": %d, \"fat\": %d," 
            								   + "\"car2\": %d, \"pro2\": %d, \"fat2\": %d,  \"meal\": %d}",
            bm, am, im, car, pro, fat,car2,pro2,fat2, mealCalorie
        );
        
        response.getWriter().write(jsonResponse);
    }
    
    
    
    	private List<FoodItemDTO> getcarRandomFoods(List<FoodItemDTO> foods, int count, int car2) {
    		List<FoodItemDTO> selectedFoods = new ArrayList<>();
    		Random random = new Random();

        for (int i = 0; i < count; i++) {
            FoodItemDTO food = foods.get(random.nextInt(foods.size()));
            String name = food.getName();
            String img = food.getImage();
            float nut = (float) food.getNutrient();
            int gram = (int) (car2 / (nut / 100));
            selectedFoods.add(food);
        }
        System.out.println("select음식: " + selectedFoods);


        return selectedFoods;
    }
}