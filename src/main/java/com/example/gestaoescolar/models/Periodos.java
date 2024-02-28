package com.example.gestaoescolar.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "tb_periodos")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Periodos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PERIODO")
    private Long id_periodo;

    private String periodo;
}
