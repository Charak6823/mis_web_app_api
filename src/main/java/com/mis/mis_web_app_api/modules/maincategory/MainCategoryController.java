package com.mis.mis_web_app_api.modules.maincategory;

import com.mis.mis_web_app_api.constants.Constants;
import com.mis.mis_web_app_api.constants.MessageResponse;
import com.mis.mis_web_app_api.exceptions.ApiException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
@RequiredArgsConstructor
public class MainCategoryController {
    private final MainCategoryService mainCategoryService;
    private MessageResponse messageResponse;

    @PostMapping("/api/categoryMains")
    public ResponseEntity<Object> getCategoryMains(@RequestBody MainCategory req) throws ApiException {
        try{
            messageResponse = new MessageResponse();
            messageResponse.setGetDataSuccess(mainCategoryService.getAllCategoryMain(req));
            log.info("Intercept all categoryMain");
            return new ResponseEntity<>(messageResponse,HttpStatus.OK);
        }catch (ApiException e){
            log.error("Error white retrieve all categoryMain{}",e.getMessage());
            return new ResponseEntity<>(messageResponse,HttpStatus.OK);
        }catch (Throwable e){
            log.error("General error white retrieve all categoryMain{}",e.getMessage());
            return new ResponseEntity<>(messageResponse, HttpStatus.OK);

        }finally {
            log.info("Intercept all categoryMain{}",messageResponse.getMessage());
        }
    }

    @PostMapping("/api/getCategoryMainById")
    public ResponseEntity<Object> getCategoryMainById(@RequestBody MainCategory req) throws ApiException {
        messageResponse = new MessageResponse();
        try{
            messageResponse.setGetDataSuccess(mainCategoryService.getCategoryMainById(req));
            log.info("Intercept categoryMain by Id");
            return new ResponseEntity<>(messageResponse,HttpStatus.OK);
        }catch(ApiException e){
            log.error("Error white retrieve categoryMain by Id {}",e.getMessage());
            return new ResponseEntity<>(e.getMessage(),HttpStatus.OK);
        }catch(Throwable e){
            log.error("General error while retrieve categoryMain by Id{}",e.getMessage());
            return new ResponseEntity<>(messageResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }finally {
            log.info("Intercept categoryMain by Id{}",messageResponse.getMessage());
        }
    }

    @PostMapping("/api/categoryMains/create")
    public ResponseEntity<Object> createCategoryMain(@RequestBody MainCategory req) throws ApiException {
        messageResponse = new MessageResponse();
        try{
            log.info("Intercept categoryMain create");
            messageResponse.setCreateDataSuccess(mainCategoryService.saveCategoryMain(req));
            return new ResponseEntity<>(messageResponse, HttpStatus.OK);
        }catch(ApiException e){
            log.error(Constants.LOG_ERR,e.getMessage());
            messageResponse = new MessageResponse();
            messageResponse.setMessage(e.getMessage());
            return new ResponseEntity<>(messageResponse, HttpStatus.BAD_REQUEST);
        }catch(Throwable e){
            log.error(Constants.LOG_UNKNOWN_ERR,e.getMessage());
            return new ResponseEntity<>(messageResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }finally{
            log.info("Intercept categoryMain create{}",messageResponse.getMessage());
        }
    }

    @PostMapping("/api/categoryMains/update")
    public ResponseEntity<Object> updateCategoryMain(@RequestBody MainCategory req) throws ApiException {
        messageResponse = new MessageResponse();
        try{
            log.info("Intercept categoryMain update");
            mainCategoryService.updateCategoryMain(req);
            messageResponse.setUpdateDataSuccess(req);
            return new ResponseEntity<>(messageResponse, HttpStatus.OK);
        }catch(ApiException e){
            log.error("Error while update categoryMain{}",e.getMessage());
            messageResponse.setMessage(e.getMessage());
            return new ResponseEntity<>(messageResponse, HttpStatus.OK);
        }catch (Throwable e){
            log.error("General error while update categoryMain{}",e.getMessage());
            messageResponse.setMessage(e.getMessage());
            return new ResponseEntity<>(messageResponse, HttpStatus.OK);
        }finally{
            log.info("Intercept categoryMain update{}",messageResponse.getMessage());
        }
    }

    @PostMapping("/api/categoryMains/delete")
    public ResponseEntity<Object> deleteCategoryMain(@RequestBody MainCategory req) throws ApiException {
        messageResponse = new MessageResponse();
        try{
            log.info("Intercept categoryMain delete{}",req.getCategoryMainId());
            mainCategoryService.deleteCategoryMain(req);
            messageResponse.setDeleteDataSuccess(req);
            return new ResponseEntity<>(messageResponse, HttpStatus.OK);
        }catch (ApiException e){
            log.error("Error while delete categoryMain{}",e.getMessage());
            return new ResponseEntity<>(messageResponse,HttpStatus.OK);

        }catch (Throwable e){
            log.error("General error while delete category{}",e.getMessage());
            return new ResponseEntity<>(messageResponse,HttpStatus.OK);
        }finally {
            log.info("Intercept categoryMain delete");
        }
    }
}
