package ru.megafon.restservice.model;
import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table
public class User {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String name;
    @Column
    private Role role;

    public User(){}

    enum Role{
        CUSTOMER,
        OPERATOR,
        ADMINISTRATOR
    }
}
