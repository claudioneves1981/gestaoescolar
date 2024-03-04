package com.example.gestaoescolar.adapters;

import com.example.gestaoescolar.dtos.NotaDTO;
import com.example.gestaoescolar.dtos.response.NotaResponseDTO;
import com.example.gestaoescolar.models.Notas;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class NotaDTOAdapter {

    private List<NotaResponseDTO> notasDTO;
    private NotaResponseDTO notaDTO;

    public NotaDTOAdapter(List<Notas> notas){
        notasDTO = toDTOList(notas);
    }

    public NotaDTOAdapter(Notas notas){
        notaDTO = toDTO(notas);
    }

    public List<NotaResponseDTO> toDTOList(List<Notas> notas){
        List<NotaResponseDTO> notasDTO = new ArrayList<>();
        for(Notas nota : notas){
            notasDTO.add(toDTO(nota));
        }
        return notasDTO;
    }

    public NotaResponseDTO toDTO(Notas nota){
        Float media = (nota.getNota1() + nota.getNota2() + nota.getNota3()) / 3;
        return NotaResponseDTO.builder()
                .media(media)
                .nota1(nota.getNota1())
                .nota2(nota.getNota2())
                .nota3(nota.getNota3())
                .nome(nota.getId_matricula().getId_estudante().getId_pessoa().getNome())
                .disciplina(nota.getId_aula().getId_disciplina().getDisciplina())
                .build();
    }
}
