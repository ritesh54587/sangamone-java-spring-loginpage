package com.sangamone.LoginController;


import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;




public class Email {
	public static void newStudent(String ecompany, String ename, String email, String econtactno,String ecourse,String emessage ) {
		try {
			System.out.println("Enter into the email function");
			String from = "riteshkumaryadav.sangamone@gmail.com";
			String pass="gecjksaprmccbnnk";
			String to ="asharaniv.sangamone@gmail.com";
			String host="smtp.gmail.com";

			String cc= "riteshkumaryadav.sangamone@gmail.com,laluprasaddash23.sangamone@gmail.com";
			Properties prop = System.getProperties();
			prop.put("mail.smtp.starttls.enable", "true");
			prop.put("mail.smtp.host", host);
	   	    prop.put("mail.smtp.user", from);
	   	    prop.put("mail.smtp.password", pass);
	   	    prop.put("mail.smtp.port", "587");
	   	    prop.put("mail.smtp.auth", "true");

   	   Session session = Session.getDefaultInstance(prop);
   	   try{
   	      MimeMessage message1 = new MimeMessage(session);
   	      message1.setFrom(new InternetAddress(from));
   	      //message1.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
   	      message1.setRecipients(Message.RecipientType.CC, InternetAddress.parse(cc));
   	      message1.setSubject("Web Enquiry Form-  Registration done");
   	      message1.setContent(
   	    		"<body>"+
   	    		  "<div style='margin:25px;'>"+
   	    		  "<p>Dear <b><span style='font-size: 15px;'>"+ename+",</span> </b></p>" +
   	    		  "<p>Your Student registration has been done</p>"+
   	    		  "<p><b>BhashaVidya</b></p>"+
   	    		  "<p>User Email: <b>"+email+"</b></p>"+
   	    		  "<p>ContactNo: <b>"+econtactno+"</b></p>"+
   	    		 "<p>Grade: <b>"+ecourse+"</b></p>"+
   	    		  "<p>Message: <b>"+emessage+" </b></p>"+
   	    		
   	    		"</div"+
   	    		  "</body>" ,"text/html");

   	      Transport transport = session.getTransport("smtp");
   	      transport.connect(host, from, pass);
   	      transport.sendMessage(message1, message1.getAllRecipients());
   	      transport.close();
   	      }catch (MessagingException e) {
   	      e.printStackTrace();	
   	      }
		} catch (Exception e) {
		  e.printStackTrace();
		}
	}
	


	
	public static void exceptionEmail(String exception, String methodName) {
		try {
			String from = "riteshkumaryadav.sangamone@gmail.com";
			String pass="gecjksaprmccbnnk";
	   	   String to = "laluprasaddash23.sangamone@gmail.com";
	   	   String host = "smtp.gmail.com";
	   	   Properties prop = System.getProperties();
	   	   prop.put("mail.smtp.starttls.enable", "true");
	   	   prop.put("mail.smtp.host", host);
	   	   prop.put("mail.smtp.user", from);
	   	   prop.put("mail.smtp.password", pass);
	   	   prop.put("mail.smtp.port", "587");
	   	   prop.put("mail.smtp.auth", "true");

	   	   Session session = Session.getDefaultInstance(prop);
	   	   try{
	   	      MimeMessage message = new MimeMessage(session);
	   	      message.setFrom(new InternetAddress(from));
	   	      message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
	   	      //message.setRecipients(Message.RecipientType.CC, InternetAddress.parse(cc));
	   	      message.setSubject("Kannada Learning - Exception - " + methodName + "");
	   	      message.setContent(
	   	    		"<body>"+
	   	    		  "<div style='margin:25px;'>"+
	   	    		"<p>Method Name: <b>" + methodName +" </b></p>"+
	   	    		  "<p><b>"+ exception+" </b></p>"+
	   	    		
	   	    		"</div"+
	   	    		  "</body>" ,"text/html");

	   	      Transport transport = session.getTransport("smtp");
	   	      transport.connect(host, from, pass);
	   	      transport.sendMessage(message, message.getAllRecipients());
	   	      transport.close();
	   	      }catch (MessagingException e) {
	   	      e.printStackTrace();	
	   	      }
			} catch (Exception e) {
			  e.printStackTrace();
			}
	}
}
