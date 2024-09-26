package com.example.BMC.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "chef")
public class Chef {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "chef_name")
    private String chefName;

    @Column(name = "phone")
    private Long phone;

    @Column(name = "mail")
    private String mail;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "city_id", referencedColumnName = "id", insertable = false, updatable = false)
    private City city;

    @ManyToMany
    @JoinTable(
            name = "chef_location",
            joinColumns = @JoinColumn(name = "chef_id"),
            inverseJoinColumns = @JoinColumn(name = "location_id")
    )
    private Set<Location> location = new HashSet<>();

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_on")
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