package com.mis.mis_web_app_api.repositories;

import com.mis.mis_web_app_api.models.Role;
import com.mis.mis_web_app_api.models.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(UserRole name);
}
