package com.mis.mis_web_app_api.modules.unitType;

import com.mis.mis_web_app_api.exceptions.ApiException;

import java.util.List;
import java.util.Optional;

public interface UnitTypeService {

    List<UnitType> getAllUnitTypes() throws ApiException;
    Optional<UnitType> getUnitTypeById(int id) throws ApiException;
    UnitType saveUnitType(UnitType unitType) throws ApiException;
    void updateUnitType(UnitType unitType) throws ApiException;
    void deleteUnitType(UnitType unitType) throws ApiException;
}
