package com.LojaOnline.LojaOnline.Factorys;

import com.LojaOnline.LojaOnline.DTO.UserPostDTO;
import com.LojaOnline.LojaOnline.DataBase.Model.UserRole;
import com.LojaOnline.LojaOnline.DataBase.Model.Users;

public class UsersFactory {
    public static Users createUser(String name, Boolean actived){
        return new Users("1", "test@mail.com", "123456", name, "teste", "55555555555", "22222222222", UserRole.ADMIN, actived);
    }

    public static UserPostDTO createUserPostDTO(String name){
        return new UserPostDTO("joao@mail.com", name, "surname", "password", "55555555555", "22222222222", UserRole.ADMIN);
    }
}
