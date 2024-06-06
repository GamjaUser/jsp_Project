package model2.mvcboard;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import common.DBConnPool;

public class MVCBoardCommentDAO extends DBConnPool {

    // 댓글 목록 조회
    public List<MVCBoardCommentDTO> selectComments(String boardIdx) {
        List<MVCBoardCommentDTO> comments = new ArrayList<>();
        String query = "SELECT * FROM mvcboard_comment WHERE board_idx=? ORDER BY comment_idx DESC";
        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, boardIdx);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                MVCBoardCommentDTO dto = new MVCBoardCommentDTO();
                dto.setIdx(rs.getInt("comment_idx"));
                dto.setBoardIdx(rs.getInt("board_idx"));
                dto.setName(rs.getString("id2"));
                dto.setContent(rs.getString("content"));
                dto.setPostdate(rs.getDate("reg_date"));
                comments.add(dto);
            }
            rs.close();
            pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return comments;
    }
    
    // 모든 댓글 조회
    public List<MVCBoardCommentDTO> selectComments() {
        List<MVCBoardCommentDTO> comments = new ArrayList<>();
        String query = "SELECT * FROM mvcboard_comment ORDER BY comment_idx DESC";
        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                MVCBoardCommentDTO dto = new MVCBoardCommentDTO();
                dto.setIdx(rs.getInt("comment_idx"));
                dto.setBoardIdx(rs.getInt("board_idx"));
                dto.setName(rs.getString("id2"));
                dto.setContent(rs.getString("content"));
                dto.setPostdate(rs.getDate("reg_date"));
                comments.add(dto);
            }
            rs.close();
            pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return comments;
    }

    // 댓글 추가
    public int insertComment(MVCBoardCommentDTO dto) {
        int result = 0;
        String getMaxIdxQuery = "SELECT MAX(comment_idx) FROM mvcboard_comment";
        String insertQuery = "INSERT INTO mvcboard_comment (comment_idx, board_idx, id2, content) VALUES (?, ?, ?, ?)";
        try {
            // Get the current maximum idx
            PreparedStatement pstmt = conn.prepareStatement(getMaxIdxQuery);
            ResultSet rs = pstmt.executeQuery();
            int maxIdx = 0;
            if (rs.next()) {
                maxIdx = rs.getInt(1);
            }
            rs.close();
            pstmt.close();

            
            
            System.out.println(dto);
            // Insert new comment with incremented idx
            pstmt = conn.prepareStatement(insertQuery);
            pstmt.setInt(1, maxIdx + 1);
            pstmt.setInt(2, dto.getBoardIdx());
            pstmt.setString(3, dto.getName());
            pstmt.setString(4, dto.getContent());
            result = pstmt.executeUpdate();
            pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    // 댓글 수정
    public int updateComment(MVCBoardCommentDTO dto) {
        int result = 0;
        String query = "UPDATE mvcboard_comment SET content=? WHERE comment_idx=? and id2=?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, dto.getContent());
            pstmt.setInt(2, dto.getIdx());
            pstmt.setString(3, dto.getName());
            result = pstmt.executeUpdate();
            pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    // 관리자 댓글 삭제
    public int deleteComment(int idx) {
        int result = 0;
        String query = " delete from mvcboard_comment where comment_idx = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, idx);
            result = pstmt.executeUpdate();
            pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    // session 유저 검사
    // 유저 댓글 삭제
    public int deleteComment(int idx, String id2) {
        int result = 0;
        String query = " delete from mvcboard_comment where comment_idx = ? and id2 = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, idx);
            pstmt.setString(2, id2);
            result = pstmt.executeUpdate();
            pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    //
}
