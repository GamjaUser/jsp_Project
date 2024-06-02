package Controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import DAO.CartDAO;
import DTO.MemberDTO;


@WebServlet("/shopping/Cartupdate.do")
public class CartUpdateController extends HttpServlet{

//	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int result;
		
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
		
		//세션에 저장된 유저 아이디 저장
		String id = mdto.getId();
		System.out.println(id);

		//productId 저장
		String productIdstr = req.getParameter("productId"); 
		int productId = Integer.parseInt(productIdstr);

		System.out.println("productId : " + productId);
		
		//파라미터 2개일떄
		if(parameterCnt == 2) { 
			String cntstr = req.getParameter("cnt");
			
			int cnt = Integer.parseInt(cntstr);
			
			System.out.println("cnt : " + cnt);

			result = cdao.insertCart(id, productId, cnt);

		}
		//파라미터 1개일떄
		else {
			result = cdao.insertCart(id, productId);
		}
		
        // JSON 응답 생성
        JSONObject responseJson = new JSONObject();
        if (result == 1) {
            responseJson.put("success", true);
            resp.setContentType("application/json");
            resp.getWriter().write(responseJson.toString());
        } else {
            responseJson.put("success", false);
            resp.setContentType("application/json");
            resp.getWriter().write(responseJson.toString());
        }
		
	}	
}
