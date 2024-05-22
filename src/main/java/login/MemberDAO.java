package login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DTO.MemberDTO;

public class MemberDAO {
    private Connection connection;

    // 생성자: 데이터베이스 연결을 초기화합니다.
    public MemberDAO(Connection connection) {
        this.connection = connection;
    }

    // 새로운 회원을 member 테이블에 삽입하는 메서드
    public void insertMember(MemberDTO member) throws SQLException {
        String query = "INSERT INTO member (id, password, gender, age, goals, exerciseEXP, level) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, member.getId());
            pstmt.setString(2, member.getPassword());
            pstmt.setString(3, member.getGender());
            pstmt.setInt(4, member.getAge());
            pstmt.setString(5, member.getGoals());
            pstmt.setInt(6, member.getExerciseEXP());
            pstmt.setInt(7, member.getLevel());
            pstmt.executeUpdate();
        }catch(Exception e) {
        	System.out.println("Exception[insertMember]: "+ e.getMessage());
        }
    }

    // ID로 특정 회원을 조회하는 메서드
    public MemberDTO getMemberById(String id) throws SQLException {
        String query = "SELECT * FROM member WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    MemberDTO member = new MemberDTO();
                    member.setId(rs.getString("id"));
                    member.setPassword(rs.getString("password"));
                    member.setGender(rs.getString("gender"));
                    member.setAge(rs.getInt("age"));
                    member.setGoals(rs.getString("goals"));
                    member.setExerciseEXP(rs.getInt("exerciseEXP"));
                    member.setLevel(rs.getInt("level"));
                    return member;
                }
            }catch(Exception e) {
            	System.out.println("Exception[getMemberById]: "+ e.getMessage());
            }
        }
        return null;
    }

    // 모든 회원 정보를 조회하는 메서드
    public List<MemberDTO> getAllMembers() throws SQLException {
        List<MemberDTO> members = new ArrayList<>();
        String query = "SELECT * FROM member";
        try (PreparedStatement pstmt = connection.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                MemberDTO member = new MemberDTO();
                member.setId(rs.getString("id"));
                member.setPassword(rs.getString("password"));
                member.setGender(rs.getString("gender"));
                member.setAge(rs.getInt("age"));
                member.setGoals(rs.getString("goals"));
                member.setExerciseEXP(rs.getInt("exerciseEXP"));
                member.setLevel(rs.getInt("level"));
                members.add(member);
            }
        }catch(Exception e) {
        	System.out.println("Exception[getAllMembers]: "+ e.getMessage());
        }
        return members;
    }

    // 회원 정보를 업데이트하는 메서드
    public void updateMember(MemberDTO member) throws SQLException {
        String query = "UPDATE member SET password = ?, gender = ?, age = ?, goals = ?, exerciseEXP = ?, level = ? WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, member.getPassword());
            pstmt.setString(2, member.getGender());
            pstmt.setInt(3, member.getAge());
            pstmt.setString(4, member.getGoals());
            pstmt.setInt(5, member.getExerciseEXP());
            pstmt.setInt(6, member.getLevel());
            pstmt.setString(7, member.getId());
            pstmt.executeUpdate();
        }catch(Exception e) {
        	System.out.println("Exception[updateMember]: "+ e.getMessage());
        }
    }

    // 특정 ID의 회원을 삭제하는 메서드
    public void deleteMember(String id) throws SQLException {
        String query = "DELETE FROM member WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, id);
            pstmt.executeUpdate();
        }catch(Exception e) {
        	System.out.println("Exception[deleteMember]: "+ e.getMessage());
        }
    }
}
