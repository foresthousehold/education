package com.example.demo.model.form;

import java.util.List;

import com.example.demo.entity.Category;
import com.example.demo.entity.Dish;

/**
 * 検索フォーム(クエスト)
 */
public class SearchForm {

    /** 料理Id */
    private Long dishId;

    /** 分類1Id */
    private Long categoryId1;

    /** 分類2Id */
    private Long categoryId2;

    /** 選択肢(料理名) */
    private List<Dish> dishes;

    /** 選択肢(分類名1) */
    private List<Category> categories1;

    /** 選択肢(分類名2) */
    private List<Category> categories2;

    public Long getDishId() {
        return dishId;
    }

    public void setDishId(Long dishId) {
        this.dishId = dishId;
    }

    public Long getCategoryId1() {
        return categoryId1;
    }

    public void setCategoryId1(Long categoryId1) {
        this.categoryId1 = categoryId1;
    }

    public Long getCategoryId2() {
        return categoryId2;
    }

    public void setCategoryId2(Long categoryId2) {
        this.categoryId2 = categoryId2;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public List<Category> getCategories1() {
        return categories1;
    }

    public void setCategories1(List<Category> categories1) {
        this.categories1 = categories1;
    }

    public List<Category> getCategories2() {
        return categories2;
    }

    public void setCategories2(List<Category> categories2) {
        this.categories2 = categories2;
    }

}
