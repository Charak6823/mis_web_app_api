package com.mis.mis_web_app_api.modules.delivery;

import com.mis.mis_web_app_api.modules.BaseEntity;
import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.boot.context.properties.bind.DefaultValue;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity(name = "deliveries")
@DynamicUpdate

public class Delivery extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int deliveryId;

    @Column(columnDefinition = "NVARCHAR")
    private String deliveryName;

    @Column(columnDefinition = "NVARCHAR")
    private String contactName;

    @Column(columnDefinition = "NVARCHAR")
    private String phoneNumber;

    private String status;
}
