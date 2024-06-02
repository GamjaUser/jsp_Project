package Controller;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.MemberInfoDAO;
import DTO.MemberDTO;
import DTO.MemberInfoDTO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

@WebServlet("/profile/updateBMI")
public class BMIUpdateController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        MemberDTO memberdto = (MemberDTO) session.getAttribute("member");
        String id = memberdto.getId();
        System.out.println(id);
        
        int weight = Integer.parseInt(request.getParameter("weight"));
        int height = Integer.parseInt(request.getParameter("height"));

        double heightInMeters = height / 100.0;
        double bmi = weight / (heightInMeters * heightInMeters);
        bmi = Math.round(bmi * 10.0) / 10.0;
        String bmiStatus;

        if (bmi < 18.5) {
            bmiStatus = "저체중";
        } else if (bmi < 24.9) {
            bmiStatus = "정상 체중";
        } else if (bmi < 29.9) {
            bmiStatus = "과체중";
        } else {
            bmiStatus = "비만";
        }

        Date currentDate = new Date();

        MemberInfoDTO dto = new MemberInfoDTO();
        dto.setId(id);
        dto.setWeight(weight);
        dto.setHeight(height);
        dto.setSdate(new java.sql.Date(currentDate.getTime()));

        MemberInfoDAO memberDAO = new MemberInfoDAO(getServletContext());
        try {
            memberDAO.updateMember(dto);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        session.setAttribute("dtoinfo", dto);
        session.setAttribute("bmi2", bmi);
        session.setAttribute("bmiStatus2", bmiStatus);

        response.sendRedirect(request.getContextPath() + "/HealthCareLife/profile.do");
    }
}
