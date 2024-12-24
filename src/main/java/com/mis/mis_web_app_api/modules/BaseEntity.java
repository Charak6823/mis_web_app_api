package com.mis.mis_web_app_api.modules;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.mis.mis_web_app_api.constants.Constants;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@Data
@MappedSuperclass
@JsonPropertyOrder({
        "createdAt", "createdBy", "updatedAt", "updatedBy"
})
public class BaseEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 4497134883113239078L;
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