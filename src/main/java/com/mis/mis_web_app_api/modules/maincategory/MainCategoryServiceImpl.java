package com.mis.mis_web_app_api.modules.maincategory;

import com.mis.mis_web_app_api.exceptions.ApiException;
import lombok.AllArgsConstructor;
import org.eclipse.jdt.internal.compiler.batch.Main;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MainCategoryServiceImpl implements MainCategoryService {
    private final MainCategoryRepository mainCategoryRepository;

    public MainCategoryServiceImpl(MainCategoryRepository mainCategoryRepository){
        this.mainCategoryRepository = mainCategoryRepository;
    }

    @Override
    public List<MainCategory> getAllCategoryMain(MainCategory mainCategory) throws ApiException {
        return mainCategoryRepository.findAll();
    }

    @Override
    public Optional<MainCategory> getCategoryMainById(MainCategory req) throws ApiException {
        req = mainCategoryRepository.findById(req.getCategoryMainId()).orElse(null);
        if(req == null){
            throw new ApiException("Not found","រកមិនឃើញ","400");
        }
        return Optional.of(req);
    }

    @Override
    public MainCategory saveCategoryMain(MainCategory req) throws ApiException {
        var categoryMain = mainCategoryRepository.findByName(req.getName());
        if(categoryMain.isPresent()){
            throw new ApiException(" This categoryMain is already exist!","ប្រភេទចំម្បងនេះមានរួចហើយ!","400");
        }
        return mainCategoryRepository.save(req);
    }

    @Override
    public void updateCategoryMain(MainCategory req) throws ApiException {
        if(req == null){
            throw new ApiException("Not found!","រកមិនឃើញ","400");
        }
        mainCategoryRepository.save(req);
    }

    @Override
    public void deleteCategoryMain(MainCategory req) throws ApiException {
        var categoryMain = mainCategoryRepository.findById(req.getCategoryMainId());
        if(categoryMain.isEmpty()){
            throw new ApiException("Not found","រកមិនឃើញ","400");
        }
        mainCategoryRepository.delete(req);
    }
}
