package com.mis.mis_web_app_api.modules.delivery;

import com.mis.mis_web_app_api.exceptions.ApiException;
import com.mis.mis_web_app_api.modules.BaseRequest;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface DeliveryService {
    List<Delivery> getAll() throws ApiException;
    Page<Delivery> getAllWithPaginated(BaseRequest req) throws ApiException;
    Optional<Delivery> getById(Delivery req) throws ApiException;
    Delivery save(Delivery req) throws ApiException;
    void update(Delivery req) throws ApiException;
    void delete(Delivery req) throws ApiException;
}
