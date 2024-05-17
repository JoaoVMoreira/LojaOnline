package com.LojaOnline.LojaOnline.DataBase.Repository;

import com.LojaOnline.LojaOnline.DataBase.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<Users, String> {
    UserDetails findByEmail(String email);

    @Query(
            value = "SELECT * FROM users WHERE user_email = :email",
            nativeQuery = true
    )
    Users findUsersByEmail(String email);
}
