package Controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.CartDAO;
import DTO.MemberDTO;


@WebServlet("/shopping/Cartupdate.do")
public class CartUpdateController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cntstr = "1";
		
		CartDAO cdao = new CartDAO();
		
		int parameterCnt= req.getParameterMap().size();
		
		System.out.println("parameterCnt : " + parameterCnt);
		
		
		
		HttpSession session = req.getSession(); 
		
		MemberDTO mdto = (MemberDTO) session.getAttribute("member");
		
		//세션 검사
		if(mdto == null) {
        	resp.sendRedirect("/login&profile/login.jsp");
        	return;
		}
		
		if(parameterCnt == 2) {
			cntstr = req.getParameter("cnt");			
		}

		String prorductIdstr = req.getParameter("productId"); 

		int productId = Integer.parseInt(prorductIdstr);
		int cnt = Integer.parseInt(cntstr);
		
		System.out.println(productId);
		System.out.println(cnt);

		
		String id = mdto.getId();
		System.out.println(id);
		
		int result = cdao.insertCart(id, productId, cnt);
		
	}	
}
