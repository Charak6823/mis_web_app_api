package com.mis.mis_web_app_api.modules.product;

import com.mis.mis_web_app_api.constants.Constants;
import com.mis.mis_web_app_api.exceptions.ApiException;
import com.mis.mis_web_app_api.modules.BaseRequest;
import com.mis.mis_web_app_api.constants.MessageResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private MessageResponse messageResponse;

    @GetMapping("/api/products")
    public ResponseEntity<Object> getAll(){
        messageResponse = new MessageResponse();
        try {
            log.info(Constants.LOG_INFO);
            messageResponse.setGetDataSuccess(productService.getAllProducts());
            return new ResponseEntity<>(messageResponse,HttpStatus.OK);
        }catch (ApiException e){
            log.error(Constants.LOG_ERR);
            return ResponseEntity.status(400).body(e.getMessage());
        }catch (Exception e){
            log.error(Constants.LOG_UNKNOWN_ERR);
            return ResponseEntity.status(500).body(e.getMessage());
        }finally {
            log.info(Constants.LOG_INFO_FINALLY);
        }
    }
    @PostMapping("/api/products")
    public ResponseEntity<Object> paginated(@RequestBody BaseRequest req) throws ApiException {
        messageResponse = new MessageResponse();
        try{
            log.info(Constants.LOG_INFO);
            messageResponse.setGetDataSuccess(productService.paginated(req));
            return new ResponseEntity<>(messageResponse, HttpStatus.OK);
        }catch (ApiException e){
            log.error(Constants.LOG_ERR, e);
            return new ResponseEntity<>(messageResponse, HttpStatus.BAD_REQUEST);
        }catch (Throwable e){
            log.error(Constants.LOG_UNKNOWN_ERR, e.getMessage());
            return new ResponseEntity<>(messageResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }finally{
            log.info(Constants.LOG_INFO_FINALLY);
        }
    }

    @PostMapping("/api/products/getById")
    public ResponseEntity<Object> getProductById(@RequestBody Product req) throws ApiException {
        messageResponse = new MessageResponse();
        try {
            log.info("Intercept get product by id");
            messageResponse.setGetDataSuccess(productService.getProductById(req));
            return new ResponseEntity<>(messageResponse, HttpStatus.OK);
        }catch (ApiException e){
            log.error("Error while getting product by id {} ", e.getMessage());
            messageResponse.setMessage(e.getMessage());
            return new ResponseEntity<>(messageResponse, HttpStatus.BAD_REQUEST);
        }catch (Throwable e){
            log.error("General error while getting product by id",e);
            return new ResponseEntity<>(messageResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }finally {
            log.info("Intercept get product by id {}", req);
        }
    }

    @PostMapping("/api/products/create")
    public ResponseEntity<Object> createProduct(@RequestBody Product req) throws ApiException {
        messageResponse = new MessageResponse();
        try {
            log.info(Constants.LOG_INFO);
            productService.saveProduct(req);
            messageResponse.setCreateDataSuccess(req);
            return new ResponseEntity<>(messageResponse, HttpStatus.OK);
        }catch (ApiException e){
            log.error(Constants.LOG_ERR, e.getMessage());
            messageResponse.setMessage(e.getMessage());
            return new ResponseEntity<>(messageResponse, HttpStatus.BAD_REQUEST);
        }catch (Throwable e){
            log.error(Constants.LOG_UNKNOWN_ERR,e);
            return new ResponseEntity<>(messageResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }finally {
            log.error(Constants.LOG_INFO_FINALLY);
        }
    }

    @PostMapping("/api/products/update")
    public ResponseEntity<Object> updateProduct(@RequestBody Product req) throws ApiException {
        messageResponse = new MessageResponse();
        try {
            log.info("Intercept update product {} ");
            productService.updateProduct(req);
            messageResponse.setUpdateDataSuccess(req);
            return new ResponseEntity<>(messageResponse, HttpStatus.OK);
        }catch (ApiException e){
            log.error("Error while updating product{}", e.getMessage());
            return new ResponseEntity<>(messageResponse, HttpStatus.BAD_REQUEST);
        }catch (Throwable e){
            log.error("General error while updating product {}", e.getMessage());
            return new ResponseEntity<>(messageResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }finally {
            log.error("Intercept update product");
        }
    }

    @PostMapping("/api/products/delete")
    public ResponseEntity<Object> deleteProduct(@RequestBody Product req) throws ApiException {
        messageResponse = new MessageResponse();
        try {
            log.info("Intercept delete product {} ", req.getProductId());
            productService.deleteProduct(req);
            messageResponse.setDeleteDataSuccess(req);
            return new ResponseEntity<>(messageResponse, HttpStatus.OK);
        }catch (ApiException e){
            log.error("Error while deleting product {} ",e.getMessage());
            return new ResponseEntity<>(messageResponse, HttpStatus.BAD_REQUEST);
        }catch (Throwable e){
            log.error("General error while deleting product {} ",e.getMessage());
            return new ResponseEntity<>(messageResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }finally {
            log.error("Intercept delete product");
        }
    }
}
