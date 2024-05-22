package login;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DTO.MemberInfoDTO;

public class MemberInfoDAO {
    private Connection connection;

    // 생성자: 데이터베이스 연결을 초기화합니다.
    public MemberInfoDAO(Connection connection) {
        this.connection = connection;
    }

    // 새로운 회원 정보를 member_info 테이블에 삽입하는 메서드
    public void insertMemberInfo(MemberInfoDTO memberInfo) throws SQLException {
        String query = "INSERT INTO member_info (id, Weight, height, sdate) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, memberInfo.getId());
            pstmt.setInt(2, memberInfo.getWeight());
            pstmt.setInt(3, memberInfo.getHeight());
            pstmt.setDate(4, memberInfo.getSdate());
            pstmt.executeUpdate();
        }catch(Exception e) {
        	System.out.println("Exception[insertMemberInfo]: "+ e.getMessage());
        }
    }

    // ID로 특정 회원 정보를 조회하는 메서드
    public MemberInfoDTO getMemberInfoById(String id) throws SQLException {
        String query = "SELECT * FROM member_info WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    MemberInfoDTO memberInfo = new MemberInfoDTO();
                    memberInfo.setId(rs.getString("id"));
                    memberInfo.setWeight(rs.getInt("Weight"));
                    memberInfo.setHeight(rs.getInt("height"));
                    memberInfo.setSdate(rs.getDate("sdate"));
                    return memberInfo;
                }
            }catch(Exception e) {
            	System.out.println("Exception[getMemberInfoById]: "+ e.getMessage());
            }
        }
        return null;
    }

    // 모든 회원 정보를 조회하는 메서드
    public List<MemberInfoDTO> getAllMemberInfo() throws SQLException {
        List<MemberInfoDTO> memberInfos = new ArrayList<>();
        String query = "SELECT * FROM member_info";
        try (PreparedStatement pstmt = connection.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                MemberInfoDTO memberInfo = new MemberInfoDTO();
                memberInfo.setId(rs.getString("id"));
                memberInfo.setWeight(rs.getInt("Weight"));
                memberInfo.setHeight(rs.getInt("height"));
                memberInfo.setSdate(rs.getDate("sdate"));
                memberInfos.add(memberInfo);
            }
        }catch(Exception e) {
        	System.out.println("Exception[getAllMemberInfo]: "+ e.getMessage());
        }
        return memberInfos;
    }

    // 회원 정보를 업데이트하는 메서드
    public void updateMemberInfo(MemberInfoDTO memberInfo) throws SQLException {
        String query = "UPDATE member_info SET Weight = ?, height = ?, sdate = ? WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, memberInfo.getWeight());
            pstmt.setInt(2, memberInfo.getHeight());
            pstmt.setDate(3, memberInfo.getSdate());
            pstmt.setString(4, memberInfo.getId());
            pstmt.executeUpdate();
        }catch(Exception e) {
        	System.out.println("Exception[updateMemberInfo]: "+ e.getMessage());
        }
    }

    // 특정 ID의 회원 정보를 삭제하는 메서드
    public void deleteMemberInfo(String id) throws SQLException {
        String query = "DELETE FROM member_info WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, id);
            pstmt.executeUpdate();
        }catch(Exception e) {
        	System.out.println("Exception[deleteMemberInfo]: "+ e.getMessage());
        }
    }
}
