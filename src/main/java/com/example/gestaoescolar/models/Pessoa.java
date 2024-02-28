package com.example.gestaoescolar.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "tb_pessoa")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PESSOA")
    private Long id_pessoa;

    private String nome;
    private String identidade;
    private LocalDate nascimento;
    private String nacionalidade;
    private String naturalidade;
    private String genero;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinTable(
            name="TB_PESSOA_ENDERECO",
            joinColumns = @JoinColumn(name = "ID_PESSOA", referencedColumnName = "ID_PESSOA"),
            inverseJoinColumns = @JoinColumn(name = "ID_ENDERECO",referencedColumnName = "ID_ENDERECO")
    )
    private Endereco endereco;

    private String email;
    private String telefone;

}
