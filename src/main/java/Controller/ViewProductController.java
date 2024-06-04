package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.ProductDAO;
import DTO.MemberDTO;
import DTO.ProductDTO;

@WebServlet("/shopping/shopMain.do")
public class ViewProductController extends HttpServlet{
	
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
		
		ProductDAO dao = new ProductDAO();
		
		//모든 상품 정보 list에 저장
		List<ProductDTO> products = dao.listProduct();
		dao.close();
		
		
		
		
		System.out.println(products);
		req.setAttribute("products", products);
        req.getRequestDispatcher("/shopping/shopMain.jsp").forward(req, resp);
	}
}
