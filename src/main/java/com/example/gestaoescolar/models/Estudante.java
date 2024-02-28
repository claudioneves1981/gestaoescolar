package com.example.gestaoescolar.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "tb_estudante")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Estudante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ESTUDANTE")
    private Long id_estudante;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinTable(
            name="TB_ESTUDANTE_PESSOA",
            joinColumns = @JoinColumn(name = "ID_ESTUDANTE", referencedColumnName = "ID_ESTUDANTE"),
            inverseJoinColumns = @JoinColumn(name = "ID_PESSOA",referencedColumnName = "ID_PESSOA")
    )
    private Pessoa id_pessoa;

    private String nome_pai;
    private String trabalho_pai;
    private String telefone_pai;
    private String nome_mae;
    private String trabalho_mae;
    private String telefone_mae;

}
