package com.example.BMC;

import com.example.BMC.Repositories.ChefRepository;
import com.example.BMC.Repositories.CityRepository;
import com.example.BMC.entity.Chef;
import com.example.BMC.entity.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChefService {
    @Autowired
    private ChefRepository chefRepository;
    @Autowired
    private CityRepository cityRepository;
    public Chef createChef(Chef chef) {
        Optional<Chef> existingMail = chefRepository.findByMail(chef.getMail());
        City city = cityRepository.findById(chef.getCity().getId()).orElse(null);
        chef.setCity(city);
        if (chef.getChefName()==null) {
            throw new NullPointerException();
        } else if (existingMail.isPresent()) {
            throw new IllegalArgumentException("a chef with same mail exists");
        } else if (chef.getPhone()==null) {
            throw new NullPointerException();
        }
        return chefRepository.save(chef);
    }

    public List<Chef> getChefs(){
        return chefRepository.findAll();
    }

    public Chef getChef(Long id){
        Optional<Chef> chef = chefRepository.findById(id);
        return chef.orElse(null);
    }
    public Chef updateChef(Chef chef){
        Optional<Chef> chefid = chefRepository.findById(chef.getId());
        if(chefid.isPresent()){
            return chefRepository.save(chef);
        }
        return null;
    }
}