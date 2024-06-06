package model2.mvcboard;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/list.do")
public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	        throws ServletException, IOException {
	    MVCBoardDAO dao = new MVCBoardDAO();
	    Map<String, Object> map = new HashMap<String, Object>();

	    String searchField = req.getParameter("searchField");
	    String searchWord = req.getParameter("searchWord");
	    if (searchWord != null) {
	        map.put("searchField", searchField);
	        map.put("searchWord", searchWord);
	    }

	    int totalCount = dao.selectCount(map);  // 게시물 개수
	    int pageSize = 10;  // 한 페이지에 표시할 게시물 수
	    int blockPage = 5;  // 한 블록당 표시할 페이지 수

	    int pageNum = 1;  // 현재 페이지 번호
	    String pageTemp = req.getParameter("pageNum");
	    if (pageTemp != null && !pageTemp.equals(""))
	        pageNum = Integer.parseInt(pageTemp);

	    int start = (pageNum - 1) * pageSize + 1;
	    int end = pageNum * pageSize;
	    map.put("start", start);
	    map.put("end", end);

	    List<MVCBoardDTO> boardLists = dao.selectListPage(map);  // 게시물 목록 받기
	    dao.close();

	    String pagingStr = PagingUtil.paging(totalCount, pageSize, blockPage, pageNum, "../mvcboard/list.do");

	    map.put("totalCount", totalCount);
	    map.put("pageSize", pageSize);
	    map.put("pageNum", pageNum);

	    req.setAttribute("boardLists", boardLists);
	    req.setAttribute("map", map);
	    req.setAttribute("pagingStr", pagingStr);

	    req.setAttribute("totalCount", totalCount);  // 총 게시물 수를 JSP에 전달

	    req.getRequestDispatcher("/login&profile/free_board_list.jsp").forward(req, resp);
	}

}
