package com.mis.mis_web_app_api.modules.category;

import com.mis.mis_web_app_api.exceptions.ApiException;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories(Category category) throws ApiException;
    Category getCategoryById(Category req) throws ApiException;
    Category saveCategory(Category req) throws ApiException;
    void updateCategory(Category req) throws ApiException;
    void deleteCategory(Category req) throws ApiException;
}
