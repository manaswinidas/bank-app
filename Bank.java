import java.util.HashMap;
import java.util.Set;

class AccountDoesntExistException extends Exception {
    public AccountDoesntExistException(String s) {
        super(s);
    }
}

public class Bank {
    private static Bank bank = null;
    public String _name;

    private Bank() {
        _name = "ABC bank";
    }

    public static Bank getBank() {
        if (bank == null)
            bank = new Bank();

        return bank;
    }

    HashMap<Customer, Integer> records = new HashMap<Customer, Integer>();

    public void registerCustomer(Customer c) {
        records.put(c, 0);
        System.out.println("\n New Customer registered");
    }

    public void depositMoney(Customer c, int amt) {
        try {
            for(Customer ex:records.keySet()){
                if(ex.hashCode()==c.hashCode()){
                    records.put(ex, records.get(ex)+amt);
                    System.out.println("\n Amount deposited");
            } else {
                throw new AccountDoesntExistException("Account doesn't exist in records");
            }}
        } catch (AccountDoesntExistException ex) {
            System.out.println("Exception caught");
        } 
    }

    public void withdrawMoney(Customer c, int amt) {
        try {
            for(Customer ex:records.keySet()){
                if(ex.hashCode()==c.hashCode()){
                    records.put(ex, records.get(ex)-amt);
                    System.out.println("\n Amount withdrawn");
            } else {
                throw new AccountDoesntExistException("Account doesn't exist in records");
            }}
        } catch (AccountDoesntExistException ex) {
            System.out.println("Exception caught");
        }
        System.out.println("\n Amount withdrawn");
    }

    public void getBalance(Customer c) {
        System.out.println(records.get(c));
    }

    public void getAllCustomers(HashMap<Customer, Integer> map){
         
        Set<Customer> keys = map.keySet();
        for(Customer p:keys){
            System.out.println(p.toString()+"==>"+map.get(p));
        }
    }
}
