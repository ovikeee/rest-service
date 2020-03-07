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
    private String name;
    @Column
    private Role role;

    public User(){
    }

    public User(Long id, String name, Role role) {
        this.id = id;
        this.name = name;
        this.role = role;
    }

    public User(String name, Role role) {
        this.name = name;
        this.role = role;
    }

    public enum Role{
        SUPPORT,
        CUSTOMER,
        OPERATOR,
        ADMINISTRATOR
    }
}
