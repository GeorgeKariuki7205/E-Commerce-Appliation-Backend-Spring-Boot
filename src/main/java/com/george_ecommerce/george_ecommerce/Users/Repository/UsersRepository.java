package com.george_ecommerce.george_ecommerce.Users.Repository;

import com.george_ecommerce.george_ecommerce.Users.Entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<UsersEntity,Long> {
}
