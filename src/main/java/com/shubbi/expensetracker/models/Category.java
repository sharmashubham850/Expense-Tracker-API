package com.shubbi.expensetracker.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer categoryId;

    @Column(nullable = false)
    private String title;

    private String description;

    @Column(name="total_expense")
    private Float totalExpense = 0.0F;

    @ManyToOne
    @JoinColumn(name="fk_user_id", nullable = false)
    @JsonIncludeProperties(value = {"id", "email"})
    private User user;

    public Category() {
    }

    public Category(String title, String description, User user) {
        this.title = title;
        this.description = description;
        this.user = user;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getTotalExpense() {
        return totalExpense;
    }

    public void setTotalExpense(Float totalExpense) {
        this.totalExpense = totalExpense;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
