package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import DAO.CartDAO;
import DTO.CartDTO;
import DTO.MemberDTO;


@WebServlet("/removeProduct.do")
public class RemoveProduct extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	System.out.println("remove");
    	
    	HttpSession session =  req.getSession(); //세션 생성
    	
    	MemberDTO mdto = (MemberDTO) session.getAttribute("member"); //세션 ID 받아오기
    	String productIdStr = req.getParameter("productId"); //request한 productId 받기
    	
    	
    	//세션 검사
        if(mdto == null) {
        	System.out.println(11);
            resp.sendRedirect("/login&profile/login.jsp");
            return;
        }
       
    	CartDAO cdao = new CartDAO();
    	
    	int productId = Integer.parseInt(productIdStr); 
    	
    	System.out.println("productId : " + productId);

    	String memberId = mdto.getId();
    	int result = cdao.delectCart(productId, memberId);
    	cdao.close();
    	
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