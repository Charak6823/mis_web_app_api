package com.mis.mis_web_app_api.modules.unitType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UnitTypeRepository extends JpaRepository<UnitType, Integer> {
    Optional<UnitType> findByUnitTypeName(String unitTypeName);
}
