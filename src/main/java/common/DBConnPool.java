package common;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBConnPool {
	protected Connection conn;
	protected PreparedStatement pstmt;
	protected ResultSet rs;
	public DBConnPool() {
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			DataSource ds = (DataSource) envCtx.lookup("jdbc/dbcp_myoracle");
			conn = ds.getConnection();
			System.out.println("DB 커넥션 풀 연걸 성공!");
		} catch (Exception e) {
			System.out.print("DB connnection Pool 연결실패 : " + e.getMessage());
		}
	}
	public void close() {
		try {
			if(rs != null) {rs.close();}
			if(pstmt != null) {pstmt.close();}
			if(conn != null) {conn.close();}
			System.out.println("DB 커넥션 풀 지원 반납");
		} catch(Exception e){
			System.out.print("Exception : " + e.getMessage());
		}
	}
}
