package com.mis.mis_web_app_api.modules.supplier;

import com.mis.mis_web_app_api.exceptions.ApiException;
import com.mis.mis_web_app_api.modules.BaseRequest;
import com.mis.mis_web_app_api.constants.MessageResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RequiredArgsConstructor
@RestController()
public class SupplierController {
    private final SupplierService supplierService;
    private MessageResponse messageResponse;
    @PostMapping("/api/suppliers_paginated")
    public ResponseEntity<Object> getAllSupplierPaginated(@RequestBody BaseRequest req) {
        messageResponse = new MessageResponse();
        try {
            log.info("Intercept Getting all suppliers");
            messageResponse.setGetDataSuccess(supplierService.getAllSuppliersPaginated(req));
            return new ResponseEntity<>(messageResponse, HttpStatus.OK);
        }catch (ApiException e){
            log.error("Error while getting all suppliers {}", e.getMessage());
            return new ResponseEntity<>(messageResponse, HttpStatus.BAD_REQUEST);
        }catch (Throwable e){
            log.error("General error while getting all suppliers {}", e.getMessage());
            return new ResponseEntity<>(messageResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }finally{
            log.info("Intercept Getting all suppliers");
        }
    }
    @PostMapping("/api/suppliers")
    public ResponseEntity<Object> getAllSupplier(@RequestBody Supplier req) {
        messageResponse = new MessageResponse();
        try {
            log.info("Intercept Getting all suppliers");
            messageResponse.setGetDataSuccess(supplierService.getAllSuppliers(req));
            return new ResponseEntity<>(messageResponse, HttpStatus.OK);
        }catch (ApiException e){
            log.error("Error while getting all suppliers {}", e.getMessage());
            return new ResponseEntity<>(messageResponse, HttpStatus.BAD_REQUEST);
        }catch (Throwable e){
            log.error("General error while getting all suppliers {}", e.getMessage());
            return new ResponseEntity<>(messageResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }finally{
            log.info("Intercept Getting all suppliers");
        }
    }

    @PostMapping("/api/getSupplierById")
    public ResponseEntity<Object> getSupplierById(@RequestBody Supplier req) {
        messageResponse = new MessageResponse();
        try {
            log.info("Intercept Getting all supplier by id");
            messageResponse.setGetDataSuccess(supplierService.getSupplierById(req));
            return new ResponseEntity<>(messageResponse, HttpStatus.OK);
        }catch (ApiException e){
            log.error("Error while getting suppliers {}", e.getMessage());
            messageResponse.setMessage(e.getMessage());
            return new ResponseEntity<>(messageResponse, HttpStatus.BAD_REQUEST);
        }catch (Throwable e){
            log.error("General error while getting suppliers {}", e.getMessage());
            messageResponse.setMessage(e.getMessage());
            return new ResponseEntity<>(messageResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }finally {
            log.info("Intercept Getting all suppliers {}", req);
        }
    }

    @PostMapping("/api/suppliers/create")
    public ResponseEntity<Object> createSupplier(@RequestBody Supplier req) {

        messageResponse = new MessageResponse();
        try{
            log.info("Intercept Creating new supplier {}", req);
            messageResponse.setCreateDataSuccess(supplierService.saveSupplier(req));
            return new ResponseEntity<>(messageResponse, HttpStatus.OK);
        }catch (ApiException e){
            log.error("Error while creating supplier {}", e.getMessage());
            messageResponse.setMessage(e.getMessage());
            return new ResponseEntity<>(messageResponse, HttpStatus.BAD_REQUEST);
        }catch (Throwable e){
            log.error("General error while creating supplier {}", e.getMessage());
            messageResponse.setMessage(e.getMessage());
            return new ResponseEntity<>(messageResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }finally {
            log.info("Intercept Creating new supplier");
        }
    }

    @PostMapping("/api/suppliers/update")
    public ResponseEntity<Object> updateSupplier(@RequestBody Supplier req) {
        messageResponse = new MessageResponse();
        try{
            log.info("Intercept Updating supplier");
            supplierService.updateSupplier(req);
            messageResponse.setUpdateDataSuccess(req);
            return new ResponseEntity<>(messageResponse, HttpStatus.OK);
        }catch (ApiException e){
            log.error("Error while updating supplier {}", e.getMessage());
            messageResponse.setMessage(e.getMessage());
            return new ResponseEntity<>(messageResponse, HttpStatus.BAD_REQUEST);
        }catch (Throwable e){
            log.error("General error while updating supplier {}", e.getMessage());
            return new ResponseEntity<>(messageResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }finally {
            log.info("Intercept Updating supplier {}",req);
        }
    }

    @PostMapping("/api/suppliers/delete")
    public ResponseEntity<Object> deleteSupplier(@RequestBody Supplier req) {
        messageResponse = new MessageResponse();
        try {
            log.info("Intercept Deleting supplier {}", req);
            supplierService.deleteSupplier(req);
            messageResponse.setDeleteDataSuccess(req.getSupplierId());
            return new ResponseEntity<>(messageResponse, HttpStatus.OK);
        }catch (ApiException e){
            log.error("Error while deleting supplier {}", e.getMessage());
            messageResponse.setMessage(e.getMessage());
            return new ResponseEntity<>(messageResponse, HttpStatus.BAD_REQUEST);
        }catch (Throwable e){
            log.error("General error while deleting supplier {}", e.getMessage());
            return new ResponseEntity<>(messageResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }finally {
            log.info("Intercept Deleting supplier");
        }
    }

}
