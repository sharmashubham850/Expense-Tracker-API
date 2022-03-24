package com.shubbi.expensetracker.repositories;

import com.shubbi.expensetracker.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    @Query("SELECT c FROM Category c WHERE c.user.id=?1")
    List<Category> findAllByUserId(Integer id);
}
