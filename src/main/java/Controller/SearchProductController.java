package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import DAO.ProductDAO;
import DTO.MemberDTO;
import DTO.ProductDTO;

@WebServlet("/shopping/searchProductName.do")
public class SearchProductController extends HttpServlet{
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Search");
		HttpSession session = req.getSession(); 
		MemberDTO mdto = (MemberDTO) session.getAttribute("member");
		
		String name = req.getParameter("name");
		System.out.println("name : " + name);
		
		
		//세션 검사
//		if(mdto == null) {
//        	resp.sendRedirect("/login&profile/login.jsp");
//        	return;
//		}
		
		ProductDAO dao = new ProductDAO();
		
		List<ProductDTO> products = dao.searchProduct(name);
		
		// JSON으로 변환하여 응답합니다.
	    ObjectMapper objectMapper = new ObjectMapper();
	    String jsonResponse = objectMapper.writeValueAsString(products);

	    resp.setContentType("application/json");
	    resp.setCharacterEncoding("UTF-8");
	    resp.getWriter().write(jsonResponse);

	}

}
