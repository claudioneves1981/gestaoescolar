package com.example.gestaoescolar.controlller;

import com.example.gestaoescolar.dtos.LoginDTO;
import com.example.gestaoescolar.dtos.SessaoDTO;
import com.example.gestaoescolar.exceptions.LoginException;
import com.example.gestaoescolar.models.Login;
import com.example.gestaoescolar.security.JWTCreator;
import com.example.gestaoescolar.security.JWTObject;
import com.example.gestaoescolar.security.SecurityConfig;
import com.example.gestaoescolar.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
    public class LoginController {

        @Autowired
        private PasswordEncoder encoder;

        @Autowired
        private SecurityConfig securityConfig;

        @Autowired
        private LoginService service;

        @PostMapping("/login")
        public SessaoDTO logar(@RequestBody LoginDTO login) throws LoginException {
            Login user = service.findByUsuario(login.getUsuario());
            System.out.print(user);
            if (user != null) {
                boolean passwordOk = encoder.matches(login.getSenha(), user.getSenha());
                if (!passwordOk) {
                    throw new RuntimeException("Senha invalida para o login:" + login.getUsuario());
                }
                SessaoDTO sessao = new SessaoDTO();
                sessao.setLogin(user.getUsuario());

                JWTObject jwtObject = new JWTObject();
                jwtObject.setIssuedAt(new Date(System.currentTimeMillis()));
                jwtObject.setExpiration(new Date(System.currentTimeMillis() + SecurityConfig.EXPIRATION));
                jwtObject.setRoles(user.getRoles());
                sessao.setToken(JWTCreator.create(SecurityConfig.PREFIX, SecurityConfig.KEY, jwtObject));
                return sessao;
            } else {
                throw new RuntimeException("Erro ao tentar fazer login");
            }
        }
}
