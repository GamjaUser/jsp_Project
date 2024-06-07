package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import DAO.ProductDAO;
import DTO.MemberDTO;
import model2.mvcboard.MVCBoardCommentDTO;
import model2.mvcboard.MVCBoardDAO;
import model2.mvcboard.MVCBoardDTO;


@WebServlet("/deleteboard.do")
public class DeleteBoardController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("deleteBoard");
		HttpSession session = req.getSession();
		MemberDTO mdto = (MemberDTO) session.getAttribute("member");
		
		//관리자인지 확인
		if(mdto.getLevel() != 0) {
        	resp.sendRedirect("/login&profile/login.jsp");
        	return;
		}
		
		String id = mdto.getId();
		MVCBoardDAO dao = new MVCBoardDAO();
		
		String boardId = req.getParameter("boardId");
		System.out.println("boardId : " + boardId);
		
		boolean result = dao.deletePost(boardId);
		dao.close();
		
		System.out.println("result !!!!!!!!!!!!!!!!: "+ result);
		
		JSONObject responseJson = new JSONObject();
		  if (result) {
	            responseJson.put("success", true);
	            resp.setContentType("application/json");
	            resp.getWriter().write(responseJson.toString());
	        }
		
	}
}
