package login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import login.MemberDAO;
import DTO.MemberDTO;

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

        MemberDAO memberDAO = new MemberDAO(getServletContext());
        String result = memberDAO.memberLogin(member);

        response.setContentType("text/plain");
        if (result.equals("success")) {
            response.getWriter().write("success");
        } else {
            response.getWriter().write("fail");
        }
    }
}
