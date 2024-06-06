package model2.mvcboard;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import DTO.MemberDTO;

@WebServlet("/mvcboard/comments.do")
public class CommentsController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    MVCBoardCommentDAO dao = new MVCBoardCommentDAO();
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/html;charset=UTF-8");
        String boardIdx = request.getParameter("boardIdx");
        
        // session 검사
    	HttpSession session = request.getSession();
    	MemberDTO mdto = (MemberDTO) session.getAttribute("member");
        
        if(mdto == null) {
        	response.sendRedirect("/login&profile/login.jsp");
        	return;
        }
        
        String id = mdto.getId();
		request.setAttribute("id", id);
        //
        
        List<MVCBoardCommentDTO> comments = dao.selectComments(boardIdx);
        request.setAttribute("comments", comments);
        request.setAttribute("boardIdx", boardIdx);
        
        System.out.println("doGet의 boardIdx : " + boardIdx);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/login&profile/free_board_comments.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	// session 검사		
    	HttpSession session = request.getSession();
    	MemberDTO mdto = (MemberDTO) session.getAttribute("member");
        
        if(mdto == null) {
        	response.sendRedirect("/login&profile/login.jsp");
        	return;
        }
        //
    	
    	request.setCharacterEncoding("UTF-8");  // 요청 인코딩 설정
        response.setContentType("application/json;charset=UTF-8");
    	System.out.println("Post request received");
        String boardIdx = request.getParameter("boardIdx");
        String name = request.getParameter("name");
        String content = request.getParameter("content");

        MVCBoardCommentDTO dto = new MVCBoardCommentDTO();
        dto.setBoardIdx(Integer.parseInt(boardIdx));
        dto.setName(name);
        dto.setContent(content);

        int result = dao.insertComment(dto);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(new Gson().toJson(result));
    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	// session 검사		
    	HttpSession session = request.getSession();
    	MemberDTO mdto = (MemberDTO) session.getAttribute("member");
        
        if(mdto == null) {
        	response.sendRedirect("/login&profile/login.jsp");
        	return;
        }
        //
    	
    	request.setCharacterEncoding("UTF-8");  // 요청 인코딩 설정
        response.setContentType("application/json;charset=UTF-8");
    	System.out.println("Put request received");
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = request.getReader();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        reader.close();

        JsonObject jsonObject = JsonParser.parseString(sb.toString()).getAsJsonObject();
        int id = jsonObject.get("idx").getAsInt();
        String name = jsonObject.get("name").getAsString();
        String content = jsonObject.get("content").getAsString();
        System.out.println("this is id,name,content" + id + " " + name + " " + content);

        MVCBoardCommentDTO dto = new MVCBoardCommentDTO();
        dto.setIdx(id);
        dto.setName(name);
        dto.setContent(content);

        int result = dao.updateComment(dto);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(new Gson().toJson(result));
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	// session 검사		
    	HttpSession session = request.getSession();
    	MemberDTO mdto = (MemberDTO) session.getAttribute("member");
        
        if(mdto == null) {
        	response.sendRedirect("/login&profile/login.jsp");
        	return;
        }
        //
    	
    	request.setCharacterEncoding("UTF-8");  // 요청 인코딩 설정
        response.setContentType("application/json;charset=UTF-8");
    	System.out.println("DELETE request received");
    	int result = 0;
    	
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = request.getReader();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        reader.close();

        JsonObject jsonObject = JsonParser.parseString(sb.toString()).getAsJsonObject();
//        System.out.println(request.getParameter(jsonObject.get("idx")));
        System.out.println(jsonObject.get("idx"));
        int idx = jsonObject.get("idx").getAsInt();

        // session 검사
        String writer = mdto.getId();
        //관리자 세션 확인
        if(mdto.getLevel() == 0) {
            result = dao.deleteComment(idx);
    	}
        else {
        	result = dao.deleteComment(idx, writer);        	
        }

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(new Gson().toJson(result));
    }
}
