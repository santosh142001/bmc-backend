package com.example.BMC.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "chef_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Chef chef;


    @ManyToOne
    @JoinColumn(name = "status_id")
    private OrderStatus orderStatus;

    // New fields for auditing
    @Column(name = "created_by", nullable = true)
    private String createdBy;

    @Column(name = "created_on", nullable = true)
    private LocalDateTime createdOn;

    @Column(name = "updated_by", nullable = true)
    private String updatedBy;

    @Column(name = "updated_on", nullable = true)
    private LocalDateTime updatedOn;

    @PrePersist
    public void prePersist() {
        this.createdOn = LocalDateTime.now();
        this.updatedOn = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedOn = LocalDateTime.now();
    }
}
