package com.mis.mis_web_app_api.modules.company;

import com.mis.mis_web_app_api.exceptions.ApiException;
import com.mis.mis_web_app_api.modules.BaseRequest;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface CompanyService {
    List<Company> getAll() throws ApiException;
    Page<Company> getAllWithPaginated(BaseRequest req) throws ApiException;
    Optional<Company> getById(Company req) throws ApiException;
    Company save(Company req) throws ApiException;
    void update(Company req) throws ApiException;
    void delete(Company req) throws ApiException;
}
