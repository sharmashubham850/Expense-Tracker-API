package com.shubbi.expensetracker.controllers;

import com.shubbi.expensetracker.exceptions.EtAuthException;
import com.shubbi.expensetracker.models.Category;
import com.shubbi.expensetracker.models.User;
import com.shubbi.expensetracker.repositories.CategoryRepository;
import com.shubbi.expensetracker.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private CategoryRepository categoryRepository;
    private UserRepository userRepository;

    private final Integer LOGGED_IN_USER_ID=1;

    @Autowired
    public CategoryController(CategoryRepository categoryRepository, UserRepository userRepository){
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("")
    public List<Category> getAllCategories(@RequestParam(value = "userid", required = false) Integer userId){
        if (userId != null){
            return categoryRepository.findAllByUserId(userId);
        }
        return categoryRepository.findAll();
    }

    @PostMapping("")
    public Category addCategory(@RequestBody Category category){
        User loggedInUser = userRepository.findById(LOGGED_IN_USER_ID).orElseThrow(
                () -> new EtAuthException("No Logged In User found")
        );

        category.setUser(loggedInUser);
        return categoryRepository.save(category);
    }
}
