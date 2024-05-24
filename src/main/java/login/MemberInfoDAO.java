package login;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import DTO.MemberDTO;
import DTO.MemberInfoDTO;
import common.JDBConnect;

public class MemberInfoDAO extends JDBConnect {
	public MemberInfoDAO(ServletContext application) {
        super(application);
    }
    // 새로운 회원 정보를 member_info 테이블에 삽입하는 메서드
    public int insertMemberInfo(MemberInfoDTO memberInfo) throws SQLException {
        int dto = 0;
    	try {
        	String query = "INSERT INTO member_info (id, Weight, height, sdate) VALUES (?, ?, ?, ?)";
        	psmt = con.prepareStatement(query);
        	psmt.setString(1, memberInfo.getId());
            psmt.setInt(2, memberInfo.getWeight());
            psmt.setInt(3, memberInfo.getHeight());
            psmt.setDate(4, memberInfo.getSdate());
            dto = psmt.executeUpdate();
        }catch(Exception e) {
        	System.out.println("Exception[insertMemberInfo]: "+ e.getMessage());
        }
    	return dto;
    }

    // ID로 특정 회원 정보를 조회하는 메서드
    public MemberInfoDTO getMemberInfoById(String id) throws SQLException {
        String query = "SELECT * FROM member_info WHERE id = ?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, id);
            try {
            	psmt = con.prepareStatement(query);
    			rs = psmt.executeQuery();
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
        try {
        	psmt = con.prepareStatement(query);
        	rs = psmt.executeQuery();
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
    public List<MemberInfoDTO> updateMemberInfo(MemberInfoDTO memberInfo) throws SQLException {
    	List<MemberInfoDTO> update = new ArrayList<MemberInfoDTO>();
    	String query = "UPDATE member_info SET weight = ?, height = ?, sdate = ? WHERE id = ?";
        try {
        	psmt = con.prepareStatement(query);
			rs = psmt.executeQuery();
			while(rs.next()) {
				MemberInfoDTO dto = new MemberInfoDTO();
				dto.setWeight(rs.getInt("weight"));
				dto.setHeight(rs.getInt("height"));
				dto.setSdate(rs.getDate("sdate"));
				dto.setId(rs.getString("id"));
				update.add(dto);
	           
			}
        }catch(Exception e) {
        	System.out.println("Exception[updateMemberInfo]: "+ e.getMessage());
        }
        return update;
    }

    // 특정 ID의 회원 정보를 삭제하는 메서드
    public int deleteMemberInfo(String id) throws SQLException {
        int result = 0;
    	try{
        	String query = "DELETE FROM member_info WHERE id = ?";
        	psmt = con.prepareStatement(query);
            psmt.setString(1, id);
            result = psmt.executeUpdate();
        }catch(Exception e) {
        	System.out.println("Exception[deleteMemberInfo]: "+ e.getMessage());
        }
    	return result;
    }
}
