package com.LojaOnline.LojaOnline.Factorys;

import com.LojaOnline.LojaOnline.DataBase.Model.UserRole;
import com.LojaOnline.LojaOnline.DataBase.Model.Users;

public class UsersFactory {
    public static Users createUser(String name, Boolean actived){
        return new Users("1", "joao@mail.com", "123456", name, "teste", "55555555555", "22222222222", UserRole.ADMIN, actived);
    }
}