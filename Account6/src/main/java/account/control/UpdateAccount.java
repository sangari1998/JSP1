package account.control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import biz.dao.AccountingDAO;
import biz.vo.AccountingVO;

@WebServlet("/UpdateAccountCtrl")
public class UpdateAccount extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String granted = (String)session.getAttribute("granted");
		if(granted.equals("admin")) {
			String category = request.getParameter("category");
			long money = Long.parseLong(request.getParameter("money"));
			String note = request.getParameter("note");
			long seq = Long.parseLong(request.getParameter("seq"));
			
			AccountingVO vo = new AccountingVO();
			vo.setSeq(seq);
			vo.setCategory(category);
			vo.setMoney(money);
			vo.setNote(note);
			AccountingDAO adao = new AccountingDAO();
			adao.updateAccounting(vo);
			response.getWriter().write("{\"status\":1}");			
		}else {
			response.getWriter().write("{\"status\":0}");
		}

		
	}
}
