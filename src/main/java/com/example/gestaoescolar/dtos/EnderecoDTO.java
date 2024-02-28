package com.example.gestaoescolar.dtos;

import lombok.Data;

@Data
public class EnderecoDTO {

    private String cep;
    private String logradouro;
    private String localidade;
    private String uf;

}
