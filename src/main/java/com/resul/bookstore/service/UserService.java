package com.resul.bookstore.service;

import com.resul.bookstore.dto.CreateUserDTO;
import com.resul.bookstore.dto.UpdateUserDTO;
import com.resul.bookstore.dto.UserDTO;
import com.resul.bookstore.entity.RoleEnum;
import com.resul.bookstore.manager.UserManager;
import com.resul.bookstore.mapper.UserMapper;
import com.resul.bookstore.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final UserManager userManager;

    public List<UserDTO> findAll() {
        var users = userRepository.findAll();
        return userMapper.toUserDTOList(users);
    }

    public void create(CreateUserDTO createUserDTO) {
        var user = userMapper.toUserEntity(createUserDTO);
        user.setRole(RoleEnum.USER);
        userRepository.save(user);
    }

    public UserDTO findById(Long id) {
        var user = userManager.getUser(id);
        return userMapper.toUserDTO(user);
    }

    public void update(Long id, UpdateUserDTO updateUserDTO) {
        var user = userManager.getUser(id);
        userMapper.toUserEntity(updateUserDTO, user);
        userRepository.save(user);
    }

    public void delete(Long id) {
        var user = userManager.getUser(id);
        user.setDeleted(true);
        userRepository.save(user);
    }
}
