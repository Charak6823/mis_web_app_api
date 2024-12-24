package com.mis.mis_web_app_api.modules.delivery;



import com.mis.mis_web_app_api.exceptions.ApiException;
import com.mis.mis_web_app_api.modules.BaseRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeliveryServiceImpl implements DeliveryService {
    private final DeliveryRepository deliveryRepository;
    public DeliveryServiceImpl(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    @Override
    public List<Delivery> getAll() throws ApiException {
        return deliveryRepository.findAll();
    }

    @Override
    public Page<Delivery> getAllWithPaginated(BaseRequest req) throws ApiException {
        Pageable pageable = PageRequest.of(req.getPage(),req.getSize());
        return deliveryRepository.findAll(pageable);
    }

    @Override
    public Optional<Delivery> getById(Delivery req) throws ApiException {
        var delivery = deliveryRepository.findById(req.getDeliveryId());
        if (delivery.isEmpty()) {
            throw new ApiException("Data is not found!");
        }
        return delivery;
    }

    @Override
    public Delivery save(Delivery req) throws ApiException {
        return deliveryRepository.save(req);
    }

    @Override
    public void update(Delivery req) throws ApiException {
        var delivery = deliveryRepository.findById(req.getDeliveryId()).orElse(null);
        if (delivery == null) {
            throw new ApiException("Data is not found!");
        }
        delivery.setDeliveryName(req.getDeliveryName());
        delivery.setContactName(req.getContactName());
        delivery.setPhoneNumber(req.getPhoneNumber());
        delivery.setStatus(req.getStatus());

        deliveryRepository.save(delivery);
    }

    @Override
    public void delete(Delivery req) throws ApiException {
        deliveryRepository.delete(req);
    }
}
