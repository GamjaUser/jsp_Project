package Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
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
        MemberInfoDTO memberInfodto = (MemberInfoDTO) session.getAttribute("member_info");

        if (memberdto == null || memberInfodto == null) {
            response.sendRedirect("/login&profile/login.jsp");
            return;
        }

        String id = memberdto.getId();
        int goals = memberdto.getGoals();

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

        double height = memberInfodto.getHeight() / 100.0;
        double weight = memberInfodto.getWeight();
        double bmi = weight / (height * height);
        bmi = Math.round(bmi * 10.0) / 10.0;

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

        request.setAttribute("bmi", bmi);
        request.setAttribute("bmiStatus", bmiStatus);
        request.setAttribute("goals", goalDescription);

        Date sdate = memberInfodto.getSdate();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedSDate = dateFormat.format(sdate);
        memberInfodto.setFormattedSDate(formattedSDate);

        request.setAttribute("dto", memberdto);
        request.setAttribute("dtoinfo", memberInfodto);

        WorkoutRoutineGenerator generator = new WorkoutRoutineGenerator();
        List<String> selectedRoutine = generator.getRoutineByGoal(goalDescription);

        request.setAttribute("selectedRoutine", selectedRoutine);

        request.getRequestDispatcher("/login&profile/profile.jsp").forward(request, response);
    }
}
		