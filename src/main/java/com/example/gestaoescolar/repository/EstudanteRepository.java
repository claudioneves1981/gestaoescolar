package com.example.gestaoescolar.repository;

import com.example.gestaoescolar.models.Estudante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudanteRepository extends JpaRepository<Estudante, Long> {

}
