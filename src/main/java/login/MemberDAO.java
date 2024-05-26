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
    public int insertMember(MemberDTO member) {
        int dto=0;
    	try  {
        	String query = "INSERT INTO member "
        			     + "(id, password, gender, age, goals, exerciseEXP, \"level\") "
        			     + "VALUES (? ,?, ?, ?, ?, ?, ?)";
        	pstmt = con.prepareStatement(query);
            pstmt.setString(1, member.getId());
            pstmt.setString(2, member.getPassword());
            pstmt.setString(3, member.getGender());
            pstmt.setInt(4, member.getAge());
            pstmt.setInt(5, member.getGoals());
            pstmt.setInt(6, member.getExerciseEXP());
            pstmt.setInt(7, member.getLevel());
            dto = pstmt.executeUpdate();
        }catch(Exception e) {
        	System.out.println("Exception[insertMember]: "+ e.getMessage());
        }
        return dto;
    }
    
    // ID 중복 여부를 확인하는 메서드
    public boolean idCheck(String id) throws SQLException {
        String query = "SELECT id FROM member WHERE id = ?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next(); // 존재하면 true, 존재하지 않으면 false 반환
            }
        } catch (Exception e) {
            System.out.println("Exception[idCheck]: " + e.getMessage());
            return false;
        }
    }
    
 // 아이디와 비밀번호로 로그인 확인
    public String memberLogin(MemberDTO member) {       
        String result = "fail";
        try {     
            String sql = "SELECT * "
            		   + "FROM member "
            		   + "WHERE id = ? AND password = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, member.getId());
            pstmt.setString(2, member.getPassword());
            rs = pstmt.executeQuery();

            // 결과가 존재하면 success 반환
            if (rs.next()) {
                result = "success";
            }
        } catch (SQLException e) {
            e.printStackTrace(); // 에러 처리 코드 작성
        } finally {
            // 리소스 정리
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace(); // 에러 처리 코드 작성
            }
        }

        return result;
    }
    
    
    //프로필페이지 정보 출력
    public MemberDTO selectProfileView(String id) {
    	MemberDTO dto = new MemberDTO(); // DTO 객체 생성
        String query = "SELECT * FROM member WHERE id=?";  // 쿼리문 템플릿 준비
        try {
        	pstmt = con.prepareStatement(query);
        	pstmt.setString(1, id);
        	rs = pstmt.executeQuery();
        	
        	if(rs.next()) {
        		dto.setId(rs.getString("id"));
        		dto.setAge(rs.getInt("age"));
        		dto.setGender(rs.getString("gender"));
        		dto.setExerciseEXP(rs.getInt("exerciseEXP"));
        		dto.setGoals(rs.getInt("goals"));
        		dto.setLevel(rs.getInt("level"));
        	}
        	
        }catch(Exception e) {
            System.out.println("Exception[selectProfileView]: " + e.getMessage());
            e.printStackTrace();
        }
		return dto;
    	
    }
    
    //관리자모드
    // ID로 특정 회원을 조회하는 메서드
    public MemberDTO getMemberById(String id) throws SQLException {
        String query = "SELECT * FROM member WHERE id = ?";
        try (PreparedStatement ptsmt = con.prepareStatement(query)) {
            pstmt.setString(1, id);
            try {
            	pstmt = con.prepareStatement(query);
    			rs = pstmt.executeQuery();
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
        	pstmt = con.prepareStatement(query);
        	rs = pstmt.executeQuery();
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
        	pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
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
        	pstmt = con.prepareStatement(query);
            pstmt.setString(1, id);
            result = pstmt.executeUpdate();
        }catch(Exception e) {
        	System.out.println("Exception[deleteMember]: "+ e.getMessage());
        }
        return result;
    }
}
