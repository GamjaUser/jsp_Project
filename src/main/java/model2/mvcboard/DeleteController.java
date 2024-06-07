package model2.mvcboard;

//import java.io.File;
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//import javax.servlet.ServletContext;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import com.oreilly.servlet.MultipartRequest;
//
//import fileupload.FileUtil;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DTO.MemberDTO;

@WebServlet("/mvcboard/delete.do")
public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// session 검사
		int result = 0;
		
    	HttpSession session = req.getSession();
    	MemberDTO mdto = (MemberDTO) session.getAttribute("member");
        
        if(mdto == null) {
        	resp.sendRedirect("/login&profile/login.jsp");
        	return;
        }
        //
        
		String idx = req.getParameter("idx");
		MVCBoardDAO dao = new MVCBoardDAO();
		
		// session 검사
        String writer = mdto.getId();
   
        result = dao.deletePost(idx, writer);      	
        
		
		// 게시물 삭제 후, 삭제된 행의 수를 반환받습니다.
        dao.close();

        // 게시물 삭제 결과에 따른 처리 로직을 추가할 수 있습니다.
        // 예를 들어, result가 0보다 크면 성공적으로 삭제된 것으로 판단할 수 있습니다.

        // 성공적으로 삭제되었다면 게시판 목록 페이지로 리다이렉션합니다.
        if(result > 0) {
            resp.sendRedirect("../mvcboard/list.do");
        } else {
            // 삭제에 실패했다면 적절한 오류 메시지를 사용자에게 보여주는 처리를 할 수 있습니다.
            // 여기서는 단순화를 위해 바로 목록 페이지로 리다이렉션하겠습니다.
        	resp.sendRedirect("../mvcboard/list.do");
        }
    }
}