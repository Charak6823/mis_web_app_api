package com.mis.mis_web_app_api.modules.brand;

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
@RestController
@RequestMapping("api/brands")
public class BrandController {
    private final BrandService brandService;
    private MessageResponse messageResponse;

    @GetMapping("")
    public ResponseEntity<Object> index() {
        messageResponse = new MessageResponse();
        try {
            log.info("Intercept get all brands");
            messageResponse.setGetDataSuccess(brandService.index());
            return new ResponseEntity<>(messageResponse, HttpStatus.OK);
        }catch (ApiException e){
            log.error("error while getting brands {}", e.getMessage());
            return new ResponseEntity<>(messageResponse, HttpStatus.OK);
        }catch (Throwable e){
            log.error("General error while getting brands {}", e.getMessage());
            return new ResponseEntity<>(messageResponse, HttpStatus.OK);
        }finally {
            log.info("Intercept get all brands {}", messageResponse.getMessage());
        }
    }

    @PostMapping("/paginated")
    public ResponseEntity<Object> paginated(@RequestBody BaseRequest req){
        messageResponse = new MessageResponse();
        try{
            log.info("Intercept get all paginated data");
            messageResponse.setGetDataSuccess(brandService.paginated(req));
            return new ResponseEntity<>(messageResponse, HttpStatus.OK);
        }catch (Throwable e){
            log.error("General error while getting paginated data {}", e.getMessage());
            messageResponse.setMessage(e.getMessage());
            return new ResponseEntity<>(messageResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }finally {
            log.info("finally intercept get all paginated data");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> show(@PathVariable Integer id) {
        MessageResponse messageResponse = new MessageResponse();
        try{
            log.info("Intercept get brandById");
            messageResponse.setGetDataSuccess(brandService.show(id));
            return new ResponseEntity<>(messageResponse,HttpStatus.OK);
        } catch (ApiException e) {
            log.error("error while getting brandById {}",e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
        }catch (Throwable e){
            log.error("General error while getting brandById {}", e.getMessage());
            return new ResponseEntity<>(messageResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }finally {
            log.info("Intercept get brand by id {}", messageResponse.getMessage());
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Object> store(@RequestBody Brand req) {
        MessageResponse messageResponse = new MessageResponse();
        try {
            log.info("Intercept create brand");
            messageResponse.setCreateDataSuccess(brandService.store(req));
            return new ResponseEntity<>(messageResponse,HttpStatus.OK);
        }catch (ApiException e){
            log.error("error while creating brand {}", e.getMessage());
            return new ResponseEntity<>(messageResponse, HttpStatus.OK);
        }catch (Throwable e){
            log.error("General error while creating brand {}", e.getMessage());
            return new ResponseEntity<>(messageResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }finally {
            log.info("Intercept create brand {}", messageResponse.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object>updateBrand(@PathVariable int id,@RequestBody Brand req) {
        messageResponse = new MessageResponse();
        try {
            log.info("Intercept update brand");
            brandService.update(id,req);
            messageResponse.setUpdateDataSuccess(req);
            return new ResponseEntity<>(messageResponse,HttpStatus.OK);
        }catch (ApiException e){
            log.error("error while updating brand {}", e.getMessage());
            return new ResponseEntity<>(messageResponse, HttpStatus.OK);
        }catch (Throwable e){
            log.error("General error while updating brand {}", e.getMessage());
            return new ResponseEntity<>(messageResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }finally {
            log.info("Intercept update brand {}", messageResponse.getMessage());
        }
    }

    @PostMapping("/delete")
    public ResponseEntity<Object> deleteBrand(@RequestBody Brand req) {
        messageResponse = new MessageResponse();
        try {
            log.info("Intercept delete brand");
            brandService.destroy(req);
            messageResponse.setDeleteDataSuccess(req);
            return new ResponseEntity<>(messageResponse,HttpStatus.OK);
        }catch (ApiException e){
            log.error("error while deleting brand {}", e.getMessage());
            return new ResponseEntity<>(messageResponse, HttpStatus.OK);
        }catch (Throwable e){
            log.error("General error while deleting brand {}", e.getMessage());
            return new ResponseEntity<>(messageResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }finally {
            log.info("Intercept delete brand {}", messageResponse.getMessage());
        }
    }
}
