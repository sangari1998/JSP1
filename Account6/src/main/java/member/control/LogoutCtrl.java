package member.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LogoutCtrl")
public class LogoutCtrl extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGetPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGetPost(request, response);
	}

	protected void doGetPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 아이디 이름 부여권한 세션에 담겨있음
		HttpSession session = request.getSession();
		session.setAttribute("id", null);
		session.setAttribute("name", null);
		session.setAttribute("granted", null);
		session.setMaxInactiveInterval(0);
		session.invalidate();
		response.setContentType("text/html;charset=UTF-8");;
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('로그아웃 처리가 되었습니다.')");
		out.println("location.href='login.jsp'"); // 로그인 성공 후 이동할 페이지
		out.println("</script>");
	}
}
