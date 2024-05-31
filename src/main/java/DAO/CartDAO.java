package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;

import DTO.CartDTO;
import DTO.ProductCartDTO;
import common.DBConnPool;

public class CartDAO extends DBConnPool{
	public CartDAO() {
		super();
	}
	
	public int insertCart(int productId, String userId, int cnt) { 
		int result = 0;
		CartDTO dto = new CartDTO();
		
		
		try {
			String sql = "MERGE INTO cart c" // �ߺ��� ������ cnt�� �ö󰡴� SQL��
					+" USING (SELECT ? AS id, ? AS productid FROM dual) src"
					+" ON (c.\"ID\" = src.id AND c.PRODUCTID = src.productid)"
					+" WHEN MATCHED THEN"
					+"  UPDATE SET c.CNT = c.CNT + ?"
					+" WHEN NOT MATCHED THEN"
					+" 	INSERT (PRODUCTID, \"ID\", CNT)"
					+"  VALUES (src.productid, src.id, ?)";
			
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, "user05"); //��ٱ��� �����
			pstmt.setInt(2, 1); //��ٱ��Ͽ� �� ��ǰ ������ȣ
			pstmt.setInt(3, cnt); //��ٱ��Ͽ� �� ��ǰ ���� 
			pstmt.setInt(4, cnt);
			result = pstmt.executeUpdate();
			
			
			System.out.println(1);
		}catch (SQLException e) {
			System.out.println("Ex : " + e.getMessage());
		}
		
		return result;
	}
	
	public List<ProductCartDTO> selectList(String id){ //���� ID
		
		List<ProductCartDTO> productList = new Vector<>(); //������ǰ��ȣ�� ����ִ� ����Ʈ
		
		try {
		    String sql = "select * from cart c"
		    		+" join product p on p.productid = c.productid"
		    		+" WHERE id = ?";
		    
		    pstmt = conn.prepareStatement(sql);
		    
		    pstmt.setString(1, id);
		    
		    rs = pstmt.executeQuery();
		    
		    while(rs.next()) {
		    	ProductCartDTO dto = new ProductCartDTO();
		    	
		    	dto.setProductId(rs.getInt("productid"));
		    	dto.setName(rs.getNString("name"));
		    	dto.setImg(rs.getString("img"));
		    	dto.setComment(rs.getString("comment"));
		    	dto.setPrice(rs.getInt("price"));
		    	
		    	dto.setId(rs.getString("id"));
		        dto.setCnt(rs.getInt("cnt"));
		        
		        dto.setPriceSum((rs.getInt("cnt") * rs.getInt("price")));
		        
		        productList.add(dto);
		    }
		} catch (SQLException e) {
		    System.out.println("Ex : " + e.getMessage());
		} finally {
		    close();
		}
		
		System.out.println("dao : " + productList);
		
		System.out.println("size : " + productList.size());
		return productList;
	}
	
	public int delectCart(int productid, String id) {
		int result = 0;
		String sql = "delete from cart "
				+" WHERE productid = ? AND id= ? ";
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			
			pstmt.setInt(1, productid);
			pstmt.setString(2, id);
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Ex : " + e.getMessage());
		}
		
		return result;
	}
}
