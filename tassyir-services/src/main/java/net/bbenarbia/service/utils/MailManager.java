package net.bbenarbia.service.utils;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import net.bbenarbia.domain.enums.ParameterCode;
import net.bbenarbia.service.IParameterService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.stereotype.Service;

@Service("mailService")
public class MailManager implements IMailManager{

	static final private Log logger = LogFactory.getLog(MailManager.class);
	
	private MailSender mailSender;
	
	@Autowired
	IParameterService parameterService;

	@Override
	public void sendMail(String toMail, String text, String object) {

		String EtatServiceMail = parameterService.getParameterName(ParameterCode.ETAT_SERVICE_MAIL.toString()).get(0).getValue();
		String mailAdmin = parameterService.getParameterName(ParameterCode.MAIL_ADMIN.toString()).get(0).getValue();

		
		
		final String username = "benaissa.benarbia";
		final String password = "Mohben.wal:";
 
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
 
		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
 
		try {
 
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(toMail));
			message.setSubject(object);
			message.setText(text);
 
			Transport.send(message);
 
			System.out.println("Done");
 
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	
	
//		if (EtatServiceMail.equals("true")) {
//			SimpleMailMessage msg = new SimpleMailMessage();
//			msg.setFrom(mailAdmin);
//			msg.setSubject(object);
//			msg.setTo(toMail);
//			msg.setText(text);
//			logger.info("Mail send to :" + toMail);
//			try {
//				this.mailSender.send(msg);
//			} catch (MailException ex) {
//				System.err.println(ex.getMessage());
//			}
//		} else {
//			logger.info("Serive d'envoie de mail désactivé:");
//		}
//	}

//	public void setMailSender(MailSender mailSender) {
//		this.mailSender = mailSender;
//	}
	
}
