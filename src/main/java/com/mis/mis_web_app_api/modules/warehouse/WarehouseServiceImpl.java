package com.mis.mis_web_app_api.modules.warehouse;

import com.mis.mis_web_app_api.exceptions.ApiException;
import com.mis.mis_web_app_api.modules.BaseRequest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WarehouseServiceImpl implements WarehouseService {
    private final WarehouseRepository warehouseRepository;
    public WarehouseServiceImpl(WarehouseRepository warehouseRepository) {
        this.warehouseRepository = warehouseRepository;
    }

    @Override
    public List<Warehouse> getAll() throws ApiException {
        return warehouseRepository.findAll();
    }

    @Override
    public void getAllWithPaginated(BaseRequest req) throws ApiException {
        Pageable pageable = PageRequest.of(req.getPage(), req.getSize());
        warehouseRepository.findAll(pageable);
    }

    @Override
    public Optional<Warehouse> getById(Warehouse req) throws ApiException {
        return warehouseRepository.findById(req.getWarehouseId());
    }

    @Override
    public Warehouse save(Warehouse req) throws ApiException {
        return warehouseRepository.save(req);
    }

    @Override
    public void update(Warehouse req) throws ApiException {
        warehouseRepository.findById(req.getWarehouseId()).orElseThrow(() -> new ApiException("Warehouse not found"));
        warehouseRepository.save(req);
    }

    @Override
    public void delete(Warehouse req) throws ApiException {
        warehouseRepository.delete(req);
    }
}
