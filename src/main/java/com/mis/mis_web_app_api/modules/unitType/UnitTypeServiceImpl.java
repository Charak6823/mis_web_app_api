package com.mis.mis_web_app_api.modules.unitType;

import com.mis.mis_web_app_api.constants.Constants;
import com.mis.mis_web_app_api.exceptions.ApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UnitTypeServiceImpl implements UnitTypeService {
    private final UnitTypeRepository unitTypeRepository;

    @Override
    public List<UnitType> getAllUnitTypes() throws ApiException {
        return unitTypeRepository.findAll(Sort.by(Sort.Direction.DESC,"unitTypeId"));
    }

    @Override
    public Optional<UnitType> getUnitTypeById(int id) throws ApiException{
        UnitType existUnitType = unitTypeRepository.findById(id).orElseThrow(
                ()-> new ApiException("Data is not found!")
        );
        return Optional.of(existUnitType);
    }

    @Override
    public UnitType saveUnitType(UnitType unitType) throws ApiException {
        var checkName = unitTypeRepository.findByUnitTypeName(unitType.getUnitTypeName());
        if(checkName.isPresent()){
            throw new ApiException("The unit type is already exist","ខ្នាតនេះមានរួចហើយ","ERR-002");
        }
        return unitTypeRepository.save(unitType);
    }
    @Override
    public void updateUnitType(UnitType req) throws ApiException {
        unitTypeRepository.save(req);
    }
    @Override
    public void deleteUnitType(UnitType req) throws ApiException {
        var unitTypeOptional = unitTypeRepository.findById(req.getUnitTypeId());
        if(unitTypeOptional.isEmpty()) {
            throw new ApiException("Unit type is not found","រកមិនឃើញ","400");
        }
        UnitType unitType = unitTypeOptional.get();
        unitTypeRepository.delete(unitType);
    }


}
