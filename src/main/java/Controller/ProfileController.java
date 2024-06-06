package Controller;

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

import DTO.MemberDTO;
import DTO.MemberInfoDTO;
import DTO.WorkoutRoutineGenerator;

@WebServlet("/HealthCareLife/profile.do")
public class ProfileController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
        HttpSession session = request.getSession(false);
        
        MemberDTO memberdto = (MemberDTO) session.getAttribute("member");
        MemberInfoDTO memberInfodto =  (MemberInfoDTO) session.getAttribute("member_info");

        if(memberdto == null || memberInfodto == null) {
        	
        	System.out.println("profile : " + memberdto);
        	response.sendRedirect("/login&profile/login.jsp");
        	return;
        }
        
        String id = memberdto.getId();
        System.out.println(id);
        int goals = memberdto.getGoals();
        
        // goals 값에 따른 목표 문자열 설정
        String goalDescription;
        switch (goals) {
            case 1:
                goalDescription = "체중 감소";
                break;
            case 2:
                goalDescription = "벌크업";
                break;
            case 3:
                goalDescription = "체력 향상";
                break;
            case 4:
                goalDescription = "유연성 향상";
                break;
            default:
                goalDescription = "목표 미설정";
                break;
        }
        
        // BMI 계산
        double height = memberInfodto.getHeight() / 100.0; // 키를 미터로 변환
        double weight = memberInfodto.getWeight();
        double bmi = weight / (height * height);
        // 소수점 한 자리까지 반올림
        bmi = Math.round(bmi * 10.0) / 10.0;

        // BMI 지수에 따른 체중 상태 계산
        String bmiStatus;
        if (bmi < 18.5) {
            bmiStatus = "저체중";
        } else if (bmi >= 18.5 && bmi <= 22.9) {
            bmiStatus = "정상";
        } else if (bmi >= 23.0 && bmi <= 24.9) {
            bmiStatus = "비만 전단계";
        } else if (bmi >= 25.0 && bmi <= 29.9) {
            bmiStatus = "과체중";
        } else {
            bmiStatus = "비만";
        }

        // 체중 상태를 request에 추가
        request.setAttribute("bmi", bmi);
        request.setAttribute("bmiStatus", bmiStatus);
        request.setAttribute("goals", goalDescription); // 목표 문자열 추가
        
        // MemberInfoDTO에서 sdate를 가져온 후
        Date sdate = memberInfodto.getSdate();

        // sdate를 원하는 형식으로 포맷
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedSDate = dateFormat.format(sdate);

        // 포맷된 날짜를 DTO에 설정
        memberInfodto.setFormattedSDate(formattedSDate);
        // 회원 정보를 request에 추가
        request.setAttribute("dto", memberdto);
        request.setAttribute("dtoinfo", memberInfodto);
        
        
        
     // 운동 루틴 생성
        WorkoutRoutineGenerator generator = new WorkoutRoutineGenerator();
        List<String> selectedRoutine = null;

        // goalDescription 값에 따라서 해당하는 운동 루틴 선택
        switch (goalDescription) {
            case "체중 감소":
                selectedRoutine = generator.getRoutineByGoal(goalDescription);
                break;
            case "벌크업":
                selectedRoutine = generator.getRoutineByGoal(goalDescription);
                break;
            case "체력 향상":
                selectedRoutine = generator.getRoutineByGoal(goalDescription);
                break;
            case "유연성 향상":
                selectedRoutine = generator.getRoutineByGoal(goalDescription);
                break;
            default:
                // 예외 처리 등을 추가할 수 있습니다.
                break;
        }

        // 선택된 운동 루틴을 request에 추가
        request.setAttribute("selectedRoutine", selectedRoutine);


        // 프로필 페이지로 전송
        request.getRequestDispatcher("/login&profile/profile.jsp").forward(request, response);
    }
}
