package com.example.gestaoescolar.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "tb_notas")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Notas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_NOTA")
    private Long id_nota;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinTable(
            name="TB_NOTA_MATRICULA",
            joinColumns = @JoinColumn(name = "ID_NOTA", referencedColumnName = "ID_NOTA"),
            inverseJoinColumns = @JoinColumn(name = "ID_MATRICULA",referencedColumnName = "ID_MATRICULA")
    )
    private Matriculas id_matricula;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinTable(
            name="TB_NOTA_AULA",
            joinColumns = @JoinColumn(name = "ID_NOTA", referencedColumnName = "ID_NOTA"),
            inverseJoinColumns = @JoinColumn(name = "ID_AULAS",referencedColumnName = "ID_AULAS")
    )
    private Aulas id_aula;

    private Float nota1;
    private Float nota2;
    private Float nota3;

    //Criar NotaDTO e Adapter.
}
