package com.mis.mis_web_app_api.modules.company;

import com.mis.mis_web_app_api.exceptions.ApiException;
import com.mis.mis_web_app_api.modules.BaseRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public List<Company> getAll() throws ApiException {
        return companyRepository.findAll(Sort.by(Sort.Direction.DESC, "companyId"));
    }

    @Override
    public Page<Company> getAllWithPaginated(BaseRequest req) throws ApiException {
        Pageable pageable = PageRequest.of(req.getPage(), req.getSize());
        return companyRepository.findAll(pageable);
    }

    @Override
    public Optional<Company> getById(Company req) throws ApiException {
        var company = companyRepository.findById(req.getCompanyId()).orElse(null);
        if(company == null){
            return Optional.empty();
        }
        return companyRepository.findById(req.getCompanyId());
    }

    @Override
    public Company save(Company req) throws ApiException {
        return companyRepository.save(req);
    }

    @Override
    public void update(Company req) throws ApiException {
        var company = companyRepository.findById(req.getCompanyId()).orElse(null);
        if(company == null){
            throw new ApiException("Company not found");
        }
        company.setCompanyName(req.getCompanyName());
        company.setDescription(req.getDescription());
        company.setStatus(req.getStatus());
        companyRepository.save(company);
    }

    @Override
    public void delete(Company req) throws ApiException {
        companyRepository.delete(req);
    }
}
