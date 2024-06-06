package Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import DTO.MemberDTO;


@WebServlet("/calender/calender.do")
public class CalenderController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("viewProduct");
		
		//세션 생성
		HttpSession session = req.getSession();
		MemberDTO mdto = (MemberDTO) session.getAttribute("member");
		
		//세션 검사
		if(mdto == null) {
        	resp.sendRedirect("/login&profile/login.jsp");
        	return;
		}
		
		req.setAttribute("dto", mdto);

		req.getRequestDispatcher("/calender/calender.jsp").forward(req, resp);
    }
}