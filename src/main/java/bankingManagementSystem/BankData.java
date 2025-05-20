package bankingManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class BankData {
    private static BankData instance = null;
    private List<Customer> customerList;
    private List<Account> accountList;

    //private constructor (Singleton)
    private BankData() {
        customerList = new ArrayList<>();
        accountList = new ArrayList<>();
        loadSampleData();
    }

    //public method to get the Singleton instance
    public static BankData getInstance() {
        if (instance == null) {
            instance = new BankData();
        }
        return instance;
    }

    //method to load data
    private void loadSampleData() {
        Customer c1 = new Customer("C101", "Alice", "alice@example.com");
        Customer c2 = new Customer("C102", "Bob", "bob@example.com");

        Account a1 = new Account("A201", "Checking", 1500.50, c1);
        Account a2 = new Account("A202", "Savings", 3000.00, c1);
        Account a3 = new Account("A203", "Checking", 2200.75, c2);

        customerList.add(c1);
        customerList.add(c2);

        accountList.add(a1);
        accountList.add(a2);
        accountList.add(a3);
    }

    //getters
    public List<Customer> getCustomerList() {
        return customerList;
    }

    public List<Account> getAccountList() {
        return accountList;
    }
}
