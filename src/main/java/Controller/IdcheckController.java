package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.MemberDAO;

import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/login/idCheck.do")
public class IdcheckController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("check");
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");

        MemberDAO memberDAO = new MemberDAO();
        
        try {
            boolean isExist = memberDAO.idCheck(id);
            response.setContentType("text/plain");
            PrintWriter out = response.getWriter();
            if (isExist) {
                out.print("unavailable"); // 중복된 아이디
            } else {
                out.print("available"); // 사용 가능한 아이디
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // 예외 처리: 데이터베이스 오류 등
            // 여기서는 간단하게 에러 메시지를 출력하고 있음
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
}
