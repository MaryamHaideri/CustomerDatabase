import java.util.Scanner;


public class CustomerMenu {

    private CustomerRegister register;
    private Scanner scanner;

    public CustomerMenu(CustomerRegister register) {
        this.register = register;
        this.scanner = new Scanner(System.in);
    }

    public void start() {

        boolean running = true;

        while (running) {

            System.out.println("\n--- KUNDEREGISTER ---");
            System.out.println("1. Legg til kunde");
            System.out.println("2. Vis alle kunder");
            System.out.println("3. Finn kunde");
            System.out.println("4. Slett kunde");
            System.out.println("5. Avslutt");

            //hva hvis valget er å legge til kunder
            System.out.print("Velg et alternativ: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Ugyldig valg. Skriv et tall mellom 1 og 5.");
                scanner.next();
                continue;
            }

            int choice = scanner.nextInt();
            if (choice == 1) {

                System.out.print("Skriv inn navn: ");
                scanner.nextLine();

                //sjekke navn
                String name = scanner.nextLine();

                while (name.trim().isEmpty()) {
                    System.out.println("Navnet kan ikke være tomt.");
                    System.out.print("Skriv inn navn: ");
                    name = scanner.nextLine();
                }

                //sjekke tlf.nr
                System.out.print("Skriv inn telefonnummer: ");
                String phoneNumber = scanner.next();

                while (!phoneNumber.matches("\\d+")) {
                    System.out.println("Ugyldig telefonnummer. Bruk bare tall.");
                    System.out.print("Skriv inn telefonnummer: ");
                    phoneNumber = scanner.next();
                }

                System.out.print("Skriv inn e-post: ");
                String email = scanner.next();

                while (!email.contains("@") || !email.contains(".")) {
                    System.out.println("Ugyldig e-postadresse.");
                    System.out.print("Skriv inn e-post: ");
                    email = scanner.next();
                }

                System.out.print("Ekstra notater: ");
                String note = scanner.next();

                int id = 1;
                Customer customer = new Customer(id, name, phoneNumber, email, note);

                String result = register.addCustomer(customer);

                System.out.println(result);
            }


            //hvis man velger andre alternativ
            if (choice == 2) {

                if (register.getAllCustomers().isEmpty()) {
                    System.out.println("Det finnes ingen kunder i registeret.");
                } else {

                    System.out.println("\n--- ALLE KUNDER ---");

                    for (Customer customer : register.getAllCustomers()) {
                        System.out.println(customer);
                    }
                }
            }


            //finne kunden
            if (choice == 3) {

//                System.out.print("Skriv inn navnet på kunden: ");
//                String name = scanner.next();
//
//                Customer customer = register.findCustomer(name);
//
//                if (customer != null) {
//                    System.out.println("\n--- KUNDE FUNNET ---");
//                    System.out.println("Navn: " + customer.getName());
//                    System.out.println("Telefon: " + customer.getPhone());
//                    System.out.println("E-post: " + customer.getEmail());
//                    System.out.println("Notat: " + customer.getNote());

                System.out.print("Skriv inn kunde-ID: ");

                int id = scanner.nextInt();

                Customer customer = register.findCustomerById(id);

                if (customer != null) {
                    System.out.println("\n--- KUNDE FUNNET ---");
                    System.out.println(customer);

                } else {
                    System.out.println("Kunden ble ikke funnet.");
                }
            }


            //sletter under
            if (choice == 4) {

                System.out.print("Skriv inn navnet på kunden du vil slette: ");
                //String name = scanner.next();
                //boolean removed = register.removeCustomer(name);
                int id = scanner.nextInt();

                boolean removed = register.removeCustomer(String.valueOf(id));

                if (removed) {
                    System.out.println("Kunden ble slettet.");
                } else {
                    System.out.println("Kunden ble ikke funnet.");
                }
            }


            //hvis vi selger en annen alternativ enn en eksisterende
            if (choice < 1 || choice > 5) {
                System.out.println("Ugyldig valg. Velg et tall mellom 1 og 5.");
            }

            //avslutter registrering
            if (choice == 5) {
                running = false;
                System.out.println("Programmet avsluttes.");
            }
        }
    }
}