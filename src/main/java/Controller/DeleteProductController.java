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


@WebServlet("/deleteProduct.do")
public class DeleteProductController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		MemberDTO mdto = (MemberDTO) session.getAttribute("member");
		
		//관리자인지 확인
		if(mdto.getLevel() != 0) {
        	resp.sendRedirect("/login&profile/login.jsp");
        	return;
		}
		
		String id = mdto.getId();
		ProductDAO dao = new ProductDAO();
		
		String productId= req.getParameter("productId");
		System.out.println("productid : " + productId);
		
		boolean result = dao.deleteProduct(productId);
		dao.close();
		
		System.out.println("result : "+ result);
		JSONObject responseJson = new JSONObject();
		  if (result) {
	            responseJson.put("success", true);
	            resp.setContentType("application/json");
	            resp.getWriter().write(responseJson.toString());
	        }
		//JSON 작성
		
	}
}
