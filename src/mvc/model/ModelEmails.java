package mvc.model;

import java.util.ArrayList;
import mysql.TableEmails;

public class ModelEmails {
    
    private int id;
    private String customer;
    private String email;

    public ModelEmails(int id, String customer, String email) {
        this.id = id;
        this.customer = customer;
        this.email = email;
    }

    public ModelEmails() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getEmailsTo(String search,String separate){
        String emails="";
        ArrayList<ModelEmails> listEmails=TableEmails.getInstance().getAll();
        for(int i=0;i<listEmails.size();i++){
            ModelEmails aux=listEmails.get(i);
            if(aux.getCustomer().equalsIgnoreCase(search)){
                emails=emails+aux.getEmail()+separate;
            }
        }
        emails = (String) emails.subSequence(0, emails.length() -2);
        return emails;
    }
}
