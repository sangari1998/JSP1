package biz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import biz.vo.AccountingVO;

public class AccountingDAO {
	
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
	
	public ArrayList<AccountingVO> getAllList(){
		ArrayList<AccountingVO> list = new ArrayList<AccountingVO>();
		dbConn();
		try {
			String sql = "select * from jsp_accounting order by regdate desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				AccountingVO bean = new AccountingVO();
				bean.setSeq(rs.getLong("seq"));
				bean.setRegdate(rs.getDate("regdate"));
				bean.setCategory(rs.getString("category"));
				bean.setMoney(rs.getLong("money"));
				bean.setNote(rs.getString("note"));
				
				list.add(bean);
			}
			rs.close();
			pstmt.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	// 입금조회
	public ArrayList<AccountingVO> depositqueryAccounting(LocalDate date1,LocalDate date2){
		ArrayList<AccountingVO> depositlist = new ArrayList<AccountingVO>();
		dbConn();
		try {
			String sql1 = "select * from jsp_accounting where regdate between ? and ? and category ='입금'";
			pstmt = conn.prepareStatement(sql1);
			pstmt.setDate(1, java.sql.Date.valueOf(date1));
			pstmt.setDate(2, java.sql.Date.valueOf(date2));
			rs = pstmt.executeQuery();
			while(rs.next()) {
				AccountingVO vo = new AccountingVO();
				vo.setSeq(rs.getLong("seq"));
				vo.setRegdate(rs.getDate("regdate"));
				vo.setCategory(rs.getString("category"));
				vo.setMoney(rs.getLong("money"));
				vo.setNote(rs.getString("note"));
				
				depositlist.add(vo);
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return depositlist;
	}
	// 출금조회
	public ArrayList<AccountingVO> withdrawqueryAccounting(LocalDate date1,LocalDate date2){
		ArrayList<AccountingVO> withdrawlist = new ArrayList<AccountingVO>();
		dbConn();
		try {
			String sql1 = "select * from jsp_accounting where regdate between ? and ? and category ='출금'";
			pstmt = conn.prepareStatement(sql1);
			pstmt.setDate(1, java.sql.Date.valueOf(date1));
			pstmt.setDate(2, java.sql.Date.valueOf(date2));
			rs = pstmt.executeQuery();
			while(rs.next()) {
				AccountingVO vo = new AccountingVO();
				vo.setSeq(rs.getLong("seq"));
				vo.setRegdate(rs.getDate("regdate"));
				vo.setCategory(rs.getString("category"));
				vo.setMoney(rs.getLong("money"));
				vo.setNote(rs.getString("note"));
				
				withdrawlist.add(vo);
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return withdrawlist;
	}
	// 정보 수정
	public void updateAccounting(AccountingVO vo) {
		dbConn();
		try {
			String sql = "update jsp_accounting set category=?,money=?,note=? where seq=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getCategory());
			pstmt.setLong(2, vo.getMoney());
			pstmt.setString(3, vo.getNote());
			pstmt.setLong(4, vo.getSeq());
			pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// 정보 삭제
	public void deleteAccounting(Long seq) {
		dbConn();
		try {
			String sql = "delete jsp_accounting where seq = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, seq);
			pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// 하나의 정보 조회
	public AccountingVO getOneBoard(long seq) {
		dbConn();
		AccountingVO vo = new AccountingVO();
		try {
			String sql = "select * from jsp_accounting where seq = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, seq);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo.setSeq(rs.getLong("seq"));
				vo.setRegdate(rs.getDate("regdate"));
				vo.setCategory(rs.getString("category"));
				vo.setMoney(rs.getLong("money"));
				vo.setNote(rs.getString("note"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return vo;
	}
	
	public void insertAccounting(AccountingVO vo) {
		dbConn();
		try {
			String sql = "insert into jsp_accounting values ((select nvl(max(seq)+1, 1) FROM jsp_accounting),?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setDate(1, new java.sql.Date(vo.getRegdate().getTime())); // java.util.Date를 java.sql.Date로 변환
			pstmt.setString(2, vo.getCategory());
			pstmt.setLong(3, vo.getMoney());
			pstmt.setString(4, vo.getNote());
			pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
