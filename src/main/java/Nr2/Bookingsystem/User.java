package Nr2.Bookingsystem;

public class User {
    //Initialising private variables
    private String name;
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    //Getters
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }


    //toString for printing out to console
    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
