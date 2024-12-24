package com.mis.mis_web_app_api.repositories;


import com.mis.mis_web_app_api.models.FileImageDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileImageDetailRepository extends JpaRepository<FileImageDetail, Integer> {
    FileImageDetail findByFileNameAndStatus(String fileName, String status);
}
