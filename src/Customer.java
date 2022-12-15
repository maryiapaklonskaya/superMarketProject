// add collection of customers ( name, balance, email, phone )

public class Customer {
    private String name;
    private Double balance;
    private String email = "default email";
    private String phone = "default phone";

    public Customer(String name, Double balance, String email, String phone){
        this.name = name;
        this.balance = balance;
        this.email = email;
        this.phone = phone;
    }

    public Customer(String name, Double balance){
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public Double getBalance() {
        return balance;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString(){
        return "Customer name: " + name + " email: " + email + " balance: " + balance + " phone: " + phone;
    }
}
