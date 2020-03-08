package ru.megafon.restservice.model;
import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table (name = "usr")
public class User {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String login;
    @Column
    private Role role;
    @Column
    private String password;


    public User(){
    }

    public User(String login, Role role, String password) {
        this.login = login;
        this.role = role;
        this.password = password;
    }

    public static User createUser(String login, Role role, String password) {
        return new User(login, role, password);
    }

    public enum Role{
        USER,
        ADMINISTRATOR
    }
}
