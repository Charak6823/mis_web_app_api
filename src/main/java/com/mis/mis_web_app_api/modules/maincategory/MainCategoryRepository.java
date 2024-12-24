package com.mis.mis_web_app_api.modules.maincategory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MainCategoryRepository extends JpaRepository<MainCategory, Integer> {
    Optional<MainCategory> findByName(String name);
}
