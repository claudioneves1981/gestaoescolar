package com.example.gestaoescolar.dtos;

import com.example.gestaoescolar.models.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AulasDTO {

    private String professor;
    private String curso;
    private String classe;
    private String turma;
    private String disciplina;
    private String periodo;

}
