package com.george_ecommerce.george_ecommerce.ProductCategory.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_product_product_category")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@EqualsAndHashCode
public class ProductCategoryEntity {

    @Id
    @SequenceGenerator(
            name = "z_sequence_product_category",
            sequenceName = "z_sequence_product_category",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "z_sequence_product_category",
            strategy = GenerationType.SEQUENCE
    )
    @Column(name = "id", nullable = false)
    private Long productCategoryId;

    @Column(name = "product_category_name", nullable = false)
    private String productCategoryName;

    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @Column(name = "updated_at", nullable = true)
    private Date updatedAt;

    @Column(name = "created_by", nullable = false)
    private Long createdBy;

    @Column(name = "updated_by", nullable = true)
    private Long updatedBy;


    public ProductCategoryEntity(String productCategoryName,
                                 Date createdAt,
                                 Long createdBy
                                 ) {

        this.productCategoryName = productCategoryName;
        this.createdBy = createdBy;
        this.createdAt = createdAt;


    }

    public ProductCategoryEntity(String productCategoryName,
                                 Date updatedAt,
                                 Long updatedBy,
                                 Long productCategoryId) {

        this.productCategoryName = productCategoryName;
        this.updatedAt = updatedAt;
        this.updatedBy = updatedBy;
        this.productCategoryId = productCategoryId;

    }

}
