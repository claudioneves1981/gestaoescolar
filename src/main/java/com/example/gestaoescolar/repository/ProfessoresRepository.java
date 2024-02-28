package com.example.gestaoescolar.repository;

import com.example.gestaoescolar.models.Professores;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessoresRepository extends JpaRepository<Professores, Long> {
}
