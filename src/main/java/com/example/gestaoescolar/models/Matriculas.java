package com.example.gestaoescolar.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "tb_matriculas")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Matriculas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_MATRICULA")
    private Long id_matricula;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinTable(
            name="TB_MATRICULA_ESTUDANTE",
            joinColumns = @JoinColumn(name = "ID_MATRICULA", referencedColumnName = "ID_MATRICULA"),
            inverseJoinColumns = @JoinColumn(name = "ID_ESTUDANTE",referencedColumnName = "ID_ESTUDANTE")
    )
    private Estudante id_estudante;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinTable(
            name="TB_MATRICULA_ANO",
            joinColumns = @JoinColumn(name = "ID_MATRICULA", referencedColumnName = "ID_MATRICULA"),
            inverseJoinColumns = @JoinColumn(name = "ID_ANO",referencedColumnName = "ID_ANO")
    )
    private AnoLetivo id_ano;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinTable(
            name="TB_MATRICULA_CURSO",
            joinColumns = @JoinColumn(name = "ID_MATRICULA", referencedColumnName = "ID_MATRICULA"),
            inverseJoinColumns = @JoinColumn(name = "ID_CURSO",referencedColumnName = "ID_CURSO")
    )
    private Cursos id_curso;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinTable(
            name="TB_MATRICULA_CLASSE",
            joinColumns = @JoinColumn(name = "ID_MATRICULA", referencedColumnName = "ID_MATRICULA"),
            inverseJoinColumns = @JoinColumn(name = "ID_CLASSE",referencedColumnName = "ID_CLASSE")
    )
    private Classes id_classe;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinTable(
            name="TB_MATRICULA_TURMA",
            joinColumns = @JoinColumn(name = "ID_MATRICULA", referencedColumnName = "ID_MATRICULA"),
            inverseJoinColumns = @JoinColumn(name = "ID_TURMA",referencedColumnName = "ID_TURMA")
    )
    private Turmas id_turma;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinTable(
            name="TB_MATRICULA_PERIODO",
            joinColumns = @JoinColumn(name = "ID_MATRICULA", referencedColumnName = "ID_MATRICULA"),
            inverseJoinColumns = @JoinColumn(name = "ID_PERIODO",referencedColumnName = "ID_PERIODO")
    )
    private Periodos id_periodo;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinTable(
            name="TB_MATRICULA_LOGIN",
            joinColumns = @JoinColumn(name = "ID_MATRICULA", referencedColumnName = "ID_MATRICULA"),
            inverseJoinColumns = @JoinColumn(name = "ID_USUARIO",referencedColumnName = "ID_USUARIO")
    )
    private Login login;

    private LocalDate data_matricula;
}
