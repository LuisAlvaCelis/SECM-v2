package mail;

public class Mail {
    
    private String userMail,passwordMail,destiny,subject,message,file;

    public Mail(String userMail, String passwordMail, String destiny, String subject, String message,String file) {
        this.userMail = userMail;
        this.passwordMail = passwordMail;
        this.destiny = destiny;
        this.subject = subject;
        this.message = message;
        this.file=file;
    }

    public Mail() {}
    
    public String getFile(){
        return file;
    }
    
    public void setFile(String file){
        this.file=file;
    }
    
    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public String getPasswordMail() {
        return passwordMail;
    }

    public void setPasswordMail(String passwordMail) {
        this.passwordMail = passwordMail;
    }

    public String getDestiny() {
        return destiny;
    }

    public void setDestiny(String destiny) {
        this.destiny = destiny;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
}
