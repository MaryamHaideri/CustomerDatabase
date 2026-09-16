//customer-database
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        CustomerRegister register = new CustomerRegister();

        CustomerMenu menu = new CustomerMenu(register);

        menu.start();
    }
}

