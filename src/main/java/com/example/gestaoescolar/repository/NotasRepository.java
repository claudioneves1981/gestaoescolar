package com.example.gestaoescolar.repository;

import com.example.gestaoescolar.models.Notas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface NotasRepository extends JpaRepository<Notas, Long> {

    @Query("SELECT n FROM Notas n WHERE n.id_matricula.id_matricula = (:matricula)")
    Optional<Notas> findNotaByMatricula(@Param("matricula") Long matricula);

}
