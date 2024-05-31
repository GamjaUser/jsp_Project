package DAO;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import DTO.MemberInfoDTO;
import common.DBConnPool;

public class MemberInfoDAO extends DBConnPool {
	public MemberInfoDAO(ServletContext application) {
        super();
    }
	
	

    // 새로운 회원 정보를 member_info 테이블에 삽입하는 메서드
    public int insertMemberInfo(MemberInfoDTO memberInfo){
        int dto = 0;
    	try {
        	String query = "INSERT INTO member_info "
        				 + "(id, Weight, height, sdate) "
        				 + "VALUES (?, ?, ?,TO_DATE(?,'YYYY-MM-DD'))";
        	pstmt = conn.prepareStatement(query);
        	pstmt.setString(1, memberInfo.getId());
            pstmt.setInt(2, memberInfo.getWeight());
            pstmt.setInt(3, memberInfo.getHeight());
            pstmt.setDate(4, memberInfo.getSdate());
            dto = pstmt.executeUpdate();
        }catch(Exception e) {
        	System.out.println("Exception[insertMemberInfo]: "+ e.getMessage());
        }
    	return dto;
    }
    
    public MemberInfoDTO selectProfileView_info(String id) {
        MemberInfoDTO dto = new MemberInfoDTO();
        String query = "SELECT * FROM member_info WHERE id = ?";
        try {
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            
            if(rs.next()) {
                dto.setHeight(rs.getInt("height"));
                dto.setWeight(rs.getInt("weight"));
                dto.setSdate(rs.getDate("sdate")); // java.sql.Date 형식이 아닌 java.util.Date 형식으로 설정
            }
        } catch(Exception e) {
            System.out.println("Exception[selectProfileView_info]: " + e.getMessage());
            e.printStackTrace();
        }
        return dto;
    }
    
 // 회원 정보를 업데이트하는 메서드
    public MemberInfoDTO updateMemberInfo(String id, int height, int weight) throws SQLException {
    	MemberInfoDTO dto = new MemberInfoDTO();
        try {
        	String query = "UPDATE member_info SET weight = ?, height = ?, sdate = ? WHERE id = ?";
        	pstmt = conn.prepareStatement(query);
        	pstmt.setInt(1, weight);
        	pstmt.setInt(2, height);
        	pstmt.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            pstmt.setString(4, id);
            
            rs = pstmt.executeQuery();
        }catch(Exception e) {
            System.out.println("Exception[updateMemberInfo]: " + e.getMessage());
            e.printStackTrace();
        }
       
    
        return dto;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    //관리자 모드
    // ID로 특정 회원 정보를 조회하는 메서드
    public MemberInfoDTO getMemberInfoById(String id) throws SQLException {
        String query = "SELECT * FROM member_info WHERE id = ?";
        try (PreparedStatement psmt = conn.prepareStatement(query)) {
            pstmt.setString(1, id);
            try {
            	pstmt = conn.prepareStatement(query);
    			rs = pstmt.executeQuery();
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
        	pstmt = conn.prepareStatement(query);
        	rs = pstmt.executeQuery();
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

 

    // 특정 ID의 회원 정보를 삭제하는 메서드
    public int deleteMemberInfo(String id) throws SQLException {
        int result = 0;
    	try{
        	String query = "DELETE FROM member_info WHERE id = ?";
        	pstmt = conn.prepareStatement(query);
            pstmt.setString(1, id);
            result = pstmt.executeUpdate();
        }catch(Exception e) {
        	System.out.println("Exception[deleteMemberInfo]: "+ e.getMessage());
        }
    	return result;
    }
}
