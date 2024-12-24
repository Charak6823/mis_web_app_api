package com.mis.mis_web_app_api.modules.delivery;

import com.mis.mis_web_app_api.exceptions.ApiException;
import com.mis.mis_web_app_api.constants.MessageResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("/api/deliveries")
public class DeliveryController {
    @Autowired
    private DeliveryService deliveryService;
    private MessageResponse messageResponse;

    @GetMapping("")
    public ResponseEntity<Object> getAll(){
        messageResponse = new MessageResponse();
        try{
            log.info("Intercept getting all data");
            messageResponse.setGetDataSuccess(deliveryService.getAll());
            return new ResponseEntity<>(messageResponse, HttpStatus.OK);
        }catch (ApiException e){
            log.error("Error while getting all data {}",e.getMessage());
            return new ResponseEntity<>(messageResponse, HttpStatus.BAD_REQUEST);
        }catch (Throwable e){
            log.error("Error while getting all data {}",e.getMessage());
            return new ResponseEntity<>(messageResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }finally {
            log.info("Intercept returning all data");
        }
    }

   @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody Delivery req){
        messageResponse = new MessageResponse();
        try{
            log.info("Intercept creating data");
            messageResponse.setCreateDataSuccess(deliveryService.save(req));
            return new ResponseEntity<>(messageResponse, HttpStatus.OK);
        }catch (ApiException e){
            log.error("Error while creating data {}",e.getMessage());
            return new ResponseEntity<>(messageResponse, HttpStatus.BAD_REQUEST);
        }catch (Throwable e){
            log.error("Error while creating data {}",e.getMessage());
            return new ResponseEntity<>(messageResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }finally {
            log.info("Intercept returning all data");
        }
   }

   @PostMapping("/getById")
   public ResponseEntity<Object> getById(@RequestBody Delivery req){
        messageResponse = new MessageResponse();
        try{
            log.info("Intercept getting data");
            messageResponse.setGetDataSuccess(deliveryService.getById(req));
            return new ResponseEntity<>(messageResponse, HttpStatus.OK);
        }catch (ApiException e){
            log.error("Error while getting data {}",e.getMessage());
            return new ResponseEntity<>(messageResponse, HttpStatus.BAD_REQUEST);
        }catch (Throwable e){
            log.error("Error while getting data {}",e.getMessage());
            return new ResponseEntity<>(messageResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }finally {
            log.info("Intercept returning data");
        }
   }

   @PostMapping("/update")
    public ResponseEntity<Object> update(@RequestBody Delivery req){
        messageResponse = new MessageResponse();
        try{
            log.info("Intercept updating data");
            deliveryService.update(req);
            messageResponse.setUpdateDataSuccess(req);
            return new ResponseEntity<>(messageResponse, HttpStatus.OK);
        }catch (ApiException e){
            log.error("Error while updating data {}",e.getMessage());
            return new ResponseEntity<>(messageResponse, HttpStatus.BAD_REQUEST);
        }catch (Throwable e){
            log.error("Error while updating data {}",e.getMessage());
            return new ResponseEntity<>(messageResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }finally {
            log.info("Intercept updating all data");
        }
   }

   @PostMapping("delete")
    public ResponseEntity<Object> delete(@RequestBody Delivery req){
        messageResponse = new MessageResponse();
        try{
            log.info("Intercept deleting data");
            messageResponse.setDeleteDataSuccess(req);
            return new ResponseEntity<>(messageResponse, HttpStatus.OK);
        } catch (Throwable e){
            log.error("Error while deleting data {}",e.getMessage());
            return new ResponseEntity<>(messageResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }finally {
            log.info("Intercept deleting all data");
        }
   }
}
