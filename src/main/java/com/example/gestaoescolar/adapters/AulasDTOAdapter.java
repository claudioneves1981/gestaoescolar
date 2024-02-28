package com.example.gestaoescolar.adapters;

import com.example.gestaoescolar.dtos.AulasDTO;
import com.example.gestaoescolar.models.Aulas;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class AulasDTOAdapter {

    private List<AulasDTO> aulasDTO;
    private AulasDTO aulaDTO;

    public AulasDTOAdapter(List<Aulas> aulas){
        aulasDTO = toDTOList(aulas);
    }

    public AulasDTOAdapter(Aulas aulas){
        aulaDTO = toDTO(aulas);
    }

    public List<AulasDTO> toDTOList(List<Aulas> aulas){
        List<AulasDTO> aulasDTO = new ArrayList<>();
        for(Aulas aula : aulas){
            aulasDTO.add(toDTO(aula));
        }
        return aulasDTO;
    }

    public AulasDTO toDTO(Aulas aula){
        return AulasDTO.builder()
                .classe(aula.getId_classe().getClasse())
                .curso(aula.getId_curso().getCurso())
                .disciplina(aula.getId_disciplina().getDisciplina())
                .periodo(aula.getId_periodo().getPeriodo())
                .professor(aula.getId_professor().getPessoa().getNome())
                .turma(aula.getId_turma().getTurma())
                .build();
    }
}
