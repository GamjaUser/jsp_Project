package Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
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

        int bm = 0;
        int am = 0;
        int im = 0;
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
        List<FoodItemDTO> selectedProteinFoods = getproRandomFoods(proteinFoods, 5, pro2);
        List<FoodItemDTO> selectedFatFoods = getfatRandomFoods(fatFoods, 4, fat2);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResponsecar = objectMapper.writeValueAsString(selectedCarbohydrateFoods);
        String jsonResponsepro = objectMapper.writeValueAsString(selectedProteinFoods);
        String jsonResponsefat = objectMapper.writeValueAsString(selectedFatFoods);

        String jsonResponse = String.format(
            "{\"bm\": %d, \"am\": %d, \"im\": %d, \"car\": %d, \"pro\": %d, \"fat\": %d," 
            + "\"car2\": %d, \"pro2\": %d, \"fat2\": %d, \"meal\": %d,"
            + "\"carbohydrateFoods\": %s, \"proteinFoods\": %s, \"fatFoods\": %s}",
            bm, am, im, car, pro, fat, car2, pro2, fat2, mealCalorie,
            jsonResponsecar, jsonResponsepro, jsonResponsefat
        );

        response.getWriter().write(jsonResponse);
    }

    private List<FoodItemDTO> getcarRandomFoods(List<FoodItemDTO> foods, int count, int car2) {
        List<FoodItemDTO> carFoods = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < count; i++) {
            FoodItemDTO food = foods.get(random.nextInt(foods.size()));
            String name = food.getName();
            String img = food.getImage();
            float nut = (float) food.getNutrient();
            int gram = (int) (car2 / (nut / 100));
            int kcal = food.getCalories();
            FoodItemDTO selectedFood = new FoodItemDTO(name, img, gram, kcal);
            carFoods.add(selectedFood);
        }
        return carFoods;
    }

    private List<FoodItemDTO> getproRandomFoods(List<FoodItemDTO> foods, int count, int pro2) {
        List<FoodItemDTO> proFoods = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < count; i++) {
            FoodItemDTO food = foods.get(random.nextInt(foods.size()));
            String name = food.getName();
            String img = food.getImage();
            float nut = (float) food.getNutrient();
            int gram = (int) (pro2 / (nut / 100));
            int kcal = food.getCalories();
            FoodItemDTO selectedFood = new FoodItemDTO(name, img, gram, kcal);
            proFoods.add(selectedFood);
        }
        return proFoods;
    }

    private List<FoodItemDTO> getfatRandomFoods(List<FoodItemDTO> foods, int count, int fat2) {
        List<FoodItemDTO> fatFoods = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < count; i++) {
            FoodItemDTO food = foods.get(random.nextInt(foods.size()));
            String name = food.getName();
            String img = food.getImage();
            float nut = (float) food.getNutrient();
            int gram = (int) (fat2 / (nut / 100));
            int kcal = food.getCalories();
            FoodItemDTO selectedFood = new FoodItemDTO(name, img, gram, kcal);
            fatFoods.add(selectedFood);
        }
        return fatFoods;
    }
}
