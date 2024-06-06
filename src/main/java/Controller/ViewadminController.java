package Controller;

import java.io.IOException;
import java.util.List;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.ProductDAO;
import DTO.MemberDTO;
import DTO.ProductDTO;
import model2.mvcboard.MVCBoardCommentDAO;
import model2.mvcboard.MVCBoardCommentDTO;
import model2.mvcboard.MVCBoardDAO;
import model2.mvcboard.MVCBoardDTO;

@WebServlet("/adminPage.do")
public class ViewadminController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("adminController");
		
		HttpSession session = req.getSession();
		MemberDTO mdto = (MemberDTO) session.getAttribute("member");
		
		
		System.out.println("dto : " + mdto);
		if(mdto == null || mdto.getLevel() != 0) {
			System.out.println("check");
			resp.sendRedirect("/login&profile/login.jsp");
        	return;
		}
		
		//Select를 위한 dao
		ProductDAO pdao = new ProductDAO();
		MVCBoardDAO bdao = new MVCBoardDAO();
		MVCBoardCommentDAO bcdao = new MVCBoardCommentDAO();
		
		//정보들을 담을 리스트
		List<ProductDTO> pList = pdao.listProduct();
		List<MVCBoardDTO> bList = bdao.selectListPage();
		List<MVCBoardCommentDTO> bcList = bcdao.selectComments();
		
		System.out.println("board : " + bList);
		
		req.setAttribute("products", pList);
		req.setAttribute("boards", bList);
		req.setAttribute("comments", bcList);

        req.getRequestDispatcher("/adminPage.jsp").forward(req, resp);
	}

}
