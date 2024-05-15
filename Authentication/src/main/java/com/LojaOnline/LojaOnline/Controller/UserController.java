package com.LojaOnline.LojaOnline.Controller;

import com.LojaOnline.LojaOnline.DTO.UserListDTO;
import com.LojaOnline.LojaOnline.DTO.UserPostDTO;
import com.LojaOnline.LojaOnline.Service.UserService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    public UserService service;

    @PostMapping("/signup")
    @Transactional
    public ResponseEntity<UserListDTO> signup(@RequestBody @Valid UserPostDTO data, UriComponentsBuilder uriComponentsBuilder){
        var user = service.signUpUser(data);
        var uri =uriComponentsBuilder.path("/auth/signup")
                .buildAndExpand(user.getId())
                .toUri();
        return ResponseEntity.created(uri).body(new UserListDTO(user));
    }
}
