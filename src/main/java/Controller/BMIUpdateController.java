package Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.MemberInfoDAO;
import DTO.MemberInfoDTO;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/profile/updateBMI")
public class BMIUpdateController extends HttpServlet {
	 private static final long serialVersionUID = 1L;
	 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 폼에서 체중과 신장 값을 가져옴
        int weight = Integer.parseInt(request.getParameter("weight"));
        int height = Integer.parseInt(request.getParameter("height"));

        // BMI 계산
        double bmi = calculateBMI(weight, height);

        // 세션에 BMI 업데이트
        HttpSession session = request.getSession();
        session.setAttribute("bmi", bmi);

        // 데이터베이스 업데이트
        MemberInfoDTO memberInfo = (MemberInfoDTO) session.getAttribute("member_info");
        String id = memberInfo.getId();
        try {
			updateDatabase(id, weight, height);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // MemberInfoDAO에서 데이터베이스 업데이트 메소드 호출

        // 다시 프로필 페이지로 이동
        response.sendRedirect(request.getContextPath() + "/Profile/profile.do");
    }

    private int calculateBMI(int weight, int height) {
        // BMI 계산 로직
        return weight / height;
    }

    private void updateDatabase(String id, int weight, int height) throws SQLException {
        // MemberInfoDAO를 사용하여 데이터베이스 업데이트 로직 수행
        MemberInfoDAO dao = new MemberInfoDAO(getServletContext());
        dao.updateMemberInfo(id, weight, height);
    }
}