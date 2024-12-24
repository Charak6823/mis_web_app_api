package com.mis.mis_web_app_api.modules.category;

import com.mis.mis_web_app_api.modules.BaseEntity;
import com.mis.mis_web_app_api.modules.maincategory.MainCategory;
import com.mis.mis_web_app_api.modules.printer.Printer;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.DynamicUpdate;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity(name = "categories")
@DynamicUpdate
public class Category extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="categoryId", columnDefinition = "NVARCHAR")
    private int categoryId;

    @Column(name="categoryName", columnDefinition = "NVARCHAR")
    private String categoryName;

    @Column(name="categoryNameKh", columnDefinition = "NVARCHAR")
    private String categoryNameKh;

    @Column(name="remark", columnDefinition = "NVARCHAR")
    private String remark;

    @ManyToOne
    @JoinColumn(name="printerId")
    private Printer printer;

    @ManyToOne
    @JoinColumn(name="categoryMainId")
    private MainCategory mainCategory;


}
