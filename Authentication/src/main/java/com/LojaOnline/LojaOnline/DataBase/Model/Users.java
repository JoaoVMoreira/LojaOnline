package com.LojaOnline.LojaOnline.DataBase.Model;

import com.LojaOnline.LojaOnline.DTO.UserPostDTO;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "users")
@Table(name = "users")
public class Users implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(name = "user_email", length = 255, unique = true)
    private String email;
    @Column(name = "user_password", length = 255)
    private String password;
    @Column(name = "user_name", length = 255)
    private String name;
    @Column(name = "user_surname", length = 255)
    private String surname;
    @Column(name = "user_CPF", length = 11, unique = true)
    private String CPF;
    @Column(name = "user_cel_number", length = 11, unique = true)
    private String cel_number;
    @Column(name = "user_role", length = 255)
    private UserRole role;
    @Column(name = "user_actived")
    private boolean actived = true;

    public Users(UserPostDTO data, String password){
        this.email = data.email();
        this.password = password;
        this.name = data.name();
        this.surname = data.surname();
        this.CPF = data.CPF();
        this.cel_number = data.cellNumber();
        this.role = data.role();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("USER"), new SimpleGrantedAuthority("ADMIN"));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
