package com.example.gestaoescolar.repository;

import com.example.gestaoescolar.models.Aulas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AulasRepository extends JpaRepository<Aulas,Long> {

    @Query("SELECT a FROM Aulas a WHERE a.id_disciplina.disciplina = (:disciplina)")
    Optional<Aulas> findAulaByDisciplina(@Param("disciplina") String disciplina);

    @Query("DELETE FROM Aulas a WHERE a.id_disciplina.disciplina = (:disciplina)")
    void deleteByDisciplina(@Param("disciplina") String disciplina);
}
