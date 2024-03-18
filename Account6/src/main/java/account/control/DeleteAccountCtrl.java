package account.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.dao.AccountingDAO;

@WebServlet("/DeleteAccountCtrl")
public class DeleteAccountCtrl extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long seq = Long.parseLong(request.getParameter("seq"));
		
		AccountingDAO adao = new AccountingDAO();
		adao.deleteAccounting(seq);
		
		response.getWriter().write("{\"status\":1}");
	}

}
