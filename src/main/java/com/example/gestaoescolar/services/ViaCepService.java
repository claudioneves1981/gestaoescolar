package com.example.gestaoescolar.services;

import com.example.gestaoescolar.dtos.EnderecoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

    @FeignClient(name = "viacep", url = "http://viacep.com.br/ws")
    @RestController
    public interface ViaCepService {

        @RequestMapping(method = RequestMethod.GET, value = "/{cep}/json/")
        EnderecoDTO consultarCep(@PathVariable("cep") String cep);

    }
