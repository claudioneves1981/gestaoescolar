package com.example.gestaoescolar.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MatriculaResponseDTO {

    private Integer ano;
    private String curso;
    private String classe;
    private String periodo;
    private LocalDate data_matricula;
    private String turma;
    private String nome;
}
