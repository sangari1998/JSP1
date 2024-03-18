package member.control;

import javax.mail.PasswordAuthentication;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {
	
	final String ENCODING = "UTF-8";
	// 네이버 연결 포트
	final String PORT = "465";
	// 네이버일때
	final String SMTPHOST = "smtp.naver.com";
	// 발신메일 설정
	final String TO = "joo888889@naver.com";
	
	public Session setting(Properties props, String user_name,String password) {
		Session session = null;
		
		try {
			
			props.put("mail.transport.protocol", "smtp");
			props.put("mail.smtp.host", SMTPHOST);
			props.put("mail.smtp.port", PORT);
			props.put("mail.smtp.auth", true);
			props.put("mail.smtp.ssl.enable", true);
			props.put("mail.smtp.ssl.trust", SMTPHOST);
			props.put("mail.smtp.starttls.required", true);
			props.put("mail.smtp.starttls.enable", true);
			props.put("mail.smtp.ssl.protocols", "TLSv1.2");
		
			session = Session.getInstance(props, new Authenticator() {
				
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(user_name, password);
				}
			});
			
			
		} catch (Exception e) {
			System.out.println("session 세팅 실패");
		}
		
		return session;
	}
	
	public void goMail(Session session,String title,String content, String toEmail) {
		
		Message msg = new MimeMessage(session);
			
		try {
			// InternetAddress 첫번째 파라미터값으로 발신메일 변경가능
			msg.setFrom(new InternetAddress("joo888889@naver.com","관리자",ENCODING));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
			msg.setSubject(title);
			msg.setContent(content, "text/html;charset=utf-8");
			
			Transport.send(msg);
			
			System.out.println("이메일 보내기 성공1");
			
		} catch (Exception e) {
			System.out.println("이메일 보내기 실패");
		}
	}
}
