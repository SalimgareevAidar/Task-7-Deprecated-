package web.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NotNull(message = "Firstname shouldn't be empty")
    @Size(min = 2, max = 255, message = "Name should be between 2 and 255 characters")
    private String firstName;

    @Column(name = "last_name")
    @NotNull(message = "Lastname shouldn't be empty")
    @Size(min = 2, max = 255, message = "Name should be between 2 and 255 characters")
    private String lastName;

    @Column(name = "email")
    @NotNull(message = "Email shouldn't be empty")
    @Email(message = "Email should be valid")
    @Size(min = 2, max = 255, message = "Email should be between 2 and 255 characters")
    private String email;


    public User() {}

    public User(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString(){
        return "Имя: " + getFirstName() + " | Фамилия: " + getLastName() + " | Email: " + getEmail();
    }
}