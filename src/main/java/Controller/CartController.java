package Controller;

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
import DTO.MemberDTO;
import DTO.ProductCartDTO;

@WebServlet("/shopping/cartMain.do")
public class CartController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CartDAO dao = new CartDAO();
		HttpSession session = req.getSession(); //���� �����
		
		if(session == null) {
			response.sendRedirect(request.getContextPath() + "/login&profile/login.jsp");
		}
		
		MemberDTO dto = (MemberDTO) session.getAttribute("member"); //memberDTO ����

		String id = dto.getId(); //���ǿ��� ���� �ޱ�
		
		List<ProductCartDTO> products = dao.selectList(id); //���ǿ�
//		List<ProductCartDTO> products = dao.selectList("user01");
		dao.close();
		System.out.println("cart");
		
//		System.out.println(products);
		
		req.setAttribute("products", products);
        req.getRequestDispatcher("/shopping/cartMain.jsp").forward(req, resp);
	}
}
