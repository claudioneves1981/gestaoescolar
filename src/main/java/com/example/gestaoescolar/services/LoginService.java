package com.example.gestaoescolar.services;

import com.example.gestaoescolar.exceptions.LoginException;
import com.example.gestaoescolar.models.Login;
import com.example.gestaoescolar.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {


    @Autowired
    private LoginRepository loginRepository;

    public Login findByUsuario(String usuario) throws LoginException {
        return loginRepository.findByUsuario(usuario).orElseThrow(LoginException::new);
    }
}
