package com.mis.mis_web_app_api.models;

import com.mis.mis_web_app_api.constants.Constants;
import com.mis.mis_web_app_api.modules.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serial;
import java.util.Date;


@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "otp_logs")
@DynamicUpdate()
@Getter
@Setter
public class OtpLog {
    @Serial
    private static final long serialVersionUID = 4489397646584896516L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String token;
    private String sendTo;
    private String otp;
    private String otpMessage;
    private String status;
    private String actionType;
    @Column(name = "CREATED_AT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt = new Date();
    @Column(name = "CREATED_BY")
    private String createdBy = Constants.SYSTEM;
    @Column(name = "UPDATED_AT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Column(name = "UPDATED_BY")
    private String updateBy;

}