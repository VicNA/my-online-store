package ru.geekbrains.myonlinestore.services;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.geekbrains.myonlinestore.entites.SystemUser;
import ru.geekbrains.myonlinestore.entites.User;

public interface UserService extends UserDetailsService {
    User findByUserName(String userName);
    boolean save (SystemUser systemUser);
}
