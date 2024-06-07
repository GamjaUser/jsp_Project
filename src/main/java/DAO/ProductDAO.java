package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import DTO.ProductDTO;
import common.DBConnPool;

public class ProductDAO extends DBConnPool{
	public ProductDAO() {
		super();
	}
	
	public int insertPrdouct(ProductDTO dto) {
		System.out.println("insertProdut");
		int result = 0;
		
		String sql = "INSERT INTO product "
				+ "values(seq_product_num.nextval, ?,?,?,?,?)";		
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getImg());
			pstmt.setString(3, dto.getComment());
			pstmt.setInt(4, dto.getPrice());
			pstmt.setString(5, dto.getProductKind());
			
			result = pstmt.executeUpdate();
			
		}catch (SQLException  e) {
			// T1ODO: handle exception
			System.out.println("Ex : " + e.getMessage());
		}
		
		return result;
	}
	
	public List<ProductDTO> listProduct() {
		
		String sql = "select * from product";
		
		
		List<ProductDTO> productList = new Vector<ProductDTO>();
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql)){
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ProductDTO dto = new ProductDTO();
				System.out.println("id : " +  rs.getString("name"));
//				System.out.println("comm : " + rs.getString("comment"));
				
				dto.setProdcutId(rs.getInt("productid"));
				dto.setName(rs.getString("name"));
				dto.setImg(rs.getString("img"));
				dto.setComment(rs.getNString("comment"));
				dto.setPrice(rs.getInt("price"));
				dto.setProductKind(rs.getString("productkind"));
				
				productList.add(dto);
			}
			
		}catch (SQLException  e) {
			// T1ODO: handle exception
			System.out.println("Ex : " + e.getMessage());
		}
		
		
		return productList;
	}
	
	public ProductDTO selectProduct(int productId) {
		ProductDTO dto = new ProductDTO();
		
		String sql = "select * from product where productid = ?";
		
		try{
			pstmt = conn.prepareStatement(sql);
			System.out.println("단일상품 페이지1");
			pstmt.setInt(1, productId);
			
			rs = pstmt.executeQuery();
			
			rs.next();
			
			dto.setProdcutId(rs.getInt("productid"));
			dto.setName(rs.getString("name"));
			dto.setImg(rs.getString("img"));
			dto.setComment(rs.getNString("comment"));
			dto.setPrice(rs.getInt("price"));
			dto.setProductKind(rs.getString("productkind"));
			
			
		}catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Ex : " + e.getMessage());
		}
		finally {
			conn.close();
		}
		
		return dto;
	}
	
	public List<ProductDTO> searchProduct(String name) {
		
		List<ProductDTO> productList = new Vector<ProductDTO>();
		
		String sql = "select * from product where name"
				+" like '%' || ? || '%'";
		
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql)){
			System.out.println(1);
			pstmt.setString(1, name);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ProductDTO dto = new ProductDTO();
				
				dto.setProdcutId(rs.getInt("productid"));
				dto.setName(rs.getString("name"));
				dto.setImg(rs.getString("img"));
				dto.setComment(rs.getNString("comment"));
				dto.setPrice(rs.getInt("price"));
				dto.setProductKind(rs.getString("productkind"));
				
				productList.add(dto);
			}
		}catch (SQLException e ) {
			// TODO: handle exception
			System.out.println("Ex : " + e.getMessage());
		}
		
		return productList; 
		}

	
	public boolean deleteProduct(String productId) {
		System.out.println("Delete Product");
		int result = 0;
		
		String sql = "DELETE FROM product WHERE productid = ?";
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1, productId);
			
			result = pstmt.executeUpdate();
		}catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Ex : " + e.getMessage());
		}
		
		return result ==  1 ;
	}

	public String getFilePath(String productId) {
		System.out.println("getFilePath");
		
		String sql = "SELECT img FROM product WHERE productid = ?";
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setInt(1, Integer.parseInt(productId));
			try(ResultSet rs = pstmt.executeQuery()){
				if(rs.next()) {
					return rs.getString("img");
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
