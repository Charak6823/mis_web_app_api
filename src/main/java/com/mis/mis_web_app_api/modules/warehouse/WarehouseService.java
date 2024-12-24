package com.mis.mis_web_app_api.modules.warehouse;

import com.mis.mis_web_app_api.exceptions.ApiException;
import com.mis.mis_web_app_api.modules.BaseRequest;

import java.util.List;
import java.util.Optional;

public interface WarehouseService {
    List<Warehouse> getAll() throws ApiException;
    void getAllWithPaginated(BaseRequest req) throws ApiException;
    Optional<Warehouse> getById(Warehouse req) throws ApiException;
    Warehouse save(Warehouse req) throws ApiException;
    void update(Warehouse req) throws ApiException;
    void delete(Warehouse req) throws ApiException;
}
