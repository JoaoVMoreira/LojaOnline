package com.LojaOnline.LojaOnline.Service;

import com.LojaOnline.LojaOnline.DTO.UserPostDTO;
import com.LojaOnline.LojaOnline.DataBase.Model.Users;
import com.LojaOnline.LojaOnline.DataBase.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserAuthService {

    @Autowired
    TokenService tokenService;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserRepository repository;

    public String login(String email, String password){
        Users user = repository.findUsersByEmail(email);
        if(user.isActived()){
            UsernamePasswordAuthenticationToken usernamePassword = new UsernamePasswordAuthenticationToken(email, password);
            var auth = authenticationManager.authenticate(usernamePassword);
            return tokenService.tokenGenerator((Users) auth.getPrincipal());
        }
        else{
            throw new RuntimeException("User is not actived");
        }
    }

    public Users register(UserPostDTO data){
        String cryptografedPassword = new BCryptPasswordEncoder().encode(data.password());
        Users user = new Users(data, cryptografedPassword);
        repository.save(user);
        return user;
    }
}
