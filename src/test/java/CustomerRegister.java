//CustomerRegister
import java.util.ArrayList;


public class CustomerRegister {

    private ArrayList<Customer> customers;

    public CustomerRegister() {

        customers = new ArrayList<>();
    }

    public String addCustomer(Customer customer) {

        if (findCustomer(customer.getName()) != null) {
            return "Navnet er allerede registrert.";
        }

        if (phoneExists(customer.getPhone())) {
            return "Telefonnummeret er allerede registrert.";
        }

        if (emailExists(customer.getEmail())) {
            return "E-postadressen er allerede registrert.";
        }

        customers.add(customer);
        return "Kunden er lagt til!";
    }

    public ArrayList<Customer> getAllCustomers() {
        return customers;
    }


    // Finn kunde med ID
    public Customer findCustomerById(int id) {

        for (Customer customer : customers) {
            if (customer.getId() == id) {
                return customer;
            }
        }

        return null;
    }

    public Customer findCustomer(String name) {
        for (Customer customer : customers) {
            if (customer.getName().equals(name)) {
                return customer;
            }
        }

        return null;
    }

    public boolean removeCustomer(String name) {
        Customer customer = findCustomer(name);

        if (customer != null) {
            customers.remove(customer);
            return true;
        }

        return false;
    }

    public boolean phoneExists(String phoneNumber) {
        for (Customer customer : customers) {
            if (customer.getPhone().equals(phoneNumber)) {
                return true;
            }
        }

        return false;
    }

    public boolean emailExists(String email) {
        for (Customer customer : customers) {
            if (customer.getEmail().equalsIgnoreCase(email)) {
                return true;
            }
        }

        return false;
    }


}
