package com.mis.mis_web_app_api.modules.brand;

import com.mis.mis_web_app_api.exceptions.ApiException;
import com.mis.mis_web_app_api.modules.BaseRequest;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BrandService {
    List<Brand> index() throws ApiException;
    Page<Brand> paginated(BaseRequest req) throws ApiException;
    Brand store(Brand brand) throws ApiException;
    Brand show(int brandId) throws ApiException;
    Brand update(int brandId, Brand brand) throws ApiException;
    void destroy(Brand brand) throws ApiException;
    void permanentlyDestroy(int brandId) throws ApiException;
}

