package com.example.gestaoescolar.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "tb_professores")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Professores {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PROFESSOR")
    private Long id_professor;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinTable(
            name="TB_PROFESSOR_PESSOA",
            joinColumns = @JoinColumn(name = "ID_PROFESSOR", referencedColumnName = "ID_PROFESSOR"),
            inverseJoinColumns = @JoinColumn(name = "ID_PESSOA",referencedColumnName = "ID_PESSOA")
    )
    private Pessoa pessoa;

    private String nivel_academico;

    private String area_formacao;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinTable(
            name="TB_PROFESSOR_LOGIN",
            joinColumns = @JoinColumn(name = "ID_PROFESSOR", referencedColumnName = "ID_PROFESSOR"),
            inverseJoinColumns = @JoinColumn(name = "ID_USUARIO",referencedColumnName = "ID_USUARIO")
    )
    private Login login;

}
