package com.example.gestaoescolar.dtos;

import com.example.gestaoescolar.models.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProfessorDTO {

    private String nome;

    private String email;

    private String genero;

    private String identidade;

    private String telefone;

    private LocalDate nascimento;

    private String nacionalidade;

    private String naturalidade;

    private String nivel_academico;

    private String area_formacao;

    private String cep;

    private String numero;

    private String complemento;

    private String logradouro;

    private String localidade;

    private String uf;

    private String senha;

    private String usuario;

    private List<String> roles;

}
