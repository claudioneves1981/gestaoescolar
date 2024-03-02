package com.example.gestaoescolar.adapters;

import com.example.gestaoescolar.dtos.response.ProfessorResponseDTO;
import com.example.gestaoescolar.models.Professores;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ProfessoresDTOAdapter {

    private List<ProfessorResponseDTO> professoresDTO;
    private ProfessorResponseDTO professorResponseDTO;

    public ProfessoresDTOAdapter(List<Professores> professores){
        professoresDTO = toDTOList(professores);
    }

    public ProfessoresDTOAdapter(Professores professores){
        professorResponseDTO = toDTO(professores);
    }

    public List<ProfessorResponseDTO> toDTOList(List<Professores> professores){
        List<ProfessorResponseDTO> professoresDTO = new ArrayList<>();
        for(Professores professor : professores){
            professoresDTO.add(toDTO(professor));
        }
        return professoresDTO;
    }

    public ProfessorResponseDTO toDTO(Professores professor){
        return ProfessorResponseDTO.builder()
                .area_formacao(professor.getArea_formacao())
                .nome(professor.getPessoa().getNome())
                .nivel_academico(professor.getNivel_academico())
                .build();
    }
}
