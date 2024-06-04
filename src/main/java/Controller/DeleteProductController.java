package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.ProductDAO;
import DTO.MemberDTO;

public class DeleteProductController extends HttpServlet{

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
		ProductDAO dao = new ProductDAO();
		
		String productIdStr = req.getParameter("productid");
		int productId = Integer.parseInt(productIdStr);
		
		int result = dao.deleteProduct(productId, id);
		dao.close();
		
		//JSON 작성
		
	}
}
