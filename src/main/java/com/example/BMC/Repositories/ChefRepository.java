package com.example.BMC.Repositories;

import com.example.BMC.entity.Chef;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ChefRepository extends JpaRepository<Chef, Long> {
    Optional<Chef>findByChefName(String chefName);
    Optional<Chef>findByMail(String mail);
}
