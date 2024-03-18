package account.control;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.dao.AccountingDAO;
import biz.vo.AccountingVO;

@WebServlet("/AccountInsertCtrl")
public class AccountInsertCtrl extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setCharacterEncoding("utf-8");
	    response.setContentType("text/html;charset=utf-8");
	    System.out.println("여기 넘어옴");
	    String regdate[] =  request.getParameterValues("regdate[]");
	    String category[] = request.getParameterValues("category[]");
	    String money[] = request.getParameterValues("money[]");
	    String note[] = request.getParameterValues("note[]");
	    
	    ArrayList<AccountingVO> list = new ArrayList<AccountingVO>();
	    System.out.println("여긴 넘어왔음");
	    int length = Math.min(regdate.length, Math.min(category.length, Math.min(money.length, note.length)));
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    for(int i = 0; i < length; i++) {
	        if (!regdate[i].equals("") || !money[i].equals("")) {
	            AccountingVO vo = new AccountingVO();
	            try {
	                Date date = sdf.parse(regdate[i]);
	                vo.setRegdate(date);
	            } catch (ParseException e) {
	                e.printStackTrace();
	                // 날짜 변환 오류 처리
	            }
	            vo.setCategory(category[i]);
	            vo.setMoney(Long.parseLong(money[i]));
	            vo.setNote(note[i]);
	            list.add(vo);
	        }
	    }
	    System.out.println(list.size()+"리스트 크기");
	    AccountingDAO adao = new AccountingDAO();
	    // 객체배열에 담은 요소를 데이터베이스에 삽입
	    for(int i=0;i<list.size();i++) {
	    	adao.insertAccounting(list.get(i));
	    }
	    response.sendRedirect("MainAccountCtrl");
	}
}
