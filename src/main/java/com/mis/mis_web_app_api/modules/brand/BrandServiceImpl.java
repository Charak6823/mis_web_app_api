package com.mis.mis_web_app_api.modules.brand;

import com.mis.mis_web_app_api.constants.Constants;
import com.mis.mis_web_app_api.exceptions.ApiException;
import com.mis.mis_web_app_api.modules.BaseRequest;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandRepository brandRepository;

    @Override
    public List<Brand> index() throws ApiException {
        return brandRepository.findAll(Sort.by(Sort.Direction.DESC,"brandId"));
    }

    @Override
    public Page<Brand> paginated(BaseRequest req) throws ApiException {
        Pageable pageable = PageRequest.of(req.getPage(), req.getSize());
        return brandRepository.findAll(pageable);
    }

    @Override
    public Brand store(Brand brand) throws ApiException {
        return brandRepository.save(brand);
    }

    @Override
    public Brand show(int brandId) throws ApiException {
        return brandRepository.findById(brandId)
                .orElseThrow(() -> new EntityNotFoundException("Brand not found"));
    }

    @Override
    public Brand update(int brandId, Brand brand) throws ApiException {
        Brand existingBrand = brandRepository.findById(brandId)
                .orElseThrow(() -> new EntityNotFoundException("Brand not found"));
        existingBrand.setBrandName(brand.getBrandName());
        existingBrand.setShortName(brand.getShortName());
        existingBrand.setStatus(brand.getStatus());
        existingBrand.setImage(brand.getImage());
        return brandRepository.save(existingBrand);
    }

    @Override
    public void destroy(Brand brand) throws ApiException {
        var existBrand = brandRepository.findById(brand.getBrandId());
        if(existBrand.isEmpty()){
            throw new EntityNotFoundException("Brand not found");
        }
        brand.setStatus(Constants.STATUS_DELETE);
        brandRepository.save(brand);
    }

    @Override
    public void permanentlyDestroy(int brandId) throws ApiException {
        if (!brandRepository.existsById(brandId)) {
            throw new EntityNotFoundException("Brand not found");
        }
        brandRepository.deleteById(brandId);
    }
}
