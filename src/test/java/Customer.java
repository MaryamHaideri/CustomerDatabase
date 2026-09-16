public class Customer {


    private int id;
    private String name;
    private String phone;
    private String email;
    private String note;
    private static int nextId = 1;

    public Customer(int id, String name, String phone, String email, String note) {

        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.note = note;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                "Navn: " + name +
                ",\nTelefon: " + phone +
                ",\nE-post: " + email +
                ",\nNotat: " + note;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

}

