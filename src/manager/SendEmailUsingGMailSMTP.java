package manager;

import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

import java.util.Properties;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class SendEmailUsingGMailSMTP {
	private static Properties p = null;
	public static void sendMail(String name,String title,String mail,String tel,String cell,String desc,String ip) throws IOException{
		HashMap<String,String> admins=new HashMap<String,String>(); 
		for(String s:admins.keySet()){
//			JOptionPane.showMessageDialog(null, admins.get(s), "訊息", JOptionPane.INFORMATION_MESSAGE);
			main(new String[]{s,admins.get(s),name,title,ip,mail,tel,cell,desc});			
		}
	}
	
	
   public static void main(String[] args) {
//	   args=new String[]{"1","jerbluba@healthtib.com","1","1","1","1","1","1","1","1","1", };
      // Recipient's email ID needs to be mentioned.
      String to = args[1];//change accordingly

      // Sender's email ID needs to be mentioned
      String from = "service@healthtib.com";//change accordingly
      final String username = "service@healthtib.com";//change accordingly
      final String password = "Zombie07729080";//change accordingly

      // Assuming you are sending email through relay.jangosmtp.net
      String host = "smtp.gmail.com";

      Properties props = new Properties();
      props.put("mail.smtp.auth", "true");
      props.put("mail.smtp.starttls.enable", "true");
      props.put("mail.smtp.host", host);
      props.put("mail.smtp.port", "587");

      // Get the Session object.
      Session session = Session.getInstance(props,
      new javax.mail.Authenticator() {
         protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(username, password);
         }
      });

      try {
         // Create a default MimeMessage object.
         Message message = new MimeMessage(session);

         // Set From: header field of the header.
         message.setFrom(new InternetAddress(from));

         // Set To: header field of the header.
         message.setRecipients(Message.RecipientType.TO,
         InternetAddress.parse(to));

         // Set Subject: header field
         message.setSubject("["+args[3]+"]來自 "+args[2]);

         // Now set the actual message
         message.setText(
        	 "Dear "+args[0]+" :\n\r"
        	+"來自: "	+args[4]+"\n\r"
        	+"email: "+args[5]+"\n\r"
        	+"連絡電話: "+args[6]+"\n\r"
        	+"手機號碼: "+args[7]+"\n\n"+"\r"+"\r"
            + args[8]
            );

         // Send message
         Transport.send(message);

//         System.out.println("Sent message successfully....");

      } catch (MessagingException e) {
            throw new RuntimeException(e);
      }
   }
}