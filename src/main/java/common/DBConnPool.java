package common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBConnPool {
	protected Connection con;
	protected PreparedStatement pstmt;
	protected ResultSet rs;
	public DBConnPool() {
		try {
			Context initCtx = new InitialContext();
			Context ctx = (Context)initCtx.lookup("java:comp/env");
			DataSource source = (DataSource)ctx.lookup("dbcp_myoracle");
			
			con = source.getConnection();
			System.out.println("DB 커넥션 풀 연걸 성공!");
		} catch (Exception e) {
			System.out.print("DB Connection Pool 연결실패 : " + e.getMessage());
		}
	}
	public void close() {
		try {
			if(rs != null) {rs.close();}
			if(pstmt != null) {pstmt.close();}
			if(con != null) {con.close();}
			System.out.println("DB 커넥션 풀 지원 반납");
		} catch(Exception e){
			System.out.print("Exception : " + e.getMessage());
		}
	}
}
