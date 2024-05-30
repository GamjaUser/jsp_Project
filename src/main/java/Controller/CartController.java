package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.CartDAO;
import DTO.ProductCartDTO;

@WebServlet("/shoppping/cartMain.do")
public class CartController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CartDAO dao = new CartDAO();
		System.out.println(1);
		HttpSession session = req.getSession(); //세션 만들기
		
//		memberDTO dto = new memberDTO(); //memberDTO 생성

//		session.setAttribute("user", UserDto);
//		dto = (memberDTO) session.getAttribute("member"); //user 세션 가져오기
		
//		String id = dto.getId(); //세션에서 유저 받기
		
//		List<ProductCartDTO> products = dao.selectList(id); //세션용
		List<ProductCartDTO> products = dao.selectList("user01");
		dao.close();
		
//		System.out.println(products);
		
		req.setAttribute("products", products);
        req.getRequestDispatcher("/shopping/cartMain.jsp").forward(req, resp);
	}
}
