package com.george_ecommerce.george_ecommerce.OrderDetails.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.george_ecommerce.george_ecommerce.UserPayments.Entity.UserPaymentsEntity;
import com.george_ecommerce.george_ecommerce.Users.Entity.UsersEntity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_order_order_details")
public class OrderDetailsEntity {

    @Id
    @SequenceGenerator(
            name = "z_sequence_order_details",
            sequenceName = "z_sequence_order_details",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "z_sequence_order_details",
            strategy = GenerationType.SEQUENCE
    )
    @Column(name = "id", nullable = false)
    private Long orderDetailsId;

    //    ! CREATING THE FOREIGN KEY TO THE USERS TABLE.

    @JsonBackReference(value = "order_details_user_id")
    @ManyToOne()
    @JoinColumn(
            name = "userId",
            referencedColumnName = "id"
    )
    private UsersEntity orderDetailsUser;

    @JsonBackReference(value = "user_payment_id_order_details")
    @ManyToOne()
    @JoinColumn(
            name = "user_payment_id",
            referencedColumnName = "id"
    )
    private UserPaymentsEntity OrderDetailsPayments;

    @Column(name = "created_at", nullable = false)
    private Date crestedAt;

    @Column(name = "modified_at", nullable = false)
    private Date modifiedAt;


    //    CREATING THE USERS FOREIGN KEY TO THE CREATED BY AND UPDATED BY.

    @JsonBackReference(value = "order_details_created_by")
    @ManyToOne()
    @JoinColumn(
            name = "crestedBy",
            referencedColumnName = "id"
    )
    private UsersEntity orderDetailsCreatedByUser;

    @JsonBackReference(value = "order_details_modified_by")
    @ManyToOne()
    @JoinColumn(
            name = "modifiedBy",
            referencedColumnName = "id"
    )
    private UsersEntity orderDetailsModifiedByUser;

}
