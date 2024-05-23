package com.LojaOnline.LojaOnline.DataBase.Repository;

import com.LojaOnline.LojaOnline.DataBase.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<Users, String> {
    UserDetails findByEmail(String email);
    Users findByCPF(String CPF);
    @Query(
            value = "SELECT * FROM users WHERE user_email = :email",
            nativeQuery = true
    )
    Users findUsersByEmail(String email);
    @Query(
            value = "SELECT * FROM users WHERE user_cel_number = :cel_number",
            nativeQuery = true
    )
    Users findByCel_number(String cel_number);
}
