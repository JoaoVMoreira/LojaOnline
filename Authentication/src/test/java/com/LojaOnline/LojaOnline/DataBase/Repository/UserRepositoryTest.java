package com.LojaOnline.LojaOnline.DataBase.Repository;

import com.LojaOnline.LojaOnline.DataBase.Model.Users;
import com.LojaOnline.LojaOnline.Factorys.UsersFactory;
import org.apache.catalina.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    TestEntityManager testEntityManager;

    @Autowired
    UserRepository repository;

    private String validEmail = "test@mail.com";
    private Users validUser = UsersFactory.createUser("test", true);
    private Users userTest;

    @BeforeEach
    void init(){
        userTest = testEntityManager.merge(validUser);
    }

    @Test
    public void ShouldReturnUserDetailsWhenInfoEmail(){
        var result = repository.findByEmail(validEmail);
        assertEquals(userTest.getEmail(), result.getUsername());
    }

    @Test
    public void ShouldReturnUsersWhenInfoCPF(){
        var result = repository.findByCPF(validUser.getCPF());
        assertEquals(userTest.getEmail(), result.getEmail());
    }

    @Test
    public void ShouldReturnUsersWhenInfoEmail(){
        var result = repository.findUsersByEmail(validEmail);
        assertEquals(userTest.getEmail(), result.getEmail());
    }

    @Test
    public void ShouldReturnUsersWhenInfoCelNumber(){
        var result = repository.findByCel_number(validUser.getCel_number());
        assertEquals(userTest.getEmail(), result.getEmail());
    }


}