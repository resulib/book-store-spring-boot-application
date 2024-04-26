package com.resul.bookstore.manager;

import com.resul.bookstore.entity.UserEntity;
import com.resul.bookstore.exception.UserNotFoundException;
import com.resul.bookstore.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserManager {
    private final UserRepository userRepository;

    public UserEntity getUser(Long id){
        return userRepository.findByIdAndIsDeleted(id, false)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
    }
}
