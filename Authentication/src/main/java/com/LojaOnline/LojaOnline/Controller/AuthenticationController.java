package com.LojaOnline.LojaOnline.Controller;

import com.LojaOnline.LojaOnline.DTO.LoginDTO;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.swing.text.html.parser.Entity;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

    @Autowired
    public AuthenticationManager authenticationManager;

    @PostMapping("/login")
    @Transactional
    public ResponseEntity login(@RequestBody @Valid LoginDTO data, UriComponentsBuilder uriComponentsBuilder){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
        var auth = authenticationManager.authenticate(usernamePassword);

        return ResponseEntity.ok().build();
    }
}
