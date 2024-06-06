package DTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WorkoutRoutineGenerator {
    // 운동 루틴 목록을 저장할 맵
    private Map<String, List<String>> routineMap;

    // 생성자
    public WorkoutRoutineGenerator() {
        // 운동 루틴 생성 및 맵에 저장
        routineMap = new HashMap<>();
        routineMap.put("체중 감소", generateWeightLossRoutine());
        routineMap.put("벌크업", generateBulkingRoutine());
        routineMap.put("체력 향상", generateEnduranceImprovementRoutine());
        routineMap.put("유연성 향상", generateFlexibilityImprovementRoutine());
    }
 
    //체중감소루틴
    public List<String> Weightloss() {
        List<String> weightloss = new ArrayList<>();
        weightloss.add("워밍업 (5-10분): 가벼운 조깅 또는 빠르게 걷기");
        weightloss.add("유산소 운동 (20분): 인터벌 러닝: 1분 전력 질주, 1분 천천히 걷기 (10회 반복)");
        weightloss.add("전신 근력 운동 (3세트): <br> 스쿼트 (15회)  <br>"
                + "푸시업 (15회)  <br>"
                + "버피 (10회)  <br>"
                + "플랭크 (1분)  <br><br>");
        
        weightloss.add("워밍업 (5-10분): 가벼운 조깅 또는 빠르게 걷기");
        weightloss.add("하체 근력 운동 (3세트)<br>"
        		+ "런지 (각 다리 15회)<br>"
        		+ "데드리프트 (15회)<br>"
        		+ "데드리프트 (15회)<br>"
        		+ "카프 레이즈 (20회)<br>");
        weightloss.add("유산소 운동 (20분): 고강도 인터벌 트레이닝 (HIIT) (1분 전력 운동, 1분 휴식 - 10회 반복)<br><br>");
        
        weightloss.add("워밍업 (5-10분): 가벼운 조깅 또는 빠르게 걷기");
        weightloss.add("상체 근력 운동 (3세트): <br>덤벨 벤치프레스 (15회)<br>"
        		+ "덤벨 로우 (15회)<br>"
        		+ "숄더 프레스 (15회)<br>"
        		+ "트라이셉스 딥스 (15회)<br>");
        weightloss.add("유산소 운동 (20분): 사이클링 또는 스텝퍼 사용</font>");
        
        return weightloss;
    }
    
    //벌크업루틴
    public List<String> Bulking() {
        List<String> bulking = new ArrayList<>();
        bulking.add("벤치프레스: 세트: 4 반복 횟수: 8-12");
        bulking.add("덤벨 플라이: 세트: 4 반복 횟수: 10-12");
        bulking.add("딥스 (체중 또는 추가 무게): 세트: 3 반복 횟수: 8-10");
        bulking.add("트라이셉스 익스텐션: 세트 : 3 반복 횟수: 10-12");
        bulking.add("케이블 크로스오버: 세트: 4 반복 횟수: 12-15<br><br>");
        
        bulking.add("풀업: 세트: 4 반복 횟수: 6-10");
        bulking.add("바벨 로우: 세트: 4 반복 횟수: 8-12");
        bulking.add("덤벨 로우: 세트: 4 반복 횟수: 10-12");
        bulking.add("페이스 풀: 세트: 3 반복 횟수: 12-15");
        bulking.add("이두컬 (덤벨 또는 바벨): 세트: 4 반복 횟수: 10-12<br><br>");
        
        bulking.add("스쿼트: 세트: 4 반복 횟수: 10-12");
        bulking.add("레그 프레스: 세트: 4 반복 횟수: 10-12");
        bulking.add("루마니안 데드리프트: 세트: 4 반복 횟수: 10-12");
        bulking.add("오버헤드 프레스: 세트: 4 반복 횟수: 10-12");
        bulking.add("레터럴 레이즈: 세트: 4 반복 횟수: 12-15</font>");
        
         
        return bulking;
    }
    
    //체력 향상루틴
    public List<String> Endurance() {
        List<String> endurance = new ArrayList<>();
        endurance.add("러닝 머신 또는 조깅: 시간: 20-30분 강도: 중간에서 고강도");
        endurance.add("스쿼트: 세트: 4 반복 횟수: 10-12");
        endurance.add("푸시업: 세트: 3 반복 횟수: 최대 반복 횟수까지");
        endurance.add("플랭크: 시간: 1-2분<br><br>");
        
        endurance.add("싸이클링 또는 실내 자전거: 시간: 20-30분 강도: 중간에서 고강도");
        endurance.add("덤벨 숄더 프레스: 세트: 4 반복 횟수: 8-10");
        endurance.add("랫 풀다운: 세트: 4 반복 횟수: 10-12");
        endurance.add("덤벨 벤트오버 로우: 세트: 3 반복 횟수: 10-12<br><br>");
        
        endurance.add("로잉 머신 또는 로잉: 시간: 20-30분 강도: 중간에서 고강도");
        endurance.add("레그 프레스: 세트: 4 반복 횟수: 10-12");
        endurance.add("랜지 런지: 세트: 3 반복 횟수: 12-15");
        endurance.add("스티프 레그 데드리프트: 세트: 3 반복 횟수: 10-12</font>");
        return endurance;
    }

    //유연성 향상루틴
    public List<String> Flexibility() {
        List<String> flexibility = new ArrayList<>();
        flexibility.add("몸풀기 루틴: <br>전신 스트레칭: 팔과 다리를 천천히 움직여 근육을 풀어주세요. <br>목, 어깨, 등, 팔, 다리 순서로 스트레칭을 수행하세요.");
        flexibility.add("요가: 산타나마스카라 (산타의 인사 자세): <br>무릎을 바닥에 꿇고 양쪽 팔을 위로 들어 곧게 세우세요. <br>호흡에 맞춰 팔을 앞으로 내밀고 가슴을 바닥에 대세요. <br>팔을 원위치하고 다시 일어나세요.");
        flexibility.add("요가: 다운워드 도그 자세 (Downward Dog Pose): <br>네 다리를 바닥에 대고 엉덩이를 올리세요. <br>팔을 뻗어 몸을 바닥 쪽으로 밀어 내려가세요. <br>등과 다리의 근육을 늘리며 몸을 이 자세에 맞게 조절하세요.");
        flexibility.add("요가: 나카스나나 자세 (Nakasana Pose): <br>바닥에 누워서 손을 몸 옆에 두고 발을 땅에서 떼세요. <br>어깨와 배부분의 근육을 늘리며 조금씩 뒤척여 보세요.<br><br>");
        
        flexibility.add("몸풀기 루틴: 골반 회전: <br>바닥에 누워서 무릎을 흔들며 골반을 좌우로 회전하세요. <br>천천히 회전하면서 호흡을 깊게 하세요.");
        flexibility.add("요가: 코브라 자세 (Bhujangasana): <br>엎드려 눕고 양팔을 어깨 옆에 놓고 팔꿈치를 굽혀 땅에 붙입니다. <br>호흡에 맞춰 가슴을 들어올리고 팔을 펴고 머리를 뒤로 젖힙니다. <br>이 자세를 몸이 편안할 때까지 유지하고 천천히 내려오세요.");
        flexibility.add("요가: 나타라자나 자세 (Natarajasana Pose): <br>서서 왼쪽 발로 굽혀진 오른쪽 다리를 뒤로 당겨 머리와 손을 맞닿게 합니다. <br>한 쪽 다리를 뒤로 뻗으면서 앞쪽 팔로 발을 잡습니다. <br>균형을 유지하며 천천히 몸을 뒤로 기울입니다.");
        flexibility.add("요가: 마카라사나 자세 (Makarasana Pose): <br>바닥에 누워 양쪽 팔을 몸 옆에 놓고 손바닥을 아래로 향하게 합니다. <br>양쪽 다리를 늘어뜨리고 팔을 살짝 옆으로 벌립니다. <br>이 자세에서 몸을 살짝 들고 호흡을 깊게 합니다.<br><br>");
        
        flexibility.add("몸풀기 루틴: 고무줄 스트레칭: <br>고무줄이나 탄성 줄을 이용하여 다양한 근육을 스트레칭하세요. <br>팔, 다리, 등, 허벅지 등 다양한 부위를 스트레칭합니다.");
        flexibility.add("요가: 트라이콘아사나 자세 (Trikonasana Pose): <br>서서 양쪽 다리를 벌리고 팔을 옆으로 펴세요. <br>한 쪽 다리를 앞으로 펴서 손으로 발을 잡고 다른 손은 천천히 위로 들어올려 팔을 곧게 펴세요.  <br>몸을 살짝 기울여 한쪽 팔을 바닥에 대고 다른 팔은 천장을 바라봅니다.");
        flexibility.add("요가: 아나이마 시라사나 자세 (Anjaneyasana Pose): <br>무릎을 바닥에 대고 한 쪽 다리를 뒤로 뻗고 다른 쪽 다리는 앞으로 굽힙니다. <br>천천히 앞다리를 앞으로 뻗으면서 손을 머리 위로 들어올려 몸을 곧게 펴세요.<br> 등과 허벅지의 근육을 늘리며 몸을 조절하세요.");
        flexibility.add("요가: 베파릿타 코루나 자세 (Baddha Konasana Pose):<br> 바닥에 앉아서 발끝을 서로 맞닿게 합니다. <br>천천히 무릎을 바닥 쪽으로 밀어 내려가고 어깨와 등을 펴세요. <br>호흡에 맞춰 가슴을 열고 몸을 앞으로 기울이세요.</font>");
        
        return flexibility;
    }

    // 체중 감소 운동 루틴 생성 메서드
    private List<String> generateWeightLossRoutine() {
        List<String> finalRoutine = new ArrayList<>();
        List<String> weightLossRoutine = Weightloss();
        String[] wlr = {"유산소 운동 및 전신 근력 운동", "하체 집중 운동", "상체 집중 운동"};
       
        for (int n = 0; n < wlr.length; n++) {
        	 int j=0;
            finalRoutine.add("<font face=\"Arial, sans-serif\" size=\"4\" color=\"black\">"+(n + 1) + "일차: " + wlr[n] + "<br>");
             // Weightloss 메서드 호출하여 리스트 항목 가져옴
            for (int i = 0; i<3; i++) {
            	
            	finalRoutine.add((i+1) + "루틴: " + weightLossRoutine.get(i+j));
            	
            }
            j += 3;
        }

        return finalRoutine;
    }

 
    // 벌크업 운동 루틴 생성 메서드
    private List<String> generateBulkingRoutine() {
    	List<String> finalRoutine = new ArrayList<>();
        List<String> BulkingRoutine = Bulking();
        String[] br = {"가슴 및 삼두근", "등 및 이두근", "다리 및 어깨"};
       
        for (int n = 0; n < br.length; n++) {
        	 int j=0;
            finalRoutine.add("<font face=\"Arial, sans-serif\" size=\"4\" color=\"black\">"+(n + 1) + "일차: " + br[n] + "<br>");
             // Weightloss 메서드 호출하여 리스트 항목 가져옴
            for (int i = 0; i<5; i++) {
            	
            	finalRoutine.add((i+1) + "루틴: " + BulkingRoutine.get(i+j));
            	
            }
            j += 5;
        }

        return finalRoutine;
    }

    // 체력 향상 운동 루틴 생성 메서드
    private List<String> generateEnduranceImprovementRoutine() {
    	List<String> finalRoutine = new ArrayList<>();
        List<String> EnduranceRoutine = Endurance();
        String[] eir = {"유산소 운동 및 전신 근력 운동", "유산소 운동 및 상체 근력 운동", "유산소 운동 및 하체 근력 운동"};
       
        for (int n = 0; n < eir.length; n++) {
        	 int j=0;
            finalRoutine.add("<font face=\"Arial, sans-serif\" size=\"4\" color=\"black\">"+(n + 1) + "일차: " + eir[n] + "<br><br>");
             // Weightloss 메서드 호출하여 리스트 항목 가져옴
            for (int i = 0; i<4; i++) {
            	
            	finalRoutine.add((i+1) + "루틴: " + EnduranceRoutine.get(i+j));
            	
            }
            j += 4;
        }

        return finalRoutine;
    }

    // 유연성 향상 운동 루틴 생성 메서드
    private List<String> generateFlexibilityImprovementRoutine() {
    	List<String> finalRoutine = new ArrayList<>();
        List<String> FlexibilityRoutine = Flexibility();
        String[] fir = {"유연성 향상을 위한 운동 루틴", "유연성 향상을 위한 운동 루틴", "유연성 향상을 위한 운동 루틴"};
       
        for (int n = 0; n < fir.length; n++) {
        	 int j=0;
            finalRoutine.add("<font face=\"Arial, sans-serif\" size=\"4\" color=\"black\">"+(n + 1) + "일차: " + fir[n] + "<br><br>");
             // Weightloss 메서드 호출하여 리스트 항목 가져옴
            for (int i = 0; i<4; i++) {
            	
            	finalRoutine.add((i+1) + "루틴: " + FlexibilityRoutine.get(i+j));
            	
            }
            j += 4;
        }

        return finalRoutine;
    }

    // 운동 목표에 따른 운동 루틴 가져오는 메서드
    public List<String> getRoutineByGoal(String goal) {
        return routineMap.getOrDefault(goal, new ArrayList<>());
    }
}
