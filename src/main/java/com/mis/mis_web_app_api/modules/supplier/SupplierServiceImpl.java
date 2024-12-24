package com.mis.mis_web_app_api.modules.supplier;


import com.mis.mis_web_app_api.exceptions.ApiException;
import com.mis.mis_web_app_api.modules.BaseRequest;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SupplierServiceImpl implements SupplierService {
    private final SupplierRepository supplierRepository;

    @Override
    public List<Supplier> getAllSuppliers(Supplier req) throws ApiException {
        return supplierRepository.findAll();
    }

    @Override
    public Page<Supplier> getAllSuppliersPaginated(BaseRequest req) throws ApiException {

        // Validate the page and size parameters
        int page = Math.max(req.getPage(), 0); // Ensure page is not negative
        int size = Math.max(req.getSize(), 1); // Ensure size is at least 1

        // Create a Pageable object
        Pageable pageable = (Pageable) PageRequest.of(page, size, Sort.by(Sort.Direction.DESC,"supplierId"));

        // Fetch and return the paginated suppliers
        return supplierRepository.findAll(pageable);
    }

    @Override
    public Optional<Supplier> getSupplierById(Supplier req) throws ApiException {
        req = supplierRepository.findById(req.getSupplierId()).orElse(null);
        if (req == null){
            throw new ApiException("Not found!","រកមិនឃើញ!","");
        }
        return Optional.of(req);
    }

    @Override
    public Supplier saveSupplier(Supplier req) throws ApiException {
        var existingSupplier = supplierRepository.findByContactPhone(req.getContactPhone());
        if(existingSupplier.isPresent()){
            throw new ApiException("Supplier you entered is already exist!!","អ្នកផ្គត់ផ្គង់មួយដែលអ្នកគឺមានរួចហើយ","");
        }
        return supplierRepository.save(req);
    }

    @Override
    public void updateSupplier(Supplier req) throws ApiException {
        var existingSupplier = supplierRepository.findById(req.getSupplierId());
        if (existingSupplier.isEmpty()){
            throw new ApiException("Not found!","រកមិនឃើញ","");
        }

        Supplier supplierToUpdate = existingSupplier.get();
        supplierToUpdate.setSupplierName(req.getSupplierName());
        supplierToUpdate.setSex(req.getSex());
        supplierToUpdate.setContactName(req.getContactName());
        supplierToUpdate.setContactPhone(req.getContactPhone());
        supplierToUpdate.setAddress(req.getAddress());
        supplierToUpdate.setDescription(req.getDescription());

        supplierRepository.save(supplierToUpdate);

        supplierRepository.save(req);
    }

    @Override
    public void deleteSupplier(Supplier req) throws ApiException {
        var existingSupplier = supplierRepository.findById(req.getSupplierId());
        if (existingSupplier.isEmpty()){
            throw new ApiException("Not found!","រកមិនឃើញ","");
        }
        supplierRepository.delete(req);
    }
}
