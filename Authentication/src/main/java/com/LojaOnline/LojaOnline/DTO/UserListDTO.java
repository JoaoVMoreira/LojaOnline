package com.LojaOnline.LojaOnline.DTO;

import com.LojaOnline.LojaOnline.DataBase.Model.UserRole;
import com.LojaOnline.LojaOnline.DataBase.Model.Users;

public record UserListDTO(String email, String password, String name, String surname, String CPF, String cellNumber, UserRole role, Boolean activated) {
    public UserListDTO(Users data){
        this(data.getEmail(), data.getPassword(), data.getName(), data.getSurname(), data.getCPF(), data.getCel_number(), data.getRole(), data.isActived());
    }
}
