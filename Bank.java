import java.util.HashMap;

public class Bank {
    private static Bank bank;
    HashMap<Customer, Integer> records = new HashMap<Customer, Integer>();
    public String _name;

    private Bank() {
    }

    public static Bank getBank() {
        if (bank == null)
            bank = new Bank();

        return bank;
    }

    public void registerCustomer(Customer c) {
        records.put(c, 0);
        System.out.println("\n New Customer registered");
    }

    public void depositMoney(Customer c, int amt) {
        try {
            if (records.containsKey(c)) {
                records.put(c, records.get(c) + amt);
                System.out.println("\n Amount deposited");
            } else {
                throw new AccountDoesntExistException("Account doesn't exist in records");
            }
        } catch (AccountDoesntExistException ex) {
            System.out.println("Exception caught");
        }
    }

    public void withdrawMoney(Customer c, int amt) {
        try {
            if (records.containsKey(c)) {
                records.put(c, records.get(c) - amt);
                System.out.println("\n Amount withdrawn");
            } else {
                throw new AccountDoesntExistException("Account doesn't exist in records");
            }
        } catch (AccountDoesntExistException ex) {
            System.out.println("Exception caught");
        }
    }
}
