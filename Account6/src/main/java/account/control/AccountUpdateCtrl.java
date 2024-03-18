package account.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import biz.dao.AccountingDAO;
import biz.vo.AccountingVO;

@WebServlet("/AccountUpdateCtrl")
public class AccountUpdateCtrl extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		HttpSession session = request.getSession();
		String granted = (String)session.getAttribute("granted");
		if(!granted.equals("admin")) {
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('관리자만 수정이 가능합니다.')");
			out.println("history.go(-1)");
			out.println("</script>");
		}		
		
		long seq = Long.parseLong(request.getParameter("seq"));
		String category = request.getParameter("category");
		long money = Long.parseLong(request.getParameter("money"));
		String note = request.getParameter("note");
		AccountingVO vo = new AccountingVO();

		vo.setSeq(seq);
		vo.setCategory(category);
		vo.setMoney(money);
		vo.setNote(note);
		AccountingDAO adao = new AccountingDAO();
		// 정보수정
		adao.updateAccounting(vo);
		
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('수정이 완료되었습니다.')");
		out.println("location.href='AccountDetailCtrl?seq=" + seq + "'");
		out.println("</script>");
		
	}

}
