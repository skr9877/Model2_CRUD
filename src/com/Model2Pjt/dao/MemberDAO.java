package com.Model2Pjt.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.Model2Pjt.vo.MemberVo;


public class MemberDAO {
	private static MemberDAO dao = new MemberDAO();
	private MemberDAO() {}
	public static MemberDAO getInstance() {
		return dao;
	}
	
	public Connection connect() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:127.0.0.1:1521:orcl", "WEB_USER", "gmltjr1177");			
		}catch (Exception e) {
			System.out.println("설정 오류발생 : " + e);
		}
		
		return conn;
	}
	
	public void close(Connection conn, PreparedStatement pstmt) {
		if(pstmt != null) {
			try {
				pstmt.close();
			}
			catch (Exception e) {
				System.out.println("오류 발생 : " + e);
			}
		}
		
		if(conn != null) {
			try {
				conn.close();
			}
			catch (Exception e) {
				System.out.println("오류 발생 : " + e);
			}
		}
	}
	
	public void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			}
			catch (Exception e) {
				System.out.println("오류 발생 : " + e);
			}
		}
		
		close(conn,pstmt);
	}
	
	public void memberInsert(MemberVo member) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = connect();
			pstmt = conn.prepareStatement("INSERT INTO MEMBERS(ID, PASSWORD, NAME, EMAIL, GENDER) VALUES(?,?,?,?,?)");
			
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getEmail());
			pstmt.setString(5, member.getGender());
			
			pstmt.executeUpdate();
		}
		catch (Exception e) {
			System.out.println("실행 오류 발생 " + e);
		}
		finally {
			close(conn,pstmt);
		}
	}
	
	public void memberDelete(MemberVo member) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "DELETE FROM MEMBERS WHERE ID = ?";
		
		try {
			conn = connect();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, member.getId());
			
			System.out.println("출력 : " + member.getId());
			
			pstmt.executeUpdate();
		}
		catch(Exception e){
			System.out.println("삭제 오류 발생 " + e);
		}
		finally {
			close(conn,pstmt);
		}
	}
	
	public MemberVo memberSearch(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;	
		MemberVo member = null;
		
		String sql = "SELECT /*+ INDEX(A  PK_MEMBERS) */ ID, PASSWORD, NAME, EMAIL, GENDER FROM MEMBERS A WHERE ID = ?";
		
		try {
			conn = connect();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member = new MemberVo();
				
				member.setId(rs.getString("ID"));
				member.setPassword(rs.getString("PASSWORD"));
				member.setName(rs.getString("NAME"));
				member.setEmail(rs.getString("EMAIL"));
				member.setGender(rs.getString("GENDER"));
			}
		}
		catch (Exception e) {
			System.out.println("검색 오류 : " + e);
		}
		finally {
			close(conn,pstmt,rs);
		}
		
		return member;
	}
}
