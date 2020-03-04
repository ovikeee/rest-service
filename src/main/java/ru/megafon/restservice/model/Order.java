package ru.megafon.restservice.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table
public class Order {
    @Id
    @GeneratedValue
    private int id;

    @Column
    private Long reporterId;
    @Column
    private Long assigneeId;
    @Column
    private String description;
    @Column
    private String summary;
    @Column
    private Date createdDate;
    @Column
    private Status status;



    enum Status {
        OPEN,
        IN_PROGRESS,
        CLOSED
    }
}
