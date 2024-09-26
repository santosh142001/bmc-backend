package com.example.BMC.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "city_name", columnDefinition = "")
    private String cityName;

    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
    private Set<Location> location = new HashSet<>();
}
