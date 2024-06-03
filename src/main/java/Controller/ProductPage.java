package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.ProductDAO;
import DTO.MemberDTO;
import DTO.ProductDTO;

@WebServlet("/shpping/ProductPage.do")
public class ProductPage extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
			
		MemberDTO mdto = (MemberDTO) session.getAttribute("member");
		
		//세션 검사
		if(mdto == null) {
        	resp.sendRedirect("/login&profile/login.jsp");
        	return;
		}
		
		ProductDAO dao = new ProductDAO();
		String productIdstr = req.getParameter("productId"); 
		int productId = 0;
		
		System.out.println("productID : " + productIdstr);
		if (productIdstr != null) {
            try {
                productId = Integer.parseInt(productIdstr);
            } catch (NumberFormatException e) {
                // 예외 처리
                e.printStackTrace();
            }
        }		
		ProductDTO product = dao.selectProduct(productId);
		
		System.out.println("comment : " + product.getComment());
		req.setAttribute("product", product);
        req.getRequestDispatcher("/shopping/product_page.jsp").forward(req, resp);
	}
}
