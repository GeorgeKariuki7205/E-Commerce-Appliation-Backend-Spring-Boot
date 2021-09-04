package com.george_ecommerce.george_ecommerce.Users.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_users_users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class UsersEntity {

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
    private Long userId;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email_address", nullable = false)
    private String emailAddress;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "telephone_number", nullable = false)
    private String telephoneNumber;

    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    @Column(name = "created_by", nullable = false)
    private Long createdBy;

    @Column(name = "updated_by")
    private Long updatedBy;

    public UsersEntity(
            String firstName,
            String lastName,
            String emailAddress,
            String password,
            String telephoneNumber,
            Date createdAt,
            Long createdBy

    ) {

        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.password = password;
        this.telephoneNumber = telephoneNumber;

    }

    public UsersEntity(
            String firstName,
            String lastName,
            String emailAddress,
            String password,
            String telephoneNumber,
            Date updatedAt,
            Long updatedBy,
            Long userId

    ) {

        this.updatedAt = updatedAt;
        this.updatedBy = updatedBy;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.password = password;
        this.telephoneNumber = telephoneNumber;

    }
}
