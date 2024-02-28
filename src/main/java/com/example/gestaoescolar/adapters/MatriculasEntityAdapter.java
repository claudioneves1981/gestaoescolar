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

    private List<Matriculas> matriculas;
    private Matriculas matricula;

    @Autowired
    private ViaCepService viaCepService;

    @Autowired
    private PasswordEncoder encoder;


    public MatriculasEntityAdapter(List<MatriculaDTO> matriculasDTO){
        matriculas = toModelList(matriculasDTO);
    }

    public MatriculasEntityAdapter(MatriculaDTO matriculasDTO){
        matricula = toModel(matriculasDTO);
    }

    public List<Matriculas> toModelList(List<MatriculaDTO> matriculasDTO){
        List<Matriculas> matriculas = new ArrayList<>();
        for(MatriculaDTO matriculaDTO : matriculasDTO){
            matriculas.add(toModel(matriculaDTO));
        }
        return matriculas;
    }

    public Matriculas toModel(MatriculaDTO matriculaDTO){
        String pass = matriculaDTO.getSenha();
        String cep = matriculaDTO.getCep();
        EnderecoDTO enderecoDTO = viaCepService.consultarCep(cep);
        List<String> roles = new ArrayList<>();
        roles.add("ESTUDANTE");
        roles.add("PROFESSOR");
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
                                        .cep(cep)
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
                .login(Login.builder()
                        .senha(encoder.encode(pass))
                        .roles(roles)
                        .build())
                .build();
    }
}
