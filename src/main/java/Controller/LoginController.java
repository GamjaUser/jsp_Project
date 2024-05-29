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
        
        MemberDAO member_user = new MemberDAO(getServletContext());
        MemberInfoDAO memberinfo_user = new MemberInfoDAO(getServletContext()); 
        String result = memberDAO.memberLogin(member);

        response.setContentType("text/plain");
        if (result.equals("success")) {
            response.getWriter().write("success");
            
         // 로그인 성공 시 세션에 사용자 정보 저장
            HttpSession session = request.getSession();
            
            MemberDTO member_profile = member_user.selectProfileView(id); // 사용자의 정보를 가져옴
            MemberInfoDTO memberinfo_profile = memberinfo_user.selectProfileView_info(id);
            session.setAttribute("member", member_profile);
            session.setAttribute("member_info", memberinfo_profile);
        } else if(result.equals("fail")) {
            response.getWriter().write("fail");
        }
    }
}
