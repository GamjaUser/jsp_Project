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

import DTO.MemberDTO;
import DTO.MemberInfoDTO;

@WebServlet("/Profile/profile.do")
public class ProfileController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
//        if (session == null || session.getAttribute("user") == null || session.getAttribute("userinfo") == null) {
//            // 세션이 없거나 사용자가 로그인되지 않은 경우 로그인 페이지로 리다이렉트
//            response.sendRedirect(request.getContextPath() + "/login/login.do");
//            return;
//        }

        MemberDTO memberdto = (MemberDTO) session.getAttribute("member");
        MemberInfoDTO memberInfodto =  (MemberInfoDTO) session.getAttribute("member_info");

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

        // 프로필 페이지로 전송
        request.getRequestDispatcher("/login&profile/profile.jsp").forward(request, response);
    }
}
