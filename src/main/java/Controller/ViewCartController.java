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
public class ViewCartController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("ViewCart");
		
		CartDAO dao = new CartDAO();
		HttpSession session = req.getSession(); 

        MemberDTO mdto = (MemberDTO) session.getAttribute("member");
        
        //세션 검사
        if(mdto == null) {
        	
        	resp.sendRedirect("/login&profile/login.jsp");
        	return;
        }
        
		String id = mdto.getId(); //memberDTO에 저장된 ID 가져온다
		
		System.out.println("id : " + id);
		
		List<ProductCartDTO> products = dao.selectList(id); 
		dao.close();
		
		System.out.println("cart");
		
		req.setAttribute("products", products);
        req.getRequestDispatcher("/shopping/cartMain.jsp").forward(req, resp);
	}
}
