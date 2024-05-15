package com.LojaOnline.LojaOnline.Service;

import com.LojaOnline.LojaOnline.DTO.UserPostDTO;
import com.LojaOnline.LojaOnline.DataBase.Model.Users;
import com.LojaOnline.LojaOnline.DataBase.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    public UserRepository repository;

    @Autowired
    public PasswordEncoder passwordEncoder;

    public Users signUpUser(UserPostDTO data){
        var cryptografedPassword = passwordEncoder.encode(data.password());
        var user = new Users(data, cryptografedPassword);
        repository.save(user);
        return user;
    }

}
