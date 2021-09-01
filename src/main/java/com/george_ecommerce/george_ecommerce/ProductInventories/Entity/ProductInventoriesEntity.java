package com.george_ecommerce.george_ecommerce.ProductInventories.Entity;

import com.george_ecommerce.george_ecommerce.Products.Entity.ProductsEntity;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tbl_product_product_inventory")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@EqualsAndHashCode
public class ProductInventoriesEntity {

    @Id
    @SequenceGenerator(
            name = "z_sequence_product_inventory",
            sequenceName = "z_sequence_product_inventory",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "z_sequence_product_inventory",
            strategy = GenerationType.SEQUENCE
    )
    @Column(name = "id", nullable = false)
    private Long productInventoryId;

    @Column(name = "quality", nullable = false)
    private Long productQuantity;

    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    @Column(name = "created_by", nullable = false)
    private Long createdBy;

    @Column(name = "updated_by")
    private Long updatedBy;

    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "productInventoriesEntity"
    )
    private List<ProductsEntity> productsEntityList;

    public ProductInventoriesEntity(
            Long productQuantity,
            Date createdAt,
            Long createdBy
    ){
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.productQuantity = productQuantity;
    }

    public ProductInventoriesEntity(
            Long productQuantity,
            Date updatedAt,
            Long updatedBy,
            Long productInventoryId
    ){
        this.productQuantity = productQuantity;
        this.updatedAt = updatedAt;
        this.createdBy = updatedBy;
        this.productInventoryId = productInventoryId;
    }
}
