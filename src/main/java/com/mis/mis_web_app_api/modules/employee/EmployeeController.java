package com.mis.mis_web_app_api.modules.employee;

import com.mis.mis_web_app_api.constants.MessageResponse;
import com.mis.mis_web_app_api.exceptions.ApiException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@Slf4j
@RequestMapping("/api/employees")
public class EmployeeController {
    MessageResponse messageResponse;
    private final EmployeeServiceImpl employeeServiceImpl;
    public EmployeeController(EmployeeServiceImpl employeeServiceImpl){
        this.employeeServiceImpl = employeeServiceImpl;
    }

    @GetMapping("")
    public ResponseEntity<Object> index(){
        messageResponse = new MessageResponse();
        messageResponse.setGetDataSuccess(employeeServiceImpl.index());
        return new ResponseEntity<>(messageResponse,HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<Object> store (@RequestBody Employee req) throws ApiException {
        try{
            log.info("Intercept create data!");
            messageResponse = new MessageResponse();
            messageResponse.setCreateDataSuccess(employeeServiceImpl.store(req));
            return new ResponseEntity<>(messageResponse, HttpStatus.OK);
        } catch (ApiException e){
            log.error("error while create data! ");
            return new ResponseEntity<>(messageResponse, HttpStatus.BAD_REQUEST);
        }catch (Throwable e){
            log.error("Error while creating data!");
            return new ResponseEntity<>(messageResponse,HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            log.error("create data successfully!");
        }
    }
}
