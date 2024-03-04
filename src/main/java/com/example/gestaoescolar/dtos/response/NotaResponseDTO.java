package com.example.gestaoescolar.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NotaResponseDTO {

    private String nome;
    private String disciplina;
    private Float nota1;
    private Float nota2;
    private Float nota3;
    private Float media;
}
