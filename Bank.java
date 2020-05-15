import java.util.HashMap;

public class Bank {
    private static Bank bank;
    private HashMap<Customer, Integer> records = new HashMap<Customer, Integer>();
    private String _name="ABC bank";

    private Bank() {
    }

    public static Bank getBank() {
        if (bank == null)
            bank = new Bank();

        return bank;
    }

    public HashMap<Customer, Integer> getRecords() {
        return this.records;
    }

    public void registerCustomer(Customer c) {
        records.put(c, 0);
        System.out.println("\n New Customer registered");
    }

    public void depositMoney(Customer c, int amt) throws AccountDoesntExistException {
        if (records.containsKey(c)) {
            records.put(c, records.get(c) + amt);
        } else {
            throw new AccountDoesntExistException("Account doesn't exist in records") ;
        }
        System.out.println("\n Amount deposited");
    }

    public void withdrawMoney(Customer c, int amt) throws AccountDoesntExistException {
        if (records.containsKey(c)) {
            records.put(c, records.get(c) - amt);
        } else {
            throw new AccountDoesntExistException("Account doesn't exist in records");
        }
        System.out.println("\n Amount deposited");
    }

    public int getBalance(Customer c) throws AccountDoesntExistException {
        if (records.containsKey(c)) {
            return records.get(c);
        } else {
            throw new AccountDoesntExistException("Account doesn't exist in records");
        }
    }
}
