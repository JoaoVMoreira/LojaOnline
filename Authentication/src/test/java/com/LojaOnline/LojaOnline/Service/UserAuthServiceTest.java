package com.LojaOnline.LojaOnline.Service;

import com.LojaOnline.LojaOnline.DTO.UserPostDTO;
import com.LojaOnline.LojaOnline.DataBase.Model.Users;
import com.LojaOnline.LojaOnline.DataBase.Repository.UserRepository;
import com.LojaOnline.LojaOnline.Exceptions.RepeatedAttributeException;
import com.LojaOnline.LojaOnline.Factorys.UsersFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.util.ReflectionTestUtils;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserAuthServiceTest {

    @InjectMocks
    private TokenService service;

    @InjectMocks
    private UserAuthService userAuthService;

    @Mock
    private UserRepository repository;

    @Mock
    private AuthenticationManager authenticationManager;

    @Mock
    private Authentication authenticate;

    @Mock
    private BCryptPasswordEncoder encoder;

    private String validEmail = "joao@teste.com";
    private Users validUser = UsersFactory.createUser("user Test", true);
    private UserPostDTO userPostDTO = UsersFactory.createUserPostDTO("test");
    private String validToken;
    private UsernamePasswordAuthenticationToken usernamePassword = new UsernamePasswordAuthenticationToken(validUser.getEmail(), validUser.getPassword());


    private static final String SECRET = "secret-test";

    @BeforeEach
    void init(){
        authenticate = mock(Authentication.class);
        ReflectionTestUtils.setField(service, "secret", SECRET);

    }


    @Nested
    class Login{
        @Test
        public void ShouldReturnAValidTokenWhenUserIsAutenticatedAndUserIsActived(){
            validToken = service.tokenGenerator(validUser);
            when(repository.findUsersByEmail(validEmail)).thenReturn(validUser);
            when(authenticationManager.authenticate(usernamePassword)).thenReturn(authenticate);
            when(authenticate.getPrincipal()).thenReturn(validUser);

            var user = repository.findUsersByEmail(validEmail);
            var auth = authenticationManager.authenticate(usernamePassword);
            var result = service.tokenGenerator((Users) auth.getPrincipal());

            assertTrue(user.isActived());
            assertEquals(validToken, result);
        }
    }

    @Nested
    class Register{
        @Test
        public void ShouldCreateAUserWithSuccess(){
            var encryptedPassword = encoder.encode(validUser.getPassword());
            Users testUser = new Users(userPostDTO, encryptedPassword);
            doReturn(testUser).when(repository).save(testUser);

            var result = repository.save(testUser);

            assertEquals(testUser.getEmail(), result.getEmail());
            assertEquals(testUser.getPassword(), result.getPassword());
        }

        @Test
        public void ShouldThrowRepeatedAttributeExceptionWhenEmailExists(){
            when(repository.findByEmail(userPostDTO.email())).thenReturn(validUser);
            assertThrows(RepeatedAttributeException.class, ()->userAuthService.register(userPostDTO));
        }

        @Test
        public void ShouldThrowRepeatedAttributeExceptionWhenCPFExists(){
            when(repository.findByCPF(userPostDTO.CPF())).thenReturn(validUser);
            assertThrows(RepeatedAttributeException.class, ()->userAuthService.register(userPostDTO));
        }

        @Test
        public void ShouldThrowRepeatedAttributeExceptionWhenCelNumberExists(){
            when(repository.findByCel_number(userPostDTO.cellNumber())).thenReturn(validUser);
            assertThrows(RepeatedAttributeException.class, ()->userAuthService.register(userPostDTO));
        }
    }

}