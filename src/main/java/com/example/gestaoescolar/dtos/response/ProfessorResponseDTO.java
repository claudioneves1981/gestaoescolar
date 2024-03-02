package com.example.gestaoescolar.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProfessorResponseDTO {

    private String area_formacao;
    private String nome;
    private String nivel_academico;
}
