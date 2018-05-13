/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package booth_ai;

/**
 *
 * @author xterminate
 */
import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendEmailWithAttachment {
       
    public SendEmailWithAttachment() {
        
      
    
    }
    
        
    
	public static void sendmail(String recepient)  {

		final String username = "";
		final String password = "";

		// setting gmail smtp properties
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		// check the authentication
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("teamxterminate@gmail.com"));

			// recipients email address
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recepient));

			// add the Subject of email
			message.setSubject("Your Personalized Selfie is Here");

			Multipart multipart = new MimeMultipart();

			// add the body message
			BodyPart bodyPart = new MimeBodyPart();
			bodyPart.setText("Hi,\n\nThanks for using our Booth. Your Selfie is attached below. Hope you use it again!\n\nRegards,\n\nTeam Xtermiate");
			multipart.addBodyPart(bodyPart);

			// attach the file
			MimeBodyPart mimeBodyPart = new MimeBodyPart();
			mimeBodyPart.attachFile(new File("/home/xterminate/project/output/Image.jpg"));
			multipart.addBodyPart(mimeBodyPart);

			message.setContent(multipart);

			Transport.send(message);

			System.out.println("Email Sent Successfully");

		} catch (MessagingException e) {
			e.printStackTrace();

		} catch (IOException ex) {
            Logger.getLogger(SendEmailWithAttachment.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
}