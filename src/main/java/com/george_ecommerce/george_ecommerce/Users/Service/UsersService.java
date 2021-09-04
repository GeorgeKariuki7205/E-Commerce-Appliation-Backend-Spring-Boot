package com.george_ecommerce.george_ecommerce.Users.Service;

import com.george_ecommerce.george_ecommerce.Users.Repository.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UsersService {
    private final UsersRepository usersRepository;
}
