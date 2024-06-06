package fileupload;

import java.util.List;
import java.util.Vector;

import DTO.MemberDTO;
import common.DBConnPool;
import model2.mvcboard.MVCBoardDTO;

public class MyfileDAO extends DBConnPool {
	// 새로운 게시물을 입력합니다.
    public int insertFile(MyfileDTO dto, MemberDTO mdto, MVCBoardDTO bdto) {
        int applyResult = 0;
        try {
        	String sql = "INSERT INTO myfile " + "(idx, id2, idx2, cate, ofile,sfile)" + 
        				"VALUES (seq_board_num.nextval, ?, ?, ?, ?, ?)";
        	pstmt = conn.prepareStatement(sql);
        	pstmt.setString(1,  mdto.getId());
        	pstmt.setString(2, bdto.getIdx());
        	pstmt.setString(3, dto.getCate());
        	pstmt.setString(4, dto.getOfile());
        	pstmt.setString(5, dto.getSfile());
        	applyResult = pstmt.executeUpdate();
        }catch(Exception e) {
        	System.out.println("Exception[insertFile]: " + e.getMessage());
        }
        
		return applyResult;
    }

    // 파일 목록을 반환합니다.
    public List<MyfileDTO> myFileList() {
        List<MyfileDTO> fileList = new Vector<MyfileDTO>();
        try {
        	String sql = "SELECT * FROM myfile ORDER BY idx DESC";
        	pstmt = conn.prepareStatement(sql);
        	rs = pstmt.executeQuery();
        	while(rs.next()) {
        		MyfileDTO dto = new MyfileDTO()	;
        		dto.setIdx(rs.getString("idx"));
        		dto.setName(rs.getString("name"));
        		dto.setTitle(rs.getString("title"));
        		dto.setCate(rs.getString("cate"));
        		dto.setOfile(rs.getString("ofile"));
        		dto.setSfile(rs.getString("sfile"));
        		dto.setPostdate(rs.getDate("postdate"));
        		fileList.add(dto);
        		
        	}
        }catch(Exception e) {
        	System.out.println("Exception[myFileList]: " + e.getMessage());
        }

        return fileList;  
    }
}