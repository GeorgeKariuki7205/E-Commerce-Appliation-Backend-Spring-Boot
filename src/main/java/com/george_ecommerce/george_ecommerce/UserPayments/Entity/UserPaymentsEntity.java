package com.george_ecommerce.george_ecommerce.UserPayments.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.george_ecommerce.george_ecommerce.OrderDetails.Entity.OrderDetailsEntity;
import com.george_ecommerce.george_ecommerce.Users.Entity.UsersEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tbl_users_payments")
public class UserPaymentsEntity {

    @Id
    @SequenceGenerator(
            name = "z_sequence_users_payments",
            sequenceName = "z_sequence_users_payments",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "z_sequence_users_payments",
            strategy = GenerationType.SEQUENCE
    )
    @Column(name = "id", nullable = false)
    private Long userPaymentId;

//    ! CREATING THE FOREIGN KEY TO THE USERS TABLE.

    @JsonBackReference(value = "user_payment_id")
    @ManyToOne()
    @JoinColumn(
            name = "userId",
            referencedColumnName = "id"
    )
    private UsersEntity userPaymentUser;

    @Column(name = "payment_type", nullable = false)
    private String paymentType;

    @Column(name = "provider", nullable = false)
    private String provider;

    @Column(name = "account_type", nullable = false)
    private Integer accountType;

    @Column(name = "expiry_date", nullable = false)
    private Date expiryDate;

    @Column(name = "created_at", nullable = false)
    private Date crestedAt;

    @Column(name = "modified_at", nullable = false)
    private Date modifiedAt;


//    CREATING THE USERS FOREIGN KEY TO THE CREATED BY AND UPDATED BY.

    @JsonBackReference(value = "user_payment_created_by")
    @ManyToOne()
    @JoinColumn(
            name = "crestedBy",
            referencedColumnName = "id"
    )
    private UsersEntity createdByUser;

    @JsonBackReference(value = "user_payment_modified_by")
    @ManyToOne()
    @JoinColumn(
            name = "modifiedBy",
            referencedColumnName = "id"
    )
    private UsersEntity modifiedByUser;

    @JsonManagedReference(value = "user_payment_id_order_details")
    @OneToMany(
            mappedBy = "OrderDetailsPayments",
            orphanRemoval = true,
            cascade = CascadeType.ALL
    )

    private List<OrderDetailsEntity> orderDetailsEntities;

}
