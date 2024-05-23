package com.LojaOnline.LojaOnline.Service;

import com.LojaOnline.LojaOnline.DataBase.Model.Users;
import com.LojaOnline.LojaOnline.DataBase.Repository.UserRepository;
import com.LojaOnline.LojaOnline.Factorys.UsersFactory;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.Verification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TokenServiceTest {

    @InjectMocks
    private TokenService service;

    @Mock
    private UserRepository repository;

    private static final String SECRET = "secret-test";

    private String validToken = "TOKEN_VALIDO";
    private Users validUser = UsersFactory.createUser("testUser", true);
    private Algorithm algorithm;

    @Captor
    private ArgumentCaptor<Instant> expiresAtCaptur;

    @Captor
    private ArgumentCaptor<Algorithm> algorithmArgumentCaptor;

    @BeforeEach
    public void setUp(){
        ReflectionTestUtils.setField(service, "secret", SECRET);
        algorithm = Algorithm.HMAC256(SECRET);
    }

    @Nested
    class TokenGenerator{

        @Test
        public void ShouldReturnAStringWhenUserExistsAndIsActived(){
            JWTCreator.Builder builder = mock(JWTCreator.Builder.class);
            when(builder.withIssuer("auth")).thenReturn(builder);
            when(builder.withSubject(validUser.getEmail())).thenReturn(builder);
            when(builder.withExpiresAt(expiresAtCaptur.capture())).thenReturn(builder);
            when(builder.sign(any(Algorithm.class))).thenReturn(validToken);
            try (MockedStatic<JWT> staticMock = mockStatic(JWT.class)) {
                staticMock.when(JWT::create).thenReturn(builder);
                String result = service.tokenGenerator(validUser);
                assertEquals(validToken, result);
            }

            /*
            * Primeiramente mockamos o Builder do JWTCreator para realizar os mocks dos metodos de geração de token
            * Em seguida realiamos os mocks dos metodos utilizados para realziar a geração do token
            * Abrimos um Try-with-recources para que possamos mockar de forma estática a classe JWT, que será utilizada para acionar o metodo estático JWT.create, sem que afetemos futuros possiveis testes
            * Em seguida utilizamos o mock estático criado nos parâmetros do try-with-recources  para mockar o metodo JWT.create()
            * Em seguida acionamos o tokenGenerator
            * Para finalziar comparamos o retorno do acionamento anterior com o token esperado.
            * */
        }
    }

    @Nested
    class TokenValidation{
        @Test
        public void ShouldReturnUserEmailWhenReciveAValidToken(){
            JWTVerifier jwtVerifier = mock(JWTVerifier.class);
            Verification verifier = mock(Verification.class);
            DecodedJWT decodedJWT = mock(DecodedJWT.class);

            when(verifier.withIssuer("auth")).thenReturn(verifier);
            when(verifier.build()).thenReturn(jwtVerifier);
            when(jwtVerifier.verify(validToken)).thenReturn(decodedJWT);
            when(decodedJWT.getSubject()).thenReturn(validUser.getEmail());

            try(MockedStatic<JWT> staticMock = mockStatic(JWT.class)){
                staticMock.when(() -> JWT.require(algorithmArgumentCaptor.capture())).thenReturn(verifier);

                String result = service.validationToken(validToken);
                assertEquals(result, validUser.getEmail());

                /*
                * Primeiramente abrimos um try-with-recources, para que possamos utilizar mocks estáticos sem afetar outros testes, uma vez que ao finalizar o try o mock será restaurado
                * Em seguida mockamos de forma estática a classe JWT, uma vez que o metodo JWT.require() é estático
                * Em seguida utilizamos o mock Estatico criado para mockar o JWT.require(), passando o capture de um algorithm nos parâmetros e retornando verifier, uma vez que o metodo em questão retorna um objeto do tipo Verification.
                * Em seguida mockamos os metodos que foram utilizados para realziar a validação e pegar o subject
                * Acionamos o service.validationToken
                * Finalmente comparamos o retorno da chamada com o e-mail esperado.
                * */
            }
        }
    }
}