package com.mis.mis_web_app_api.modules.warehouse;

import com.mis.mis_web_app_api.exceptions.ApiException;
import com.mis.mis_web_app_api.modules.BaseRequest;
import com.mis.mis_web_app_api.constants.MessageResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/warehouses")
public class WarehouseController {
    private final WarehouseService warehouseService;
    private MessageResponse messageResponse;
    public WarehouseController(WarehouseService warehouseService) {
        this.warehouseService = warehouseService;
    }

    @GetMapping("")
    public ResponseEntity<Object> index() throws ApiException {
        messageResponse = new MessageResponse();
        messageResponse.setGetDataSuccess(warehouseService.getAll());
        return new ResponseEntity<>(messageResponse, HttpStatus.OK);
    }

    @PostMapping("/paginated")
    public ResponseEntity<Object> paginated(@RequestBody BaseRequest req) throws ApiException {
        messageResponse = new MessageResponse();
        warehouseService.getAllWithPaginated(req);

        return new ResponseEntity<>(messageResponse, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody Warehouse req) throws ApiException {
        messageResponse = new MessageResponse();
        messageResponse.setCreateDataSuccess(warehouseService.save(req));

        return new ResponseEntity<>(messageResponse, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<Object> update(@RequestBody Warehouse req) throws ApiException {
        messageResponse = new MessageResponse();
        messageResponse.setUpdateDataSuccess(warehouseService.save(req));
        return new ResponseEntity<>(messageResponse, HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<Object> delete(@RequestBody Warehouse req) throws ApiException {
        messageResponse = new MessageResponse();
        warehouseService.delete(req);
        messageResponse.setDeleteDataSuccess(req);
        return new ResponseEntity<>(messageResponse, HttpStatus.OK);
    }

}
