public final class Customer extends Person {
    private int customerid;

    public Customer(CustomerBuilder customerBuilder) {
        super(customerBuilder.name);
        this.customerid = customerBuilder.customerid;
    }

    public String getCustomerName() {
        return name;
    }

    public int getCustomerID() {
        return customerid;
    }

    @Override
    public int hashCode() {
        int hashcode = 0;
        hashcode = this.customerid * 20;
        hashcode += this.name.hashCode();
        return hashcode;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Customer) {
            Customer c = (Customer) obj;
            return (c.customerid == this.customerid && c.name.equals(this.name));
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + customerid + ", name='" + name + "'}";
    }

    public static final class CustomerBuilder {
        private int customerid;
        private String name;

        private CustomerBuilder() {
        }

        public static CustomerBuilder aCustomer() {
            return new CustomerBuilder();
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
