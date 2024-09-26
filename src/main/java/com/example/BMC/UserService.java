package com.example.BMC;

import com.example.BMC.Repositories.RoleRepository;
import com.example.BMC.Repositories.UserRepository;
import com.example.BMC.entity.Role;
import com.example.BMC.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    public User createUser(User user) {
        if (user.getEmail() ==null) {
            throw new NullPointerException();
        }
        User mail = userRepository.findByEmail(user.getEmail()).orElse(null);
        User phone = userRepository.findByPhoneNumber(user.getPhoneNumber()).orElse(null);
        if (mail != null) {
            throw new IllegalArgumentException("mail already exists");
        }else if (user.getPhoneNumber() == null) {
            throw new NullPointerException();
        } else if (phone != null) {
            throw new IllegalArgumentException("phone number already exists");
        } else if(user.getPhoneNumber().length()!=10){
            throw new IllegalArgumentException("Enter a 10 digit valid phone number");
        }
        return userRepository.save(user);
    }
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    public User getUser(Long id){
        Optional<User> userid = userRepository.findById(id);
        return userid.orElse(null);
    }
    public void deleteUser(Long id){
        User user =   userRepository.findById(id).orElse(null);
        if(user!=null){
            user.setIsActive(false);
            userRepository.save(user);
        }

    }
}