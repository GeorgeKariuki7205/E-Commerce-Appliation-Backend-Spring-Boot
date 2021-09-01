package com.george_ecommerce.george_ecommerce.ProductDiscounts.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_product_product_discount")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@EqualsAndHashCode
public class ProductDiscountsEntity {

    @Id
    @SequenceGenerator(
            name = "z_sequence_product_discount",
            sequenceName = "z_sequence_product_discount",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "z_sequence_product_discount",
            strategy = GenerationType.SEQUENCE
    )
    @Column(name = "id", nullable = false)
    private Long productDiscountId;

    @Column(name = "discount_name", nullable = false)
    private String productDiscountName;

    @Column(name = "discount_description", nullable = false)
    private String productDiscountDescription;

    @Column(name = "discount_percentage", nullable = false)
    private Long productDiscountPercentage;

    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    @Column(name = "created_by", nullable = false)
    private Long createdBy;

    @Column(name = "updated_by")
    private Long updatedBy;


    public ProductDiscountsEntity(
            String productDiscountName,
            String productDiscountDescription,
            Long productDiscountPercentage,
            Date createdAt,
            Long createdBy
    ) {
        this.productDiscountDescription = productDiscountDescription;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.productDiscountPercentage = productDiscountPercentage;
        this.productDiscountName = productDiscountName;
    }

    public ProductDiscountsEntity(
            String productDiscountName,
            String productDiscountDescription,
            Long productDiscountPercentage,
            Date updatedAt,
            Long updatedBy,
            Long productDiscountId
    ) {
        this.productDiscountDescription = productDiscountDescription;
        this.updatedAt = updatedAt;
        this.updatedBy = updatedBy;
        this.productDiscountPercentage = productDiscountPercentage;
        this.productDiscountName = productDiscountName;
    }

}
