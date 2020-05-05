import java.util.*;

public class AppStart {
    public static void main(String[] args) {
        char ch;
        Bank b = Bank.getBank();
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("\n Which action do you want to do? Enter your choice:");
            System.out.println("\n1.Register customer");
            System.out.println("\n2.Deposit amount against a customer");
            System.out.println("\n3.Withdraw amount from a Customer's account");
            System.out.println("\n4.Get balance");
            System.out.println("\n5.Get all customers");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("\n How many customers(1-10) do you want to register?");
                    int n = sc.nextInt();
                    for (int i = 0; i < n; i++) {
                        Customer c = getCustomerInfo();
                        b.registerCustomer(c);
                    }
                    break;
                case 2:
                    Customer c = getCustomerInfo();
                    System.out.println("Enter the amount to be deposited:");
                    int amt = sc.nextInt();
                    b.depositMoney(c, amt);
                    break;
                case 3:
                    c = getCustomerInfo();
                    System.out.println("Enter the amount to be withdrawn:");
                    amt = sc.nextInt();
                    b.withdrawMoney(c, amt);
                    break;
                case 4:
                    c = getCustomerInfo();
                    if (b.records.containsKey(c)) {
                        System.out.println(b.records.get(c));
                    }
                    break;
                case 5:
                    System.out.println(b.records);
                    break;
            }

            System.out.println("Do you want to continue[y/n]?");
            ch = sc.next().charAt(0);
        } while (ch != 'n');
    }

    public static Customer getCustomerInfo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the id of customer:");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the name of customer:");
        String name = sc.nextLine();
        Customer c= Customer.CustomerBuilder.aCustomer().withId(id).withName(name).build();
        return c;
    }
}