package com.resul.bookstore.dto;

import com.resul.bookstore.entity.RoleEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserDTO {
    private String name;
    private String email;
    private String phone;
    private String username;
    private String password;
}
