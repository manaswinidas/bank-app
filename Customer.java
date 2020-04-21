public final class Customer extends Person{
    private final int customerid;
    private final String name;
    public Customer(CustomerBuilder customerBuilder) {
        this.customerid = customerBuilder.customerid;
        this.name = customerBuilder.name;

    }
    
    public String getCustomerName() {
        return name;
    }
 
    public int getCustomerID() {
        return customerid;
    }

    @Override
    public int hashCode(){
        System.out.println("In hashcode");
        int hashcode = 0;
        hashcode = this.customerid*20;
        hashcode += this.name.hashCode();
        return hashcode;
    }

    @Override
    public boolean equals(Object obj){
        System.out.println("In equals");
        if (obj instanceof Customer) {
            Customer c = (Customer) obj;
            return (c.customerid==this.customerid && c.name == this.name);
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Customer{" +"id=" + customerid +", name='" +name+ "'}";
    }

    public static final class CustomerBuilder {
        private int customerid;
        private String name;
    
        private CustomerBuilder() {
        }
    
        public static CustomerBuilder aCustomer() {
            return new CustomerBuilder();
        }
    
        public static CustomerBuilder aCustomer(Customer customer) {
            return aCustomer().withId(customer.getCustomerID()).withName(customer.getCustomerName());
        }
    
        public CustomerBuilder withId(int id) {
            this.customerid = id;
            return this;
        }
    
        public CustomerBuilder withName(String name) {
            this.name = name;
            return this;
        }
    
        public Customer build() {
            return new Customer(this);
        }
    
    }
}
