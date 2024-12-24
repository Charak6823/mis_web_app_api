package com.mis.mis_web_app_api.modules.product;

import com.mis.mis_web_app_api.exceptions.ApiException;
import com.mis.mis_web_app_api.modules.BaseRequest;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() throws ApiException {
        return productRepository.findAll();
    }

    @Override
    public Page<Product> paginated(BaseRequest request) {
        Pageable pageable = PageRequest.of(request.getPage(),request.getSize());
        return productRepository.findAll(pageable);
    }

    @Override
    public Optional<Product> getProductById(Product req) throws ApiException{
        req = productRepository.findById(req.getProductId()).orElse(null);
        if(req == null){
            throw new ApiException("Not found","ររកមិនឃើញ","400");
        }
        return Optional.of(req);
    }

    @Override
    public void saveProduct(Product req) throws ApiException {
        productRepository.save(req);
    }

    @Override
    public void updateProduct(Product req) throws ApiException {
        productRepository.findById(req.getProductId()).ifPresentOrElse(
                existingProduct -> productRepository.save(req),
                ()->{
                    try {
                        throw new ApiException("Not found","រកមិនឃើញ","");
                    } catch (Throwable e) {
                        throw new RuntimeException(e);
                    }
                }
        );
    }

    @Override
    public void deleteProduct(Product req) throws ApiException {
        var existingProduct = productRepository.findById(req.getProductId());
        if(existingProduct.isEmpty()){
            throw new ApiException("Not found!","រកមិនឃើញ","");
        }
        productRepository.delete(req);
    }

}
