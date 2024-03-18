package member.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import biz.dao.MemberDAO;
import biz.vo.MemberVO;

@WebServlet("/LoginCtrl")
public class LoginCtrl extends HttpServlet {


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		MemberDAO mdao = new MemberDAO();
		MemberVO bean = mdao.login(id,pass);

		if(bean.getId() == null) {
			PrintWriter out = response.getWriter();
			out.println("<script>alert('비밀번호나 아이디가 일치하지 않습니다.');</script>");
			response.sendRedirect("login.jsp");
		}else {
			HttpSession session = request.getSession();
			session.setAttribute("id", bean.getId());
			session.setAttribute("name", bean.getName());
			session.setAttribute("granted", bean.getGranted());
			session.setMaxInactiveInterval(3600);
			response.sendRedirect("MainAccountCtrl");
		}
	}

}
