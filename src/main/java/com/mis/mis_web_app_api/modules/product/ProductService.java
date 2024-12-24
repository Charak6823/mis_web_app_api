package com.mis.mis_web_app_api.modules.product;

import com.mis.mis_web_app_api.exceptions.ApiException;
import com.mis.mis_web_app_api.modules.BaseRequest;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface ProductService{
    List<Product> getAllProducts() throws ApiException;
    Page<Product> paginated(BaseRequest request) throws ApiException;
    Optional<Product> getProductById(Product req) throws ApiException;
    void saveProduct(Product req) throws ApiException;
    void updateProduct(Product req) throws ApiException;
    void deleteProduct(Product req) throws ApiException;
}
