package com.resul.bookstore.mapper;

import com.resul.bookstore.dto.CreateUserDTO;
import com.resul.bookstore.dto.UpdateUserDTO;
import com.resul.bookstore.dto.UserDTO;
import com.resul.bookstore.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface UserMapper {

    List<UserDTO> toUserDTOList(List<UserEntity> userList);

    UserEntity toUserEntity(CreateUserDTO createUserDTO);

    UserDTO toUserDTO(UserEntity userEntity);
    void toUserEntity(UpdateUserDTO updateUserDTO, @MappingTarget UserEntity userEntity);
}
