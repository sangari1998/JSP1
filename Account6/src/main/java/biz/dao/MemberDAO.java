package biz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import biz.vo.MemberVO;

public class MemberDAO {
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	// DB 접속 메서드
	public void dbConn() {

		try {
			// 1. 외부에서 data를 읽어들이기 위한 Context 생성
			Context initctx = new InitialContext(); // server.xvl <Context> 설정과 관련
			// 2. 톰캣 서버에 정보를 담아놓은 곳으로 이동
			Context envctx = (Context)initctx.lookup("java:comp/env"); // lookup() 사용환경 찾기
			// 3. DataSource 객체 선언 = 톰캣 server.xml에 코딩한 문자열 값
			DataSource ds = (DataSource) envctx.lookup("jdbc/pool"); // lookup() Resource 찾기
			// 4. DataSource를 기준으로 하여 DB에 Connection 성공
			conn = ds.getConnection();
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	// 아이디 확인여부 메서드
	public int checkEqualsID(String id) {
		int check = 0;
		dbConn();
		try {
			String sql = "select * from jsp_member where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				check = 1;
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}
	
	public void createMember(MemberVO bean) {
		dbConn();
		try {
			String sql = "insert into jsp_member values (?,?,?,?,?,'member')";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bean.getId());
			pstmt.setString(2, bean.getPassword());
			pstmt.setString(3, bean.getName());
			pstmt.setString(4, bean.getTel());
			pstmt.setString(5, bean.getEmail());
			pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public MemberVO login(String id,String pass) {
		MemberVO bean = new MemberVO();
		dbConn();
		try {
			String sql = "select * from jsp_member where id=? and password=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pass);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				bean.setId(rs.getString("id"));
				bean.setName(rs.getString("name"));
				bean.setGranted(rs.getString("granted"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return bean;
	}
	public String checkpass1(String id,String email) {
		dbConn();
		String sendEmail = null;
		try {
			String sql = "select * from jsp_member where id=? and email=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, email);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				sendEmail = rs.getString("email");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return sendEmail;
	}
	// 인증번호 발급
	public void sendPass(String id,String contentNum) {
		dbConn();
		try {
			String sql = "select * from getPass where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			// 인증번호가 없을 경우 삽입
			if(!rs.next()) {
				String sql2 = "insert into getPass values (?,?)";
				pstmt = conn.prepareStatement(sql2);
				pstmt.setString(1, id);
				pstmt.setString(2, contentNum);
				pstmt.executeUpdate();
				rs.close();
				pstmt.close();
				conn.close();
				System.out.println("인증번호 새로 발급");
			}else {			// 이미 인증번호가 있을 경우 업데이트
				String sql2 = "update getPass set temp_pass=? where id = ?";
				pstmt = conn.prepareStatement(sql2);
				pstmt.setString(1, contentNum);
				pstmt.setString(2, id);
				pstmt.executeUpdate();
				rs.close();
				pstmt.close();
				conn.close();
				System.out.println("인증번호 업데이트");
			}


		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public String checksentPass(String id,String pass2) {
		dbConn();
		String originalPass = null;
		try {
			String sql = "select * from getPass where id=? and temp_pass=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pass2);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String sql2 = "select password from jsp_member where id=?";
				pstmt = conn.prepareStatement(sql2);
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					originalPass = rs.getString(1);
				}
				rs.close();
				pstmt.close();
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return originalPass;
	}
	
	public void deletegetPass(String id) {
		dbConn();
		try {
			String sql = "delete from getPass where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
			System.out.println("발급받은 임시 비밀번호 데이터베이스에서 삭제");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
