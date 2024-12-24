package com.mis.mis_web_app_api.modules.maincategory;

import com.mis.mis_web_app_api.exceptions.ApiException;

import java.util.List;
import java.util.Optional;

public interface MainCategoryService {
    List<MainCategory> getAllCategoryMain(MainCategory req) throws ApiException;
    Optional<MainCategory> getCategoryMainById(MainCategory req) throws ApiException;
    MainCategory saveCategoryMain(MainCategory req) throws ApiException;
    void updateCategoryMain(MainCategory req) throws ApiException;
    void deleteCategoryMain(MainCategory req) throws ApiException;
}
