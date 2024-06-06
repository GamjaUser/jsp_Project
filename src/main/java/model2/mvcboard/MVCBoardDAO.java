package model2.mvcboard;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import DTO.MemberDTO;
import common.DBConnPool;

public class MVCBoardDAO extends DBConnPool {
    public MVCBoardDAO() {
        super();
    }

    // 검색 조건에 맞는 게시물의 개수를 반환합니다.
    public int selectCount(Map<String, Object> map) {
        int totalCount = 0;
        String query = "SELECT COUNT(*) FROM mvcboard";
        if (map.get("searchWord") != null) {
            query += " WHERE " + map.get("searchField") + " "
                   + " LIKE '%" + map.get("searchWord") + "%'";
        }
        try {
            pstmt = conn.prepareStatement(query);
            rs = pstmt.executeQuery(query);
            rs.next();
            totalCount = rs.getInt(1);
        }
        catch (Exception e) {
            System.out.println("게시물 카운트 중 예외 발생");
            e.printStackTrace();
        }
        return totalCount;
    }


    public List<MVCBoardDTO> selectListPage(Map<String, Object> map) {
        List<MVCBoardDTO> board = new Vector<MVCBoardDTO>();
        String query = "SELECT * FROM ("
                     + " SELECT Tb.*, ROWNUM rNum FROM ("
                     + " SELECT * FROM mvcboard ";

        if (map.get("searchWord") != null) {
            query += " WHERE " + map.get("searchField")
                   + " LIKE '%" + map.get("searchWord") + "%' ";
        }

        query += " ORDER BY idx DESC ) Tb"
               + " )"
               + " WHERE rNum BETWEEN ? AND ?";

        try {
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, (int) map.get("start"));
            pstmt.setInt(2, (int) map.get("end"));
            rs = pstmt.executeQuery();

            while (rs.next()) {
                MVCBoardDTO dto = new MVCBoardDTO();
                dto.setIdx(rs.getString(1));
                dto.setName(rs.getString(9));
                dto.setTitle(rs.getString(2));
                dto.setContent(rs.getString(3));
                dto.setPostdate(rs.getDate(4));
                dto.setOfile(rs.getString(5));
                dto.setSfile(rs.getString(6));
                dto.setDowncount(rs.getInt(7));
                dto.setVisitcount(rs.getInt(8));

                board.add(dto);
            }
        }
        catch (Exception e) {
            System.out.println("게시물 조회 중 예외 발생");
            e.printStackTrace();
        }
        return board;
    }
    
    //모든 게시판 조회
    public List<MVCBoardDTO> selectListPage(){
    	List<MVCBoardDTO> boardList = new Vector<MVCBoardDTO>();
    	
    	String sql = "SELECT * FROM board";
    	
    	try(PreparedStatement pstmt = conn.prepareStatement(sql);){
    		
    		rs = pstmt.executeQuery();
    		
    		while(rs.next()) {
    			MVCBoardDTO dto = new MVCBoardDTO();
    			
    			dto.setIdx(rs.getString("idx"));
    			dto.setTitle(rs.getNString("title"));
    			dto.setName(rs.getString("name"));
    			dto.setContent(rs.getString("content"));
    			
    			boardList.add(dto);
    		}
    		
    	}catch (SQLException e) {
			// TODO: handle exception
    		System.out.println("Ex(selectList : " + e.getMessage());
		}
    	
    	return boardList;
    }
    

    // 게시글 데이터를 받아 DB에 추가합니다(파일 업로드 지원).
    public int insertWrite(MVCBoardDTO dto, MemberDTO mdto) {
        int result = 0;
        try {
            String query = "INSERT INTO mvcboard ( "
                         + " idx, id2, title, content, ofile, sfile) "
                         + " VALUES ( "
                         + " seq_board_num.NEXTVAL,?,?,?,?,?)";
            System.out.println(dto);
            System.out.println(mdto);
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, mdto.getId());
            pstmt.setString(2, dto.getTitle());
            pstmt.setString(3, dto.getContent());
            pstmt.setString(4, dto.getOfile());
            pstmt.setString(5, dto.getSfile());
            result = pstmt.executeUpdate();
        }
        catch (Exception e) {
            System.out.println("게시물 입력 중 예외 발생");
            e.printStackTrace();
        }
        return result;
    }

    // 주어진 일련번호에 해당하는 게시물을 DTO에 담아 반환합니다.
    public MVCBoardDTO selectView(String idx) {
        MVCBoardDTO dto = new MVCBoardDTO();  // DTO 객체 생성
        String query = "SELECT * FROM mvcboard WHERE idx=?";  // 쿼리문 템플릿 준비
        try {
            pstmt = conn.prepareStatement(query);  // 쿼리문 준비
            pstmt.setString(1, idx);  // 인파라미터 설정
            rs = pstmt.executeQuery();  // 쿼리문 실행

            if (rs.next()) {  // 결과를 DTO 객체에 저장
                dto.setIdx(rs.getString(1));
                dto.setName(rs.getString(9));
                dto.setTitle(rs.getString(2));
                dto.setContent(rs.getString(3));
                dto.setPostdate(rs.getDate(4));
                dto.setOfile(rs.getString(5));
                dto.setSfile(rs.getString(6));
                dto.setDowncount(rs.getInt(7));
                dto.setVisitcount(rs.getInt(8));
            }
        }
        catch (Exception e) {
            System.out.println("게시물 상세보기 중 예외 발생");
            e.printStackTrace();
        }
        return dto;  // 결과 반환
    }

    // 주어진 일련번호에 해당하는 게시물의 조회수를 1 증가시킵니다.
    public void updateVisitCount(String idx) {
        String query = "UPDATE mvcboard SET "
                     + " visitcount=visitcount+1 "
                     + " WHERE idx=?"; 
        try {
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, idx);
            pstmt.executeQuery();
        }
        catch (Exception e) {
            System.out.println("게시물 조회수 증가 중 예외 발생");
            e.printStackTrace();
        }
    }

    // 다운로드 횟수를 1 증가시킵니다.
    public void downCountPlus(String idx) {
        String sql = "UPDATE mvcboard SET "
                + " downcount=downcount+1 "
                + " WHERE idx=? "; 
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, idx);
            pstmt.executeUpdate();
        }
        catch (Exception e) {}
    }

    // 지정한 일련번호의 게시물을 삭제합니다.
    public int deletePost(String idx) {
        int result = 0;
        String query = "DELETE FROM mvcboard"
                + " WHERE idx=?"; 
	    try {
	        pstmt = conn.prepareStatement(query);
	        pstmt.setString(1, idx);
	        result = pstmt.executeUpdate();
	    }
	    catch (Exception e) {
	        System.out.println("게시물 삭제 중 예외 발생");
	        e.printStackTrace();
	    }
        return result;
    }
    
    // session 유저 검사
    public int deletePost(String idx, String writer) {
        int result = 0;
        String query = "DELETE FROM mvcboard"
                + " WHERE idx=? and id2=?"; 
	    try {
	        pstmt = conn.prepareStatement(query);
	        pstmt.setString(1, idx);
	        pstmt.setString(2, writer);
	        result = pstmt.executeUpdate();
	    }
	    catch (Exception e) {
	        System.out.println("게시물 삭제 중 예외 발생");
	        e.printStackTrace();
	    }
        return result;
    }
    //
    

    // 게시글 데이터를 받아 DB에 저장되어 있던 내용을 갱신합니다(파일 업로드 지원).
    public int updatePost(MVCBoardDTO dto) {
        int result = 0;
        System.out.println("name : " + dto.getName());
        try {
            // 쿼리문 템플릿 준비
            String query = "UPDATE mvcboard"
                         + " SET title=?, content=?, ofile=?, sfile=? "
                         + " WHERE idx=? and id2=?";

            // 쿼리문 준비
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, dto.getTitle());
            pstmt.setString(2, dto.getContent());
            pstmt.setString(3, dto.getOfile());
            pstmt.setString(4, dto.getSfile());
            pstmt.setString(5, dto.getIdx());
            pstmt.setString(6, dto.getName());

            // 쿼리문 실행
            result = pstmt.executeUpdate();
        }
        catch (Exception e) {
            System.out.println("게시물 수정 중 예외 발생");
            e.printStackTrace();
        }
        return result;
    }   
}
