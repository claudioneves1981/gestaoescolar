package com.example.gestaoescolar.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProfessorException extends Exception{

    public ProfessorException(){
        super("Professor Não Encontrado");
    }
}
