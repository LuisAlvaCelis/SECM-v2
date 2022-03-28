package mail;

import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

public class ControllerMail {
    
    private static ControllerMail instance;
    
    public static ControllerMail getInstance(){
        return instance=new ControllerMail();
    }
    
    public boolean sendMail(Mail mail){
        boolean enviado = false;
        try{
            String host="smtp.gmail.com";
            Properties prop=System.getProperties();

            prop.put("mail.smtp.starttls.enable","true");
            prop.put("mail.smtp.host",host);
            prop.put("mail.smtp.user",mail.getUserMail());
            prop.put("mail.smtp.password",mail.getPasswordMail());
            prop.put("mail.smtp.port",587);
            prop.put("mail.smtp.auth","true");

            Session session=Session.getDefaultInstance(prop,null);
            MimeMessage message= new MimeMessage(session);

            message.setFrom(new InternetAddress(mail.getUserMail()));

            String[] toEmails = mail.getDestiny().split(";");
            if (toEmails != null && toEmails.length != 0) {
                InternetAddress[] internetAddressTO = new InternetAddress[toEmails.length];
                for (int i = 0; i < toEmails.length; i++) {
                    internetAddressTO[i] = new InternetAddress(toEmails[i]);
                }
                message.setRecipients(Message.RecipientType.TO, internetAddressTO);
            }
            message.setSubject(mail.getSubject());
            
            MimeMultipart multipart = new MimeMultipart();
            MimeBodyPart content = createContent(mail.getMessage());
            multipart.addBodyPart(content);
            /*Establecer adjunto
            String[] attachments = email.getAttachments();
            if (attachments != null && attachments.length != 0) {
                for (String filename: attachments) {
                    MimeBodyPart attachPart = createAttachment(filename);
                    multipart.addBodyPart(attachPart);
                }
            }*/
            
            MimeBodyPart attachPart = createAttachment(mail.getFile());
            multipart.addBodyPart(attachPart);
            
            message.setContent(multipart);
            message.saveChanges();

            try (Transport transport = session.getTransport("smtp")) {
                transport.connect(host,mail.getUserMail(),mail.getPasswordMail());
                
                transport.sendMessage(message, message.getAllRecipients());
            }
            enviado=true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return enviado;
    }
    
    
    public static MimeBodyPart createContent(String body) throws Exception {
        MimeBodyPart content = new MimeBodyPart();
        MimeMultipart multipart = new MimeMultipart();

        if (!body.isEmpty()) {
            MimeBodyPart htmlBodyPart = new MimeBodyPart();
            htmlBodyPart.setContent(body, "text/html;charset=UTF-8");
            multipart.addBodyPart(htmlBodyPart);
        }
        content.setContent(multipart);
        return content;
    }
    
    public static MimeBodyPart createAttachment(String filepath) throws Exception {
        MimeBodyPart attachPart = new MimeBodyPart();
        FileDataSource fileDataSource = new FileDataSource(filepath);
        attachPart.setDataHandler(new DataHandler(fileDataSource));
        attachPart.setFileName(MimeUtility.encodeText(fileDataSource.getName()));
        return attachPart;
    }
}
