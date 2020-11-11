package Models;

public class User {
    private int id;
    private String firstName;
    private String surname;
    private String username;
    private String password;
    private String contactPhone;

    public User()
    {
        this.id = -1;
        this.contactPhone = null;
        this.firstName = null;
        this.password = null;
        this.surname = null;
        this.username = null;
    }

    public User(int id, String firstName, String surname, String username, String password, String contactPhone)
    {
        this.id = id;
        this.contactPhone = contactPhone;
        this.firstName = firstName;
        this.password = password;
        this.surname = surname;
        this.username = username;
    }

    public User(String firstName, String surname, String username, String password, String contactPhone)
    {
        this.contactPhone = contactPhone;
        this.firstName = firstName;
        this.password = password;
        this.surname = surname;
        this.username = username;
    }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname = surname; }

    public String getUsername() { return username; }
    public void setUsername() { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getContactPhone() { return contactPhone; }
    public void setContactPhone(String contactPhone) { this.contactPhone = contactPhone; }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
}
