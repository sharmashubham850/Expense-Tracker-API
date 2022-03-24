package com.shubbi.expensetracker.controllers;

import com.shubbi.expensetracker.models.User;
import com.shubbi.expensetracker.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @GetMapping("")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @PostMapping("")
    public User addUser(@RequestBody User user){
        User savedUser = userRepository.save(user);
        return savedUser;
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") Integer userId){
        User user = userRepository.findById(userId).orElseThrow(
                () -> new RuntimeException("User with id " + userId + " not found")
        );
        return user;

    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable("id") Integer userId, @RequestBody User user){
        return userRepository.findById(userId).map(
                u -> {
                    u.setName(user.getName());
                    u.setEmail(user.getEmail());
                    u.setPassword(user.getPassword());
                    return userRepository.save(u);
                }
                ).orElseGet(
                () -> {
                    user.setId(userId);
                    return userRepository.save(user);
                }
        );
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") Integer userId){
        User user = userRepository.findById(userId).orElseThrow(
                () -> new RuntimeException("User with id " + userId + " not found")
        );

        userRepository.delete(user);

        return "User delete successful";
    }
}
