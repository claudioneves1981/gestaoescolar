package com.example.gestaoescolar.adapters;

import com.example.gestaoescolar.dtos.NotaDTO;
import com.example.gestaoescolar.models.Notas;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class NotaDTOAdapter {

    private List<NotaDTO> notasDTO;
    private NotaDTO notaDTO;

    public NotaDTOAdapter(List<Notas> notas){
        notasDTO = toDTOList(notas);
    }

    public NotaDTOAdapter(Notas notas){
        notaDTO = toDTO(notas);
    }

    public List<NotaDTO> toDTOList(List<Notas> notas){
        List<NotaDTO> notasDTO = new ArrayList<>();
        for(Notas nota : notas){
            notasDTO.add(toDTO(nota));
        }
        return notasDTO;
    }

    public NotaDTO toDTO(Notas nota){
        Float media = (nota.getNota1() + nota.getNota2() + nota.getNota3()) / 3;
        return NotaDTO.builder()
                .media(media)
                .disciplina(nota.getId_aula().getId_disciplina().getDisciplina())
                .estudante(nota.getId_matricula().getId_estudante().getId_pessoa().getNome())
                .id_matricula(nota.getId_matricula().getId_matricula())
                .build();
    }
}
