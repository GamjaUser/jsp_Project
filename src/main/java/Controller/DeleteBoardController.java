package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.ProductDAO;
import DTO.MemberDTO;
import model2.mvcboard.MVCBoardDAO;

public class DeleteBoardController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		MemberDTO mdto = (MemberDTO) session.getAttribute("member");
		
		//관리자인지 확인
		if(mdto.getId() != "admin" || mdto.getPassword() != "admin") {
        	resp.sendRedirect("/login&profile/login.jsp");
        	return;
		}
		
		String id = mdto.getId();
		MVCBoardDAO dao = new MVCBoardDAO();
		
		String idx = req.getParameter("idx");
		
		int result = dao.deletePost(idx);
		dao.close();
		
		//JSON 작성
	}
}
