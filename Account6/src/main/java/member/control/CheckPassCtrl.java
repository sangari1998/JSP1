package member.control;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import biz.dao.MemberDAO;
import biz.vo.GetPass;

@WebServlet("/CheckPassCtrl")
public class CheckPassCtrl extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String email = request.getParameter("email");

		MemberDAO mdao = new MemberDAO();
		String sendEmail = mdao.checkpass1(id,email);
		if(sendEmail == null) {
	        String script = "<script>alert('아이디나 이메일이 올바르지 않습니다.');"
	        		+ "history.back();"
	        		+ "</script>";
	        
	        // Set content type
	        response.setContentType("text/html;charset=utf-8");

	        // Write the JavaScript to the response
	        response.getWriter().write(script);
		}else {

			// 메일구현
			String title = "인증번호 메일";
			Random random = new Random();
			String contentNum = String.valueOf(100000+random.nextInt(900000));
			
			HttpSession session = request.getSession(); 
			session.invalidate(); // 3분안에 재 전송시 비이상적 접근 방지
			session = request.getSession(true);
			request.getSession().setMaxInactiveInterval(180); //3분 설정
			session.setAttribute("contentNum",contentNum); // 인증번호를 세션에 저장
			session.setAttribute("id",id); // 아이디를 세션에 저장
			String content = "인증번호는 "+contentNum+"입니다.";
			String user_name = "joo888889@naver.com";
			String password = "wnGHD123";
			String toEmail = sendEmail;
			// 메일보내기
			SendMail sendMail = new SendMail();
			sendMail.goMail(sendMail.setting(new Properties(), user_name, password),title,content,toEmail);
			
			// 데이터베이스에 인증번호 저장
			mdao.sendPass(id,contentNum);
			
			response.sendRedirect("searchPass2.jsp");
			
		}
	}


}
