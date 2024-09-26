package com.example.BMC.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "location_name")
    private String locationName;

    @Column(name = "city_id")
    private Long cityId;

    @ManyToOne
    @JoinColumn(name = "city_id", referencedColumnName = "id", insertable = false, updatable = false)
    private City city;

    @ManyToMany(mappedBy = "location")
    private Set<Chef> chef = new HashSet<>();
}
