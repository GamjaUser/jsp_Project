package login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import DTO.MemberDTO;
import common.JDBConnect;

public class MemberDAO extends JDBConnect{
	public MemberDAO(ServletContext application) {
        super(application);
    }

    // 새로운 회원을 member 테이블에 삽입하는 메서드
    public int insertMember(MemberDTO member) throws SQLException {
        int dto=0;
    	try  {
        	String query = "INSERT INTO member (id, password, gender, age, goals, exerciseEXP, level) "
        			     + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        	psmt = con.prepareStatement(query);
            psmt.setString(1, member.getId());
            psmt.setString(2, member.getPassword());
            psmt.setString(3, member.getGender());
            psmt.setInt(4, member.getAge());
            psmt.setInt(5, member.getGoals());
            psmt.setInt(6, member.getExerciseEXP());
            psmt.setInt(7, member.getLevel());
            dto = psmt.executeUpdate();
        }catch(Exception e) {
        	System.out.println("Exception[insertMember]: "+ e.getMessage());
        }
        return dto;
    }

    // ID로 특정 회원을 조회하는 메서드
    public MemberDTO getMemberById(String id) throws SQLException {
        String query = "SELECT * FROM member WHERE id = ?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, id);
            try {
            	psmt = con.prepareStatement(query);
    			rs = psmt.executeQuery();
                if (rs.next()) {
                    MemberDTO member = new MemberDTO();
                    member.setId(rs.getString("id"));
                    member.setPassword(rs.getString("password"));
                    member.setGender(rs.getString("gender"));
                    member.setAge(rs.getInt("age"));
                    member.setGoals(rs.getInt("goals"));
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
        try  {
        	psmt = con.prepareStatement(query);
        	rs = psmt.executeQuery();
            while (rs.next()) {
                MemberDTO member = new MemberDTO();
                member.setId(rs.getString("id"));
                member.setPassword(rs.getString("password"));
                member.setGender(rs.getString("gender"));
                member.setAge(rs.getInt("age"));
                member.setGoals(rs.getInt("goals"));
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
    public List<MemberDTO> updateMember(MemberDTO member) throws SQLException {
    	List<MemberDTO> update = new ArrayList<MemberDTO>();
    	String query = "UPDATE member SET password = ?, gender = ?, age = ?, goals = ?, exerciseEXP = ?, level = ? WHERE id = ?";
        try {
        	psmt = con.prepareStatement(query);
			rs = psmt.executeQuery();
			while(rs.next()) {
				MemberDTO dto = new MemberDTO();
				dto.setPassword(rs.getString("password"));
				dto.setGender(rs.getString("gender"));
				dto.setAge(rs.getInt("age"));
				dto.setGoals(rs.getInt("goals"));
				dto.setExerciseEXP(rs.getInt("exerciseEXP"));
				dto.setLevel(rs.getInt("level"));
				dto.setId(rs.getString("id"));
				update.add(dto);
			}
        }catch(Exception e) {
        	System.out.println("Exception[updateMember]: "+ e.getMessage());
        }
        return update;
    }

    // 특정 ID의 회원을 삭제하는 메서드
    public int deleteMember(String id) throws SQLException {
    	int result = 0;
        try {
        	String query = "DELETE FROM member WHERE id = ?";
        	psmt = con.prepareStatement(query);
            psmt.setString(1, id);
            result = psmt.executeUpdate();
        }catch(Exception e) {
        	System.out.println("Exception[deleteMember]: "+ e.getMessage());
        }
        return result;
    }
}
