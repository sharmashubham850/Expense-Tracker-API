package com.shubbi.expensetracker.controllers;

import com.shubbi.expensetracker.models.Role;
import com.shubbi.expensetracker.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private RoleRepository roleRepository;

    @PostMapping("/newRole")
    public Role createNewRole(@RequestBody Role role){
        return roleRepository.save(role);
    }
}
