import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



public class EmailOperations {

	public static final String USER = "michal04495";
	public static final String PASS = "michalek13";
	public static final String STMPAddress = "smtp.wp.pl";
	public static final String FROM = "michal04495@wp.pl";
	public static final String MESSAGETITLE = "Message from DigiPlanner app";
	private String to;
	private String message;

	public EmailOperations(String to, String message) {
		this.to = to;
		this.message = message;
	}

	public void sendMessage() {
		try {
			Properties props = new Properties();
			props.put("mail.smtp.host", STMPAddress);
			props.put("mail.smtp.port", "25");
			props.put("mail.smtp.auth", "true");
			javax.mail.Authenticator auth = new SMTPAuthenticator();
			Session session = Session.getInstance(props, auth);
			
			//tworzenie wiadomosci
			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(FROM));
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));
			msg.setSubject(MESSAGETITLE);
			msg.setText(message);
			msg.setHeader("TESTUJE", "DALEJ TESTUJE");
			msg.setSentDate(new Date());
			Transport.send(msg);
			System.out.println("poszlo");
		} catch (Exception e){
			e.printStackTrace();
		}
	}

	class SMTPAuthenticator extends javax.mail.Authenticator {
		public javax.mail.PasswordAuthentication getPasswordAuthentication() {
			return new javax.mail.PasswordAuthentication(USER, PASS);
		}
	}
}
