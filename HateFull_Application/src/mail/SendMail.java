package mail;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
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
import javax.swing.JOptionPane;

public class SendMail {
public static void Sendforgetpassword(String email,String pass)
{

	String to=email;
    
   final String user="projectinfodata67@gmail.com";
   final String epass="info@12345";
   Properties props = new Properties();
   props.put("mail.smtp.host", "smtp.gmail.com");
   props.put("mail.smtp.port", "587"); //this is optional
   props.put("mail.smtp.auth", "true");
   props.put("mail.smtp.starttls.enable", "true");

   Session session = Session.getInstance(props,new javax.mail.Authenticator() {    
   @Override
   protected PasswordAuthentication getPasswordAuthentication() {
   return new PasswordAuthentication(user,epass);
  }
  });
   
   try {
  MimeMessage message = new MimeMessage(session);
  message.setFrom(new InternetAddress(user));
  message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
  message.setSubject("Send Forget Password");
  message.setText("This is the Password for you \t:"+pass);


   Transport.send(message);
       System.out.println("sending");
       System.out.println("Send successfully");
       
       
    }
   catch(Exception e) 
   {
       System.out.println(e);
   }
	
	
	
	
	
	
	

	 } 
	public static void main(String[] args) {
		}

}
