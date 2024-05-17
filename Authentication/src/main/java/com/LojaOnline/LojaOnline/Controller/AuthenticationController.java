package com.LojaOnline.LojaOnline.Controller;

import com.LojaOnline.LojaOnline.DTO.LoginDTO;
import com.LojaOnline.LojaOnline.DTO.LoginPostDTO;
import com.LojaOnline.LojaOnline.DTO.UserListDTO;
import com.LojaOnline.LojaOnline.DTO.UserPostDTO;
import com.LojaOnline.LojaOnline.DataBase.Model.Users;
import com.LojaOnline.LojaOnline.Service.UserAuthService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    UserAuthService service;

    @PostMapping("/login")
    public ResponseEntity<LoginDTO> login(@RequestBody @Valid LoginPostDTO data){
        var token = service.login(data.email(), data.password());
        return ResponseEntity.ok(new LoginDTO(token));
    }

    @PostMapping("/register")
    @Transactional
    public ResponseEntity<UserListDTO> register(@RequestBody @Valid UserPostDTO data, UriComponentsBuilder uriComponentsBuilder){
        Users user = service.register(data);
        var uri =uriComponentsBuilder.path("/auth/signup")
                .buildAndExpand(user.getId())
                .toUri();
        return ResponseEntity.created(uri).body(new UserListDTO(user));
    }
}
