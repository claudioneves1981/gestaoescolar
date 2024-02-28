package com.example.gestaoescolar.adapters;

import com.example.gestaoescolar.dtos.ProfessorDTO;
import com.example.gestaoescolar.models.Professores;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ProfessoresDTOAdapter {

    private List<ProfessorDTO> professoresDTO;
    private ProfessorDTO professorDTO;

    public ProfessoresDTOAdapter(List<Professores> professores){
        professoresDTO = toDTOList(professores);
    }

    public ProfessoresDTOAdapter(Professores professores){
        professorDTO = toDTO(professores);
    }

    public List<ProfessorDTO> toDTOList(List<Professores> professores){
        List<ProfessorDTO> professoresDTO = new ArrayList<>();
        for(Professores professor : professores){
            professoresDTO.add(toDTO(professor));
        }
        return professoresDTO;
    }

    public ProfessorDTO toDTO(Professores professor){
        return ProfessorDTO.builder()
                .area_formacao(professor.getArea_formacao())
                .nome(professor.getPessoa().getNome())
                .nivel_academico(professor.getNivel_academico())
                .build();
    }
}
