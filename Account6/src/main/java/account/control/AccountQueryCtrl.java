package account.control;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.dao.AccountingDAO;
import biz.vo.AccountingVO;

@WebServlet("/AccountQueryCtrl")
public class AccountQueryCtrl extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String year1 = request.getParameter("selectYear1");
		String month1 = request.getParameter("selectMonth1");
		String day1 = request.getParameter("selectDay1");
		String year2 = request.getParameter("selectYear2");
		String month2 = request.getParameter("selectMonth2");
		String day2 = request.getParameter("selectDay2");

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate date1 = LocalDate.parse(year1+"-"+month1+"-"+day1, formatter);
		LocalDate date2 = LocalDate.parse(year2+"-"+month2+"-"+day2, formatter);
		
		AccountingDAO adao = new AccountingDAO();
		ArrayList<AccountingVO> depositlist = adao.depositqueryAccounting(date1,date2);
		ArrayList<AccountingVO> withdrawlist = adao.withdrawqueryAccounting(date1,date2);
		
		request.setAttribute("depositlist", depositlist);
		request.setAttribute("withdrawlist", withdrawlist);
		
		// 결산 및 지출 금액
		long deposit = 0;
		long withdraw = 0;
		for(int i=0;i<depositlist.size();i++) {
			deposit += depositlist.get(i).getMoney();
		}
		for(int i=0;i<withdrawlist.size();i++) {
			withdraw += withdrawlist.get(i).getMoney();
		}
		
		request.setAttribute("deposit", deposit);
		request.setAttribute("withdraw", withdraw);
		
		RequestDispatcher dis = request.getRequestDispatcher("accountQuery.jsp");
		dis.forward(request, response);
		
	}

}
