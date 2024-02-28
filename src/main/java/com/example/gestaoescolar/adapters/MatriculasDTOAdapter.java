package com.example.gestaoescolar.adapters;

import com.example.gestaoescolar.dtos.MatriculaDTO;
import com.example.gestaoescolar.models.Matriculas;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class MatriculasDTOAdapter {

    private List<MatriculaDTO> matriculasDTO;
    private MatriculaDTO matriculaDTO;

    public MatriculasDTOAdapter(List<Matriculas> matriculas){
        matriculasDTO = toDTOList(matriculas);
    }

    public MatriculasDTOAdapter(Matriculas matriculas){
        matriculaDTO = toDTO(matriculas);
    }

    public List<MatriculaDTO> toDTOList(List<Matriculas> matriculas){
        List<MatriculaDTO> matriculasDTO = new ArrayList<>();
        for(Matriculas matricula : matriculas){
            matriculasDTO.add(toDTO(matricula));
        }
        return matriculasDTO;
    }

    public MatriculaDTO toDTO(Matriculas matricula){
        return MatriculaDTO.builder()
                .ano(matricula.getId_ano().getAno())
                .curso(matricula.getId_curso().getCurso())
                .classe(matricula.getId_classe().getClasse())
                .periodo(matricula.getId_periodo().getPeriodo())
                .data_matricula(matricula.getData_matricula())
                .turma(matricula.getId_turma().getTurma())
                .nome(matricula.getId_estudante().getId_pessoa().getNome())
                .build();
    }

}
