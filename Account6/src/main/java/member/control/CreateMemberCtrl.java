package member.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.dao.MemberDAO;

@WebServlet("/CreateMemberCtrl")
public class CreateMemberCtrl extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		MemberDAO mdao = new MemberDAO();
		int check = mdao.checkEqualsID(id);
        if (check == 1) {
            // 이미 사용 중인 아이디일 경우
            response.getWriter().write("{\"status\":1}");
        } else {
            // 사용 가능한 아이디일 경우        	
            response.getWriter().write("{\"status\":0}"); 
        } 
	}

}
