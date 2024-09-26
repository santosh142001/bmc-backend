package com.example.BMC;

import com.example.BMC.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/user")
public class userController {
    @Autowired
    private UserService userService;
    @PostMapping("/createUser")
    public User createUser(@RequestBody User user){
        return  userService.createUser(user);
    }

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/getUser/{id}")
    public User getUser(@PathVariable Long id){
        return userService.getUser(id);
    }

    @PatchMapping("/deleteUser/ {id}")
    public void  deleteUser(@PathVariable  Long id){
        userService.deleteUser(id);
    }
}