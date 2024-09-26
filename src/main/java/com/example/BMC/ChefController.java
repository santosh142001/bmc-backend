package com.example.BMC;

import com.example.BMC.entity.Chef;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Chef")
public class ChefController {
    @Autowired
    private ChefService chefService;

    @PostMapping("/createChef")
    public Chef createChef(@RequestBody Chef chef){
        return chefService.createChef(chef);
    }

    @GetMapping("/getAllChefs")
    public List<Chef> getAll(){
        return chefService.getChefs();
    }
}
