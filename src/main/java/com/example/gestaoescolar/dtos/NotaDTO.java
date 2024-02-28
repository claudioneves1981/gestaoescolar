package com.example.gestaoescolar.dtos;

import com.example.gestaoescolar.models.Aulas;
import com.example.gestaoescolar.models.Matriculas;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NotaDTO {

    private Long id_matricula;
    private String estudante;
    private Long id_aula;
    private String disciplina;
    private Float nota1;
    private Float nota2;
    private Float nota3;
    private Float media;

}
