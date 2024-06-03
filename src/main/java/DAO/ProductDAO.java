package DAO;

import java.sql.PreparedStatement;
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
		int result = 0;
		
		String sql = "INSERT INTO product "
				+ "values(seq_product_num.nextval, ?,?,?,?,?,?)";		
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getImg());
			pstmt.setString(3, dto.getComment());
			pstmt.setInt(4, dto.getPrice());
			pstmt.setInt(5, dto.getCnt());
			pstmt.setString(6, dto.getProductKind());
			
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
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql)){
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


}
