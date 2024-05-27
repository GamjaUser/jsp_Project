package Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import DAO.MemberDAO;
import DAO.MemberInfoDAO;
import DTO.MemberDTO;
import DTO.MemberInfoDTO;

@WebServlet("/Profile/profile.do")
public class ProfileController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        MemberDAO memberdao = new MemberDAO(getServletContext());
        MemberInfoDAO memberinfodao = new MemberInfoDAO(getServletContext());

        // 회원 정보 불러오기
        MemberDTO memberdto = memberdao.selectProfileView(id);
        MemberInfoDTO memberInfodto = memberinfodao.selectProfileView_info(id);
        memberdao.close();
        memberinfodao.close();

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
