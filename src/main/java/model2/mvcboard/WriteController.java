package model2.mvcboard;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;

import DTO.MemberDTO;
import fileupload.FileUtil;

public class WriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
		
		// session 검사		
    	HttpSession session = req.getSession();
    	MemberDTO mdto = (MemberDTO) session.getAttribute("member");
        
        if(mdto == null) {
        	resp.sendRedirect("/login&profile/login.jsp");
        	return;
        }
        //
        
        String id = mdto.getId();
		req.setAttribute("id", id);
        
		System.out.println("WriteController is called(GET)");
//		resp.sendRedirect("/14MVCBoard/Write.jsp");
		req.getRequestDispatcher("/login&profile/free_board_write.jsp").forward(req, resp);
		
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
    	
    	// session 검사		
    	HttpSession session = req.getSession();
    	MemberDTO mdto = (MemberDTO) session.getAttribute("member");
        
        if(mdto == null) {
        	resp.sendRedirect("/login&profile/login.jsp");
        	return;
        }
        //
    	
        // 1. 파일 업로드 처리 =============================
        // 업로드 디렉터리의 물리적 경로 확인
        String saveDirectory = req.getServletContext().getRealPath("/Uploads");
        System.out.println(saveDirectory);
        saveDirectory = "C:\\Users\\whwog\\OneDrive\\바탕 화면\\js\\jsp_Project\\src\\main\\webapp\\Uploads";

        // 초기화 매개변수로 설정한 첨부 파일 최대 용량 확인
        ServletContext application = getServletContext();
        int maxPostSize = Integer.parseInt(application.getInitParameter("maxPostSize"));

        // 파일 업로드
        MultipartRequest mr = FileUtil.uploadFile(req, saveDirectory, maxPostSize);
        System.out.println(mr);
        if (mr == null) {
            // 파일 업로드 실패
            //JSFunction.alertLocation(resp, "첨부 파일이 제한 용량을 초과합니다.",
                                     //"../mvcboard/write.do");  
        	System.out.println("첨부 파일이 제한 용량을 초과합니다.");
            return;
        }

        // 2. 파일 업로드 외 처리 =============================
        // 폼값을 DTO에 저장
        MVCBoardDTO dto = new MVCBoardDTO(); 
        dto.setName(mr.getParameter("name"));
        dto.setTitle(mr.getParameter("title"));
        dto.setContent(mr.getParameter("content"));
        
        // 원본 파일명과 저장된 파일 이름 설정
        String fileName = mr.getFilesystemName("ofile");
        if (fileName != null) {
            // 첨부 파일이 있을 경우 파일명 변경
            // 새로운 파일명 생성
            String now = new SimpleDateFormat("yyyyMMdd_HmsS").format(new Date());
            String ext = fileName.substring(fileName.lastIndexOf("."));
            String newFileName = now + ext;

            // 파일명 변경
            File oldFile = new File(saveDirectory + File.separator + fileName);
            File newFile = new File(saveDirectory + File.separator + newFileName);
            oldFile.renameTo(newFile);
            
            dto.setOfile(fileName);  // 원래 파일 이름
            dto.setSfile(newFileName);  // 서버에 저장된 파일 이름
        }

        // DAO를 통해 DB에 게시 내용 저장
        MVCBoardDAO dao = new MVCBoardDAO();
        int result = dao.insertWrite(dto, mdto);
        dao.close();

        // 성공 or 실패?
        if (result == 1) {  // 글쓰기 성공
            resp.sendRedirect("../mvcboard/list.do");
        }
        else {  // 글쓰기 실패
            resp.sendRedirect("../mvcboard/write.do");
        }
    }}
