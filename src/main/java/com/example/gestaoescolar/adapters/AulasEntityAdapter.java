package com.example.gestaoescolar.adapters;

import com.example.gestaoescolar.dtos.AulasDTO;
import com.example.gestaoescolar.models.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class AulasEntityAdapter {

    private List<Aulas> aulas;
    private Aulas aula;

    public AulasEntityAdapter(List<AulasDTO> aulasDTO){
        aulas = toModelList(aulasDTO);
    }

    public AulasEntityAdapter(AulasDTO aulasDTO){
        aula = toModel(aulasDTO);
    }

    public List<Aulas> toModelList(List<AulasDTO> aulasDTO){
        List<Aulas> aulas = new ArrayList<>();
        for(AulasDTO aula : aulasDTO){
            aulas.add(toModel(aula));
        }
        return aulas;
    }

    public Aulas toModel(AulasDTO aulasDTO){
        return Aulas.builder()
                .id_classe(Classes.builder()
                        .classe(aulasDTO.getClasse())
                        .build())
                .id_curso(Cursos.builder()
                        .curso(aulasDTO.getCurso())
                        .build())
                .id_disciplina(Disciplina.builder()
                        .disciplina(aulasDTO.getDisciplina())
                        .build())
                .id_periodo(Periodos.builder()
                        .periodo(aulasDTO.getPeriodo())
                        .build())
                .id_professor(Professores.builder()
                        .pessoa(Pessoa.builder()
                                .nome(aulasDTO.getProfessor())
                                .build())
                        .build())
                .id_turma(Turmas.builder()
                        .turma(aulasDTO.getTurma())
                        .build())
                .build();
    }
}
