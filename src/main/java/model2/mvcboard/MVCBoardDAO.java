package model2.mvcboard;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Vector;
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
                dto.setName(rs.getString(2));
                dto.setTitle(rs.getString(3));
                dto.setContent(rs.getString(4));
                dto.setPostdate(rs.getDate(5));
                dto.setOfile(rs.getString(6));
                dto.setSfile(rs.getString(7));
                dto.setDowncount(rs.getInt(8));
                dto.setVisitcount(rs.getInt(10));

                board.add(dto);
            }
        }
        catch (Exception e) {
            System.out.println("게시물 조회 중 예외 발생");
            e.printStackTrace();
        }
        return board;
    }

    

    // 게시글 데이터를 받아 DB에 추가합니다(파일 업로드 지원).
    public int insertWrite(MVCBoardDTO dto) {
        int result = 0;
        try {
            String query = "INSERT INTO mvcboard ( "
                         + " idx, name, title, content, ofile, sfile) "
                         + " VALUES ( "
                         + " seq_board_num.NEXTVAL,?,?,?,?,?)";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, dto.getName());
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
                dto.setName(rs.getString(2));
                dto.setTitle(rs.getString(3));
                dto.setContent(rs.getString(4));
                dto.setPostdate(rs.getDate(5));
                dto.setOfile(rs.getString(6));
                dto.setSfile(rs.getString(7));
                dto.setDowncount(rs.getInt(8));
                dto.setVisitcount(rs.getInt(9));
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
                + " WHERE idx=? and writer=?"; 
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
        try {
            // 쿼리문 템플릿 준비
            String query = "UPDATE mvcboard"
                         + " SET title=?, name=?, content=?, ofile=?, sfile=? "
                         + " WHERE idx=?";

            // 쿼리문 준비
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, dto.getTitle());
            pstmt.setString(2, dto.getName());
            pstmt.setString(3, dto.getContent());
            pstmt.setString(4, dto.getOfile());
            pstmt.setString(5, dto.getSfile());
            pstmt.setString(6, dto.getIdx());

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
