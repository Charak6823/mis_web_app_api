package com.mis.mis_web_app_api.modules.company;

import com.mis.mis_web_app_api.exceptions.ApiException;
import com.mis.mis_web_app_api.modules.BaseRequest;
import com.mis.mis_web_app_api.constants.MessageResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class CompanyController {
    @Autowired
    private CompanyService companyService;
    MessageResponse messageResponse;

    @GetMapping("/api/companies")
    public ResponseEntity<Object> getAll() throws ApiException {
        messageResponse = new MessageResponse();
        messageResponse.setGetDataSuccess(companyService.getAll());
        return new ResponseEntity<>(messageResponse, HttpStatus.OK);
    }
    @PostMapping("/api/companies/paginated")
    public ResponseEntity<Object> getAllWithPaginated(@RequestBody BaseRequest req) {
        MessageResponse messageResponse = new MessageResponse();
        try {
            log.info("Intercept get all warehouses with paginated");
            messageResponse.setGetDataSuccess(companyService.getAllWithPaginated(req));
            return new ResponseEntity<>(messageResponse, HttpStatus.OK);
        } catch (ApiException e) {
            log.error("Error while getting all warehouses{}", e.getMessage());
            return new ResponseEntity<>(messageResponse, HttpStatus.OK);
        } catch (Throwable e) {
            log.error("General error while getting all warehouses{}", e.getMessage());
            return new ResponseEntity<>(messageResponse, HttpStatus.OK);
        } finally {
            log.info("Intercept get all warehouses{}", messageResponse.getMessage());
        }
    }

    @PostMapping("/api/companies/getById")
    public ResponseEntity<Object> getById(@RequestBody Company req) {
        messageResponse = new MessageResponse();
        try{
            log.info("Intercept get warehouse by id");
            messageResponse.setGetDataSuccess(companyService.getById(req));
            return new ResponseEntity<>(messageResponse, HttpStatus.OK);
        }catch (ApiException e){
            log.error("Error while getting warehouse by id {}", e.getMessage());
            messageResponse.setMessage(e.getMessage());
            return new ResponseEntity<>(messageResponse,HttpStatus.OK);
        }catch (Throwable e){
            log.error("General error while getting warehouse by id {}",e.getMessage());
            return new ResponseEntity<>(messageResponse,HttpStatus.INTERNAL_SERVER_ERROR);
        }finally {
            log.info("Intercept get warehouse by id {}", req);
        }
    }

    @PostMapping("/api/companies/create")
    public ResponseEntity<Object> create(@RequestBody Company req){
        messageResponse = new MessageResponse();
        try {
            log.info("Intercept create new category");
            messageResponse.setCreateDataSuccess(companyService.save(req));
            return new ResponseEntity<>(messageResponse,HttpStatus.OK);
        }catch (ApiException e){
            log.error("Error while creating new warehouse{}",e.getMessage());
            messageResponse.setMessage(e.getMessage());
            return new ResponseEntity<>(messageResponse,HttpStatus.OK);
        }catch (Throwable e){
            log.error("General error while create new warehouse");
            return new ResponseEntity<>(messageResponse,HttpStatus.INTERNAL_SERVER_ERROR);
        }finally {
            log.info("Intercept create new warehouse");
        }
    }

    @PostMapping("/api/companies/update")
    public ResponseEntity<Object> update(@RequestBody Company req){
        messageResponse = new MessageResponse();
        try{
            log.info("Intercept update data{}",req.getCompanyId());
            companyService.update(req);
            messageResponse.setUpdateDataSuccess(req);
            return new ResponseEntity<>(messageResponse,HttpStatus.OK);
        }catch (ApiException e){
            log.error("Error while updating data");
            return new ResponseEntity<>(messageResponse,HttpStatus.OK);
        }catch (Throwable e){
            log.error("General error while updating data");
            return new ResponseEntity<>(messageResponse,HttpStatus.INTERNAL_SERVER_ERROR);
        }finally {
            log.info("Intercept update data");
        }
    }

    @PostMapping("/api/companies/delete")
    public ResponseEntity<Object> remove(@RequestBody Company req){
        messageResponse = new MessageResponse();
        try {
            log.info("Intercept delete data{}",req.getCompanyId());
            companyService.delete(req);
            messageResponse.setDeleteDataSuccess(req);
            return new ResponseEntity<>(messageResponse,HttpStatus.OK);
        }catch (ApiException e){
            log.error("Error while deleting data{}",req.getCompanyId());
            messageResponse.setMessage(e.getMessage());
            return new ResponseEntity<>(messageResponse,HttpStatus.OK);
        }catch (Throwable e){
            log.error("General error while deleting data{}",req.getCompanyId());
            return new ResponseEntity<>(messageResponse,HttpStatus.INTERNAL_SERVER_ERROR);
        }finally {
            log.info("Intercept delete warehouse");
        }
    }

}
