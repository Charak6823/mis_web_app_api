package com.mis.mis_web_app_api.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "image_details")
@DynamicUpdate()
public class FileImageDetail implements Serializable {

    private static final long serialVersionUID = 4489397646584896516L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "FILE_PATH")
    private String filePath;
    @Column(name = "FILE_TYPE")
    private String fileType;
    @Column(name = "FILE_NAME")
    private String fileName;
    @Column(name = "ORIGINAL_FILE_NAME")
    private String originalFileName;
    @Column(name = "FILE_SIZE")
    private Long fileSize;
    @Column(name = "STATUS")
    private String status;

}
