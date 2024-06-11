package com.LojaOnline.LojaOnline.Service;

import com.LojaOnline.LojaOnline.DataBase.Repository.UserRepository;
import com.LojaOnline.LojaOnline.Factorys.UsersFactory;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AuthenticationServiceTest {

    @Mock
    private UserRepository repository;
    private String validEmail = "test@mail.com";
    private String invalidEmail = "testInvalid@mail.com";
    private UserDetails userDetails = UsersFactory.createUser("test", true);

    @Nested
    class loadUserByUsername{
        @Test
        public void ShouldReturnUserDetailsWhenSendEmail(){
            when(repository.findByEmail(validEmail)).thenReturn(userDetails);

            var result = repository.findByEmail(validEmail);

            assertEquals(result.getUsername(), userDetails.getUsername());
        }

        @Test
        public void ShoulThrowUsernameNotFoundExceptionWhenEmailIsNotFound(){
            when(repository.findByEmail(invalidEmail)).thenThrow(UsernameNotFoundException.class);

            assertThrows(UsernameNotFoundException.class, () -> repository.findByEmail(invalidEmail));
        }
    }

}