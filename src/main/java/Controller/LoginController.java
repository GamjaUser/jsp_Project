package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import DAO.MemberDAO;
import DAO.MemberInfoDAO;
import DTO.MemberDTO;
import DTO.MemberInfoDTO;

@WebServlet("/login/login.do")
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        String password = request.getParameter("password");

        MemberDTO member = new MemberDTO();
        member.setId(id);
        member.setPassword(password);

        MemberDAO memberDAO = new DAO.MemberDAO(getServletContext());
        
        MemberDAO user = new MemberDAO(getServletContext());
        MemberInfoDAO user_info = new MemberInfoDAO(getServletContext()); 
        String result = memberDAO.memberLogin(member);

        response.setContentType("text/plain");
        if (result.equals("success")) {
            response.getWriter().write("success");
            
         // 로그인 성공 시 세션에 사용자 정보 저장
            HttpSession session = request.getSession();
            
            MemberDTO member_profile = user.selectProfileView(id); // 사용자의 정보를 가져옴
            MemberInfoDTO memberinfo_profile = user_info.selectProfileView_info(id);
            session.setAttribute("member", member_profile);
            session.setAttribute("member_info", memberinfo_profile);
        } else {
            response.getWriter().write("fail");
        }
    }
}
