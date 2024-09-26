package com.example.BMC.Repositories;

import com.example.BMC.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CityRepository extends JpaRepository<City, Long> {
    Optional<City> findById(Long id);
 }