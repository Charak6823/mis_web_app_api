package com.mis.mis_web_app_api.modules.unitType;


import com.mis.mis_web_app_api.constants.Constants;
import com.mis.mis_web_app_api.exceptions.ApiException;
import com.mis.mis_web_app_api.constants.MessageResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
public class UnitTypeController {
    private final UnitTypeService unitTypeService;
    MessageResponse messageResponse = new MessageResponse();

    @GetMapping("/api/unitTypes")
    public ResponseEntity<Object> getAllActiveUnitTypes(UnitType req) throws ApiException {
        messageResponse = new MessageResponse();
        try{
            log.info("Intercept all unitTypes");
            messageResponse.setGetDataSuccess(unitTypeService.getAllUnitTypes());
            return new ResponseEntity<>(messageResponse, HttpStatus.OK);
        }catch (ApiException e){
            log.error("Error while getting all unit types:{}",e.getMessage());
            messageResponse.setStatus(e.getCode());
            messageResponse.setMessage(e.getMessage());
            messageResponse.setMessageKh(e.getMessageKh());
            return new ResponseEntity<>(messageResponse, HttpStatus.OK);
        }catch(Throwable e){
            log.error("General error while getting all unit types:{}",e.getMessage());
            return new ResponseEntity<>(messageResponse, HttpStatus.OK);
        }finally {
            log.info("Get all unitTypes response{}",messageResponse);
        }
    }

    @PostMapping("/api/getUnitTypeById")
    public ResponseEntity<MessageResponse> getUnitTypeById(@RequestBody UnitType req) {
        try{
            log.info(Constants.LOG_INFO);
            messageResponse.setGetDataSuccess(unitTypeService.getUnitTypeById(req.getUnitTypeId()));
            return new ResponseEntity<>(messageResponse, HttpStatus.OK);
        }catch (ApiException e){
            log.info(Constants.LOG_ERR,e.getMessage());
            messageResponse.setErrorMessage(e.getMessage());
            return ResponseEntity.status(400).body(messageResponse);
        }catch (Exception e){
            log.error(Constants.LOG_UNKNOWN_ERR,e.getMessage());
            return new ResponseEntity<>(messageResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }finally {
            log.info(Constants.LOG_INFO_FINALLY,req,messageResponse);
        }
    }

    @PostMapping("/api/createUnitType")
    public ResponseEntity<MessageResponse> createUnitType(@RequestBody UnitType req){
        messageResponse = new MessageResponse();
        try {
            log.info(Constants.LOG_INFO);
            messageResponse.setCreateDataSuccess(unitTypeService.saveUnitType(req));
            return ResponseEntity.ok(messageResponse);
        }catch (ApiException e){
            log.error(Constants.LOG_ERR,e.getMessage(), e);
            messageResponse.setErrorMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(messageResponse);
        }catch (Exception e){
            log.error(Constants.LOG_UNKNOWN_ERR,e.getMessage(),e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(messageResponse);
        }finally {
            log.info(Constants.LOG_INFO_FINALLY);
        }
    }

    @PostMapping("/api/updateUnitType")
    public ResponseEntity<Object> updateUnitType(@RequestBody UnitType req){
        messageResponse = new MessageResponse();
        try {
            log.info("Intercept update unit type");
            unitTypeService.updateUnitType(req);
            messageResponse.setUpdateDataSuccess(req);
            return new ResponseEntity<>(messageResponse, HttpStatus.OK);
        }catch (ApiException e){
            log.error("Error while updating unit type:{}",e.getMessage());
            messageResponse = new MessageResponse(e.getCode(),e.getMessage(),e.getMessageKh(),null);
            return new ResponseEntity<>(messageResponse, HttpStatus.OK);
        }catch (Throwable e){
            log.error("General error while updating unit type:{}",e.getMessage());
            return new ResponseEntity<>(messageResponse, HttpStatus.OK);
        }finally {
            log.info("Update unit type response{}",messageResponse);
        }

    }

    @PostMapping("/api/deleteUnitType")
    public ResponseEntity<Object> deleteUnitType(@RequestBody UnitType req){
        messageResponse = new MessageResponse();
        try{
            log.info("Intercept delete unit type");
            unitTypeService.deleteUnitType(req);
            messageResponse.setDeleteDataSuccess(req);
            return new ResponseEntity<>(messageResponse, HttpStatus.OK);
        }catch (ApiException e){
            log.error("Error while deleting unit type:{}",e.getMessage());
            return new ResponseEntity<>(messageResponse, HttpStatus.OK);
        }catch (Throwable e){
            log.error("General error while deleting unit type:{}",e.getMessage());
            return new ResponseEntity<>(messageResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }finally {
            log.info("Delete unit type response{}",messageResponse);
        }
    }

}
