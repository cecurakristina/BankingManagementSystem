package bankingManagementSystem;

public class Customer {
    private String custid;
    private String name;
    private String email;

    //constructor
    public Customer(String custid, String name, String email) {
        this.custid = custid;
        this.name = name;
        this.email = email;
    }

    //getters and setters
    public String getCustId() {
        return custid;
    }

    public void setCustId(String custid) {
        this.custid = custid;
    }

    public String getCustName() {
        return name;
    }

    public void setCustName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
