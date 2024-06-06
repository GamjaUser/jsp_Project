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

    // 체중 감소 운동 루틴 생성 메서드
    private List<String> generateWeightLossRoutine() {
        List<String> weightLossRoutine = new ArrayList<>();
        // 체중 감소에 대한 운동 루틴 생성 및 저장
        for (int i = 1; i <= 3; i++) {
            weightLossRoutine.add(i+"루틴"); 
        }
        return weightLossRoutine;
    }

    // 벌크업 운동 루틴 생성 메서드
    private List<String> generateBulkingRoutine() {
        List<String> bulkingRoutine = new ArrayList<>();
        // 벌크업에 대한 운동 루틴 생성 및 저장
        for (int i = 1; i <= 5; i++) {
            bulkingRoutine.add(i+"루틴"); 
        }
        return bulkingRoutine;
    }

    // 체력 향상 운동 루틴 생성 메서드
    private List<String> generateEnduranceImprovementRoutine() {
        List<String> enduranceImprovementRoutine = new ArrayList<>();
        // 체력 향상에 대한 운동 루틴 생성 및 저장
        for (int i = 1; i <= 4; i++) {
            enduranceImprovementRoutine.add(i+"루틴"); 
        }
        return enduranceImprovementRoutine;
    }

    // 유연성 향상 운동 루틴 생성 메서드
    private List<String> generateFlexibilityImprovementRoutine() {
        List<String> flexibilityImprovementRoutine = new ArrayList<>();
        // 유연성 향상에 대한 운동 루틴 생성 및 저장
        for (int i = 1; i <= 3; i++) {
            flexibilityImprovementRoutine.add(i+"루틴"); 
        }
        return flexibilityImprovementRoutine;
    }

    // 운동 목표에 따른 운동 루틴 가져오는 메서드
    public List<String> getRoutineByGoal(String goal) {
        return routineMap.getOrDefault(goal, new ArrayList<>());
    }
}
