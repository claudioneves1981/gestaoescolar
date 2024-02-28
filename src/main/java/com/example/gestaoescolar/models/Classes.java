package com.example.gestaoescolar.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "tb_classes")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Classes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CLASSE")
    private Long id_classe;
    private String classe;
}
