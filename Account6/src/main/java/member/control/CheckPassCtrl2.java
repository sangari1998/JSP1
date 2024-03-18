package member.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import biz.dao.MemberDAO;

@WebServlet("/CheckPassCtrl2")
public class CheckPassCtrl2 extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		String pass = (String)session.getAttribute("contentNum");
		String pass2 = request.getParameter("pass");
		System.out.println("세션아이디 : "+id);
		System.out.println("세션인증번호 : "+pass);
		System.out.println("파라미터 인증번호 : "+pass2);
		String originalPass = null;
		if(id == null || pass == null) {
	        response.setContentType("text/html;charset=utf-8;");
	        PrintWriter out = response.getWriter();
	        out.println("<script type=\"text/javascript\">");
	        out.println("alert('인증 시간이 만료되었습니다. 다시 입력해 주세요.');");
	        out.println("window.location='searchPass.jsp';"); // 사용자를 로그인 페이지로 다시 보냄
	        out.println("</script>");			
		}
		if(!pass.equals(pass2)) { // 인증번호가 틀리면
	        response.setContentType("text/html;charset=utf-8;");
	        PrintWriter out = response.getWriter();
	        out.println("<script type=\"text/javascript\">");
	        out.println("alert('인증번호가 틀렸습니다. 다시 입력해 주세요.');");
	        out.println("window.location='searchPass.jsp';"); // 사용자를 로그인 페이지로 다시 보냄
	        out.println("</script>");						
		}else { // 인증번호가 같으면
			MemberDAO mdao = new MemberDAO();
			originalPass = mdao.checksentPass(id,pass2);
			mdao.deletegetPass(id); // 세션에 들어있는 아이디 정보로 확인
		}
		if(originalPass != null) { // 비밀번호 찾았을때
			request.setAttribute("originalPass", originalPass);
			RequestDispatcher dis = request.getRequestDispatcher("searchPass3.jsp");
			dis.forward(request, response);
		}else { // 비밀번호 틀렸을때
	        response.setContentType("text/html;charset=utf-8;");
	        PrintWriter out = response.getWriter();
	        out.println("<script type=\"text/javascript\">");
	        out.println("alert('인증번호가 틀렸습니다. 다시 입력해 주세요.');");
	        out.println("window.location='searchPass.jsp';"); // 사용자를 로그인 페이지로 다시 보냄
	        out.println("</script>");				
		}
		
		
	}
// 세션에 아이디 있음
// 세션에 인증번호 있음
}
