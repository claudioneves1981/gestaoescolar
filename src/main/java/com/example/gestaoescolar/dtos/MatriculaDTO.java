package com.example.gestaoescolar.dtos;

import com.example.gestaoescolar.models.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MatriculaDTO {

    private Long matricula;
    private String nome;
    private String identidade;
    private String email;
    private LocalDate nascimento;
    private String nacionalidade;
    private String naturalidade;
    private String genero;
    private String nome_mae;
    private String nome_pai;
    private String telefone_mae;
    private String telefone_pai;
    private String trabalho_mae;
    private String trabalho_pai;
    private String cep;
    private String numero;
    private String complemento;
    private String logradouro;
    private String localidade;
    private String uf;
    private Integer ano;
    private String  curso;
    private String classe;
    private String turma;
    private String periodo;
    private String usuario;
    private String senha;
    private LocalDate data_matricula;


}
