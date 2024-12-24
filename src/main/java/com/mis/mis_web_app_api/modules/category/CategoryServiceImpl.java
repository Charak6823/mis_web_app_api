package com.mis.mis_web_app_api.modules.category;

import com.mis.mis_web_app_api.exceptions.ApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories(Category req) throws ApiException {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Category req) throws ApiException {
        req= categoryRepository.findById(req.getCategoryId()).orElse(null);
        if(req==null){
            throw new ApiException("Not found","រកមិនឃើញ","400");
        }
        return req;
    }

    @Override
    public Category saveCategory(Category req) throws ApiException {
        var checkName = categoryRepository.findByCategoryName(req.getCategoryName());
        if(checkName != null){
            throw new ApiException("The category you enter is already exist!","ប្រភេទនេះមានរួចហើយ!","");
        }
        return categoryRepository.save(req);
    }

    @Override
    public void updateCategory(Category req) throws ApiException {
        var category = categoryRepository.findById(req.getCategoryId()).orElse(null);
        if(category == null){
            throw new ApiException("Not found","រកមិនឃើញ","");
        }
        categoryRepository.save(req);
    }

    @Override
    public void deleteCategory(Category req) throws ApiException {
        var category = categoryRepository.findById(req.getCategoryId()).orElse(null);
        if(category == null){
            throw new ApiException("Not found","រកមិនឃើញ","");
        }
        categoryRepository.delete(req);
    }
}
