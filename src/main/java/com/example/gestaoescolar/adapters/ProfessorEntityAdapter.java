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

    private List<Professores> professores;
    private Professores professor;

    @Autowired
    private ViaCepService viaCepService;

    @Autowired
    private PasswordEncoder encoder;

    public ProfessorEntityAdapter(List<ProfessorDTO> professoresDTO){
        professores = toModelList(professoresDTO);
    }

    public ProfessorEntityAdapter(ProfessorDTO professoresDTO){
        professor = toModel(professoresDTO);
    }

    public List<Professores> toModelList(List<ProfessorDTO> professoresDTO){
        List<Professores> professores = new ArrayList<>();
        for(ProfessorDTO professorDTO : professoresDTO){
            professores.add(toModel(professorDTO));
        }
        return professores;
    }

    public Professores toModel(ProfessorDTO professorDTO){

        String pass = professorDTO.getSenha();
        String cep = professorDTO.getCep();
        EnderecoDTO enderecoDTO = viaCepService.consultarCep(cep);
        List<String> roles = new ArrayList<>();
        roles.add("PROFESSOR");

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
                        .endereco(Endereco.builder()
                                .cep(cep)
                                .numero(professorDTO.getNumero())
                                .complemento(professorDTO.getComplemento())
                                .logradouro(enderecoDTO.getLogradouro())
                                .localidade(enderecoDTO.getLocalidade())
                                .uf(enderecoDTO.getUf())
                                .build())
                        .build())
                .login(Login.builder()
                        .senha(encoder.encode(pass))
                        .roles(roles)
                        .build())
                .build();

    }
}
