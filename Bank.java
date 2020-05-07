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

    public void depositMoney(Customer c, int amt) throws AccountDoesntExistException {
        records.put(c, records.get(c) + amt);
        System.out.println("\n Amount deposited");
    }

    public void withdrawMoney(Customer c, int amt) throws AccountDoesntExistException {
        records.put(c, records.get(c) - amt);
        System.out.println("\n Amount withdrawn");
    }

    public int getBalance(Customer c) throws AccountDoesntExistException {
        return records.get(c);
    }
}
