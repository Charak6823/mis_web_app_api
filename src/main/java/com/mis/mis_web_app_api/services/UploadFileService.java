package com.mis.mis_web_app_api.services;

import com.mis.mis_web_app_api.models.FileImageDetail;
import com.mis.mis_web_app_api.models.res.UploadImageRes;
import org.springframework.web.multipart.MultipartFile;

public interface UploadFileService {
    UploadImageRes uploadFile(MultipartFile files);

    FileImageDetail findImageByFileName(String fileName);
}
