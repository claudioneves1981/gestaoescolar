package com.example.gestaoescolar.adapters;

import com.example.gestaoescolar.dtos.NotaDTO;
import com.example.gestaoescolar.models.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class NotaEntityAdapter {

    private List<Notas> notas;
    private Notas nota;

    public NotaEntityAdapter(List<NotaDTO> notasDTO){
        notas = toModelList(notasDTO);
    }

    public NotaEntityAdapter(NotaDTO notasDTO){
        nota = toModel(notasDTO);
    }

    public List<Notas> toModelList(List<NotaDTO> notasDTO){
        List<Notas> notas = new ArrayList<>();
        for(NotaDTO notaDTO : notasDTO){
            notas.add(toModel(notaDTO));
        }
        return notas;
    }

    public Notas toModel(NotaDTO notaDTO){
        return Notas.builder()
                .nota1(notaDTO.getNota1())
                .nota2(notaDTO.getNota2())
                .nota3(notaDTO.getNota3())
                .id_aula(Aulas.builder()
                        .id_aulas(notaDTO.getId_aula())
                        .id_disciplina(Disciplina.builder()
                                .disciplina(notaDTO.getDisciplina())
                                .build())
                        .build())
                .id_matricula(Matriculas.builder()
                        .id_estudante(Estudante.builder()
                                .id_pessoa(Pessoa.builder()
                                        .nome(notaDTO.getEstudante())
                                        .build())
                                .build())
                        .id_matricula(notaDTO.getId_matricula())
                        .build())
                .build();
    }
}
