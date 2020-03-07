package ru.megafon.restservice.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Data
@Entity
@Table (name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @Column
    private String summary;
    @Column
    private String description;
    @Column
    private Long reporterId;
    @Column
    private Long assigneeId;
    @Column
    private Date createdDate;
    @Column
    private Status status;

    public Order(String summary, String description, Long reporterId, Long assigneeId) {
        this.summary = summary;
        this.description = description;
        this.reporterId = reporterId;
        this.assigneeId = assigneeId;
        this.createdDate = Calendar.getInstance().getTime();
        this.status = Status.OPEN;
    }

    public enum Status {
        OPEN,
        IN_PROGRESS,
        CLOSED
    }
}
