package com.mis.mis_web_app_api.modules.category;

import com.mis.mis_web_app_api.exceptions.ApiException;
import com.mis.mis_web_app_api.constants.MessageResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@Slf4j
public class CategoryController {
    private final CategoryService categoryService;
    MessageResponse messageResponse;

    @PostMapping("/api/categories")
    public ResponseEntity<Object> getCategories(@RequestBody Category req) {
        messageResponse = new MessageResponse();
        try {
            log.info("Intercept get all categories");
            messageResponse.setGetDataSuccess(categoryService.getAllCategories(req));
            return new ResponseEntity<>(messageResponse, HttpStatus.OK);
        }catch (ApiException e){
            log.error("Error while getting all categories{}", e.getMessage());
            return new ResponseEntity<>(messageResponse, HttpStatus.OK);
        }catch (Throwable e){
            log.error("General error while getting all categories{}", e.getMessage());
            return new ResponseEntity<>(messageResponse, HttpStatus.OK);
        }finally {
            log.info("Intercept get all categories{}", messageResponse.getMessage());
        }
    }

    @PostMapping("/api/getCategoryById")
    public ResponseEntity<Object> getCategoryById(@RequestBody Category req) {
        messageResponse = new MessageResponse();
        try{
            log.info("Intercept get category by id");
            messageResponse.setGetDataSuccess(categoryService.getCategoryById(req));
            return new ResponseEntity<>(messageResponse, HttpStatus.OK);
        }catch (ApiException e){
            log.error("Error while getting category by id {}", e.getMessage());
            messageResponse.setMessage(e.getMessage());
            return new ResponseEntity<>(messageResponse,HttpStatus.OK);
        }catch (Throwable e){
            log.error("General error while getting category by id {}",e.getMessage());
            return new ResponseEntity<>(messageResponse,HttpStatus.INTERNAL_SERVER_ERROR);
        }finally {
            log.info("Intercept get category by id {}", req);
        }
    }

    @PostMapping("/api/categories/create")
    public ResponseEntity<Object> createCategory(@RequestBody Category req){
        messageResponse = new MessageResponse();
        try {
            log.info("Intercept create new category");
            messageResponse.setCreateDataSuccess(categoryService.saveCategory(req));
            return new ResponseEntity<>(messageResponse,HttpStatus.OK);
        }catch (ApiException e){
            log.error("Error while creating new category{}",e.getMessage());
            messageResponse.setMessage(e.getMessage());
            return new ResponseEntity<>(messageResponse,HttpStatus.OK);
        }catch (Throwable e){
            log.error("General error while create new category");
            return new ResponseEntity<>(messageResponse,HttpStatus.INTERNAL_SERVER_ERROR);
        }finally {
            log.info("Intercept create new category");
        }
    }

    @PostMapping("/api/categories/update")
    public ResponseEntity<Object> updateCategory(@RequestBody Category req){
        messageResponse = new MessageResponse();
        try{
            log.info("Intercept update category{}",req.getCategoryId());
            categoryService.updateCategory(req);
            messageResponse.setUpdateDataSuccess(req);
            return new ResponseEntity<>(messageResponse,HttpStatus.OK);
        }catch (ApiException e){
            log.error("Error while updating category");
            return new ResponseEntity<>(messageResponse,HttpStatus.OK);
        }catch (Throwable e){
            log.error("General error while updating category");
            return new ResponseEntity<>(messageResponse,HttpStatus.INTERNAL_SERVER_ERROR);
        }finally {
            log.info("Intercept update category");
        }
    }

    @PostMapping("/api/categories/delete")
    public ResponseEntity<Object> deleteCategory(@RequestBody Category req){
        messageResponse = new MessageResponse();
        try {
            log.info("Intercept delete category{}",req.getCategoryId());
            categoryService.deleteCategory(req);
            messageResponse.setDeleteDataSuccess(req);
            return new ResponseEntity<>(messageResponse,HttpStatus.OK);
        }catch (ApiException e){
            log.error("Error while deleting category{}",req.getCategoryId());
            messageResponse.setMessage(e.getMessage());
            return new ResponseEntity<>(messageResponse,HttpStatus.OK);
        }catch (Throwable e){
            log.error("General error while deleting category{}",req.getCategoryId());
            return new ResponseEntity<>(messageResponse,HttpStatus.INTERNAL_SERVER_ERROR);
        }finally {
            log.info("Intercept delete category");
        }
    }

}

