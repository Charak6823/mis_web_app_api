package com.mis.mis_web_app_api.modules.supplier;

import com.mis.mis_web_app_api.exceptions.ApiException;
import com.mis.mis_web_app_api.modules.BaseRequest;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface SupplierService {
    List<Supplier>getAllSuppliers(Supplier req) throws ApiException;
    Page<Supplier> getAllSuppliersPaginated(BaseRequest req) throws ApiException;
    Optional<Supplier> getSupplierById(Supplier req) throws ApiException;
    Supplier saveSupplier(Supplier req) throws ApiException;
    void updateSupplier(Supplier req) throws ApiException;
    void deleteSupplier(Supplier req) throws ApiException;
}
