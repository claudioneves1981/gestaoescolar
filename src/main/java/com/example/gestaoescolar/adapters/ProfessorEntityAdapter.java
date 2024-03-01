package com.example.gestaoescolar.adapters;

import com.example.gestaoescolar.dtos.EnderecoDTO;
import com.example.gestaoescolar.dtos.ProfessorDTO;
import com.example.gestaoescolar.models.Endereco;
import com.example.gestaoescolar.models.Login;
import com.example.gestaoescolar.models.Pessoa;
import com.example.gestaoescolar.models.Professores;
import com.example.gestaoescolar.services.ViaCepService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@Data
public class ProfessorEntityAdapter {

    private Professores professor;


    public ProfessorEntityAdapter(ProfessorDTO professoresDTO, EnderecoDTO enderecoDTO){
        professor = toModel(professoresDTO, enderecoDTO);
    }


    public Professores toModel(ProfessorDTO professorDTO, EnderecoDTO enderecoDTO){

        return Professores.builder()
                .area_formacao(professorDTO.getArea_formacao())
                .nivel_academico(professorDTO.getNivel_academico())
                .pessoa(Pessoa.builder()
                        .nome(professorDTO.getNome())
                        .email(professorDTO.getEmail())
                        .genero(professorDTO.getGenero())
                        .identidade(professorDTO.getIdentidade())
                        .nacionalidade(professorDTO.getNacionalidade())
                        .naturalidade(professorDTO.getNaturalidade())
                        .telefone(professorDTO.getTelefone())
                        .nascimento(professorDTO.getNascimento())
                        .endereco(Endereco.builder()
                                .uf(enderecoDTO.getUf())
                                .cep(enderecoDTO.getCep())
                                .localidade(enderecoDTO.getLocalidade())
                                .logradouro(enderecoDTO.getLogradouro())
                                .numero(professorDTO.getNumero())
                                .complemento(professorDTO.getComplemento())
                                .build())
                        .build())
                .build();
    }
}
