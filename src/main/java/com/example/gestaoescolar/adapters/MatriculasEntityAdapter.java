package com.example.gestaoescolar.adapters;

import com.example.gestaoescolar.dtos.EnderecoDTO;
import com.example.gestaoescolar.dtos.MatriculaDTO;
import com.example.gestaoescolar.models.*;
import com.example.gestaoescolar.services.ViaCepService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@Data
public class MatriculasEntityAdapter {

    private Matriculas matricula;

    public MatriculasEntityAdapter(MatriculaDTO matriculasDTO, EnderecoDTO enderecoDTO){
        matricula = toModel(matriculasDTO, enderecoDTO);
    }


    public Matriculas toModel(MatriculaDTO matriculaDTO, EnderecoDTO enderecoDTO){
        return Matriculas.builder()
                .id_estudante(Estudante.builder()
                        .id_pessoa(Pessoa.builder()
                                .nome(matriculaDTO.getNome())
                                .email(matriculaDTO.getEmail())
                                .genero(matriculaDTO.getGenero())
                                .identidade(matriculaDTO.getIdentidade())
                                .nacionalidade(matriculaDTO.getNacionalidade())
                                .naturalidade(matriculaDTO.getNaturalidade())
                                .endereco(Endereco.builder()
                                        .cep(matriculaDTO.getCep())
                                        .numero(matriculaDTO.getNumero())
                                        .complemento(matriculaDTO.getComplemento())
                                        .logradouro(enderecoDTO.getLogradouro())
                                        .localidade(enderecoDTO.getLocalidade())
                                        .uf(enderecoDTO.getUf())
                                        .build())
                                .build())
                        .nome_mae(matriculaDTO.getNome_mae())
                        .nome_pai(matriculaDTO.getNome_pai())
                        .telefone_mae(matriculaDTO.getTelefone_mae())
                        .telefone_pai(matriculaDTO.getTelefone_pai())
                        .trabalho_mae(matriculaDTO.getTrabalho_mae())
                        .trabalho_pai(matriculaDTO.getTrabalho_pai())
                        .build())
                .data_matricula(matriculaDTO.getData_matricula())
                .id_classe(Classes.builder()
                        .classe(matriculaDTO.getClasse())
                        .build())
                .id_curso(Cursos.builder()
                        .curso(matriculaDTO.getCurso())
                        .build())
                .id_ano(AnoLetivo.builder()
                        .ano(matriculaDTO.getAno())
                        .build())
                .id_periodo(Periodos.builder()
                        .periodo(matriculaDTO.getPeriodo())
                        .build())
                .id_turma(Turmas.builder()
                        .turma(matriculaDTO.getTurma())
                        .build())
                .build();
    }
}
