package member.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.dao.MemberDAO;
import biz.vo.MemberVO;

@WebServlet("/CreateMemberCtrl2")
public class CreateMemberCtrl2 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		String tel1 = request.getParameter("tel1");
		String tel2 = request.getParameter("tel2");
		String tel3 = request.getParameter("tel3");
		String tel = tel1+"-"+tel2+"-"+tel3;
		String email = request.getParameter("email");
		
		MemberVO bean = new MemberVO();
		bean.setId(id);
		bean.setPassword(pass);
		bean.setName(name);
		bean.setTel(tel);
		bean.setEmail(email);
		
		MemberDAO mdao = new MemberDAO();
		mdao.createMember(bean);
		
		
		//회원가입 완료 표시
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<script>alert('회원가입이 완료되었습니다!');</script>");	
		out.println("<script>location.href='./login.jsp'</script>");
	}

}
