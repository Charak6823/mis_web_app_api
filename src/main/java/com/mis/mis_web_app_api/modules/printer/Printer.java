package com.mis.mis_web_app_api.modules.printer;

import com.mis.mis_web_app_api.modules.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.DynamicUpdate;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity(name = "printers")
@DynamicUpdate
@AttributeOverrides({
        @AttributeOverride(name = "createdAt", column = @Column(name = "created_at")),
        @AttributeOverride(name = "createdBy", column = @Column(name = "created_by")),
        @AttributeOverride(name = "updatedAt", column = @Column(name = "updated_at")),
        @AttributeOverride(name = "updatedBy", column = @Column(name = "updated_by"))
})
public class Printer extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="printerId")
    private int printerId;
    @Column(name="printerName")
    private String printerName;

//    @OneToMany(mappedBy = "printer")
//    private List<Category>categories;
}
