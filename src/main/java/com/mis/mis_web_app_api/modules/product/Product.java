package com.mis.mis_web_app_api.modules.product;

import com.mis.mis_web_app_api.modules.brand.Brand;
import com.mis.mis_web_app_api.modules.category.Category;
import com.mis.mis_web_app_api.modules.company.Company;
import com.mis.mis_web_app_api.modules.BaseEntity;
import com.mis.mis_web_app_api.modules.supplier.Supplier;
import com.mis.mis_web_app_api.modules.warehouse.Warehouse;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.DynamicUpdate;


@Data
@EqualsAndHashCode(callSuper = true)
@Entity(name = "products")
@DynamicUpdate

public class Product extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="productId")
    private int productId;

    @Column (name="barcode",columnDefinition = "NVARCHAR(255)")
    private String barcode;

    @Column (name="productCode",columnDefinition = "NVARCHAR(255)")
    private String productCode;

    @Column (name="productName", columnDefinition = "NVARCHAR(255)")
    private String productName;

    @Column(name="batchNo", columnDefinition = "NVARCHAR(255)")
    private String batchNo;

    @Column(name="qtyOnHand")
    private int qtyOnHand;

    @Column(name="qtyAlert")
    private int qtyAlert;

    @Column(name="dayAlert")
    private int dayAlert;

    @Column(name="un")
    private int un;

    @Column(name="description", columnDefinition = "NTEXT")
    private String description;

    @Column(name="specification", columnDefinition = "NVARCHAR(255)")
    private String specification;

    @Lob
    @Column(name="photo")
    private byte[] photo;

    @Column(name="stockType", columnDefinition = "NVARCHAR(255)")
    private String stockType;

    @Column(name="startBalance")
    private int startBalance;

    @Column(name="oldMeterPerKg")
    private int oldMeterPerKg;

    //foreign key relationship
    @ManyToOne
    @JoinColumn(name="categoryId")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "supplierId")
    private Supplier supplier;

    @ManyToOne
    @JoinColumn(name="companyId")
    private Company company;

    @ManyToOne
    @JoinColumn(name="brandId")
    private Brand brand;

    @ManyToOne
    @JoinColumn(name="warehouseId")
    private Warehouse warehouse;

}
