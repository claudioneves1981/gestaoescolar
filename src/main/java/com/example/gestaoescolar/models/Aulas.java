package com.example.gestaoescolar.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "tb_aulas")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Aulas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_AULAS")
    private Long id_aulas;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinTable(
            name="TB_AULAS_PROFESSORES",
            joinColumns = @JoinColumn(name = "ID_AULAS", referencedColumnName = "ID_AULAS"),
            inverseJoinColumns = @JoinColumn(name = "ID_PROFESSOR",referencedColumnName = "ID_PROFESSOR")
    )
    private Professores id_professor;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinTable(
            name="TB_AULAS_CURSOS",
            joinColumns = @JoinColumn(name = "ID_AULAS", referencedColumnName = "ID_AULAS"),
            inverseJoinColumns = @JoinColumn(name = "ID_CURSO",referencedColumnName = "ID_CURSO")
    )
    private Cursos id_curso;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinTable(
            name="TB_AULAS_CLASSES",
            joinColumns = @JoinColumn(name = "ID_AULAS", referencedColumnName = "ID_AULAS"),
            inverseJoinColumns = @JoinColumn(name = "ID_CLASSE",referencedColumnName = "ID_CLASSE")
    )
    private Classes id_classe;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinTable(
            name="TB_AULAS_TURMAS",
            joinColumns = @JoinColumn(name = "ID_AULAS", referencedColumnName = "ID_AULAS"),
            inverseJoinColumns = @JoinColumn(name = "ID_TURMA",referencedColumnName = "ID_TURMA")
    )
    private Turmas id_turma;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinTable(
            name="TB_AULAS_DISCIPLINAS",
            joinColumns = @JoinColumn(name = "ID_AULAS", referencedColumnName = "ID_AULAS"),
            inverseJoinColumns = @JoinColumn(name = "ID_DISCIPLINA",referencedColumnName = "ID_DISCIPLINA")
    )
    private Disciplina id_disciplina;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinTable(
            name="TB_AULAS_PERIODOS",
            joinColumns = @JoinColumn(name = "ID_AULAS", referencedColumnName = "ID_AULAS"),
            inverseJoinColumns = @JoinColumn(name = "ID_PERIODO",referencedColumnName = "ID_PERIODO")
    )
    private Periodos id_periodo;

}
