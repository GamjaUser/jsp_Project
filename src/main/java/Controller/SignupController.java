package Controller;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.MemberDAO;
import DAO.MemberInfoDAO;
import DTO.MemberDTO;
import DTO.MemberInfoDTO;

@WebServlet("/login/signup.do")
public class SignupController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        int age = Integer.parseInt(request.getParameter("age"));
        String gender = request.getParameter("gender");
        int height = Integer.parseInt(request.getParameter("height"));
        int weight = Integer.parseInt(request.getParameter("weight"));
        int exerciseEXP = Integer.parseInt(request.getParameter("exerciseEXP"));
        int goals = Integer.parseInt(request.getParameter("goals"));
        int level = Integer.parseInt(request.getParameter("level"));
        String sdateString = request.getParameter("sdate");
     // sdateString 변환
     SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
     Date utilDate = null;
     try {
         utilDate = dateFormat.parse(sdateString);
     } catch (ParseException e) {
         e.printStackTrace();
     }
     java.sql.Date sdate = new java.sql.Date(utilDate.getTime());

        MemberDTO member = new MemberDTO();
        member.setId(id);
        member.setPassword(password);
        member.setAge(age);
        member.setGender(gender);
        member.setExerciseEXP(exerciseEXP);
        member.setGoals(goals);
        member.setLevel(level);

        MemberInfoDTO memberInfo = new MemberInfoDTO();
        memberInfo.setId(id);
        memberInfo.setHeight(height);
        memberInfo.setWeight(weight);
        memberInfo.setSdate(sdate);

        MemberDAO memberDAO = new MemberDAO(getServletContext());
        MemberInfoDAO memberInfoDAO = new MemberInfoDAO(getServletContext());

        int memberSuccess = memberDAO.insertMember(member);
        int memberInfoSuccess = memberInfoDAO.insertMemberInfo(memberInfo);

        response.setContentType("text/plain");
        if (memberSuccess == 1 && memberInfoSuccess == 1) {
            response.getWriter().write("success");
        } else {
            response.getWriter().write("failure");
        }
    }
}