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

@WebServlet("/AccountDetailCtrl")
public class AccountDetailCtrl extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String granted = (String)session.getAttribute("granted");
		if(!granted.equals("admin")) {
			response.setCharacterEncoding("text/html;charset=utf-8;");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('관리자만 상세보기가 가능합니다.')");
			out.println("history.go(-1)");
			out.println("</script>");
		}
		// 글하나 정보 찾기
		long seq = Long.parseLong(request.getParameter("seq"));
		AccountingDAO adao = new AccountingDAO();
		AccountingVO vo = adao.getOneBoard(seq);
		request.setAttribute("vo", vo);
		RequestDispatcher dis = request.getRequestDispatcher("accountDetail.jsp");
		dis.forward(request, response);
		
	}

}
