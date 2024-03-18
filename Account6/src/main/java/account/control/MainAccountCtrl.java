package account.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.dao.AccountingDAO;
import biz.vo.AccountingVO;

@WebServlet("/MainAccountCtrl")
public class MainAccountCtrl extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGetPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGetPost(request, response);
	}
	
	protected void doGetPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		// 아이디 이름 부여권한 세션에 담겨있음  
		AccountingDAO adao = new AccountingDAO();
		ArrayList<AccountingVO> list = adao.getAllList();
		request.setAttribute("list", list);
		RequestDispatcher dis = request.getRequestDispatcher("accountMain.jsp");
		dis.forward(request, response);
		
	}	

}
