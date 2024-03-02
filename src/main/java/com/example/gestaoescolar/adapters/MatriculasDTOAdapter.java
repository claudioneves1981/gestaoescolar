package com.example.gestaoescolar.adapters;

import com.example.gestaoescolar.dtos.response.MatriculaResponseDTO;
import com.example.gestaoescolar.models.Matriculas;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class MatriculasDTOAdapter {

    private List<MatriculaResponseDTO> matriculasDTO;
    private MatriculaResponseDTO matriculaResponseDTO;

    public MatriculasDTOAdapter(List<Matriculas> matriculas){
        matriculasDTO = toDTOList(matriculas);
    }

    public MatriculasDTOAdapter(Matriculas matriculas){
        matriculaResponseDTO = toDTO(matriculas);
    }

    public List<MatriculaResponseDTO> toDTOList(List<Matriculas> matriculas){
        List<MatriculaResponseDTO> matriculasDTO = new ArrayList<>();
        for(Matriculas matricula : matriculas){
            matriculasDTO.add(toDTO(matricula));
        }
        return matriculasDTO;
    }

    public MatriculaResponseDTO toDTO(Matriculas matricula){
        return MatriculaResponseDTO.builder()
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
