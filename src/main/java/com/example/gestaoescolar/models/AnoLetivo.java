package com.example.gestaoescolar.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "tb_ano_letivo")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AnoLetivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ANO")
    private Long id_ano;

    private Integer ano;
}
