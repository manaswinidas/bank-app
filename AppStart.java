import java.util.*;

public class AppStart{
    public static void main(String[] args){
        int id;
        String name;
        int amt;
        char ch;
        Bank b = Bank.getBank();
        Customer c=null;
        Scanner sc=new Scanner(System.in);
        do{
        System.out.println("\n Which action do you want to do? Enter your choice:");
        System.out.println("\n1.Register customer");        
        System.out.println("\n2.Deposit amount against a customer");
        System.out.println("\n3.Withdraw amount from a Customer's account");
        System.out.println("\n4.Get balance");
        System.out.println("\n5.Get all customers");
        int choice=sc.nextInt();
        switch(choice){
            case 1:
                System.out.println("\n How many customers(1-10) do you want to register?");
                int n=sc.nextInt();
                for(int i=0;i<n;i++){
                System.out.println("Enter the id of customer:");
                id=sc.nextInt();
                sc.nextLine();
                System.out.println("Enter the name of customer:");
                name=sc.nextLine();
                c=Customer.CustomerBuilder.aCustomer().withId(id).withName(name).build();
                b.registerCustomer(c);
                }
                break;
            case 2:
                System.out.println("Enter the id of customer:");
                id=sc.nextInt();
                sc.nextLine();
                System.out.println("Enter the name of customer:");
                name=sc.nextLine();
                c=Customer.CustomerBuilder.aCustomer().withId(id).withName(name).build();
                System.out.println("Enter the amount to be deposited:");
                amt=sc.nextInt();
                b.depositMoney(c, amt);
                break;
            case 3:
                System.out.println("Enter the id of customer:");
                id=sc.nextInt();
                sc.nextLine();
                System.out.println("Enter the name of customer:");
                name=sc.nextLine();
                c=Customer.CustomerBuilder.aCustomer().withId(id).withName(name).build();
                System.out.println("Enter the amount to be withdrawn:");
                amt=sc.nextInt();
                b.withdrawMoney(c, amt);
                break;
            case 4:
                System.out.println("Enter the id of customer:");
                id=sc.nextInt();
                sc.nextLine();
                System.out.println("Enter the name of customer:");
                name=sc.nextLine();
                c=Customer.CustomerBuilder.aCustomer().withId(id).withName(name).build();
                if(b.records.containsKey(c)){
                    b.getBalance(c);
                } 
                break;
            case 5:
                b.getAllCustomers(b.records);
                break;
            }

        System.out.println("Do you want to continue[y/n]?");
        ch=sc.next().charAt(0);
        }while(ch!='n');
    }
}