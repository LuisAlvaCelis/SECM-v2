package mvc.model;

public class ModelDataCustomers {
    
    private int id;
    private String dni;
    private String codeCustomer;
    private String customer;
    private String amount_campaign;
    private String amount_total;
    private String banco;

    public ModelDataCustomers(int id, String dni, String codeCustomer, String customer, String amount_campaign, String amount_total, String banco) {
        this.id = id;
        this.dni = dni;
        this.codeCustomer = codeCustomer;
        this.customer = customer;
        this.amount_campaign = amount_campaign;
        this.amount_total = amount_total;
        this.banco = banco;
    }

    public ModelDataCustomers() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCodeCustomer() {
        return codeCustomer;
    }

    public void setCodeCustomer(String codeCustomer) {
        this.codeCustomer = codeCustomer;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getAmount_campaign() {
        return amount_campaign;
    }

    public void setAmount_campaign(String amount_campaign) {
        this.amount_campaign = amount_campaign;
    }

    public String getAmount_total() {
        return amount_total;
    }

    public void setAmount_total(String amount_total) {
        this.amount_total = amount_total;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }
}