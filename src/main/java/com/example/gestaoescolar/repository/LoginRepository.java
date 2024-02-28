package com.example.gestaoescolar.repository;

import com.example.gestaoescolar.models.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface LoginRepository extends JpaRepository<Login, Long> {

    @Query("SELECT u FROM Login u JOIN FETCH u.roles WHERE u.usuario = (:usuario)")
    Optional<Login> findByUsuario(@Param("usuario") String usuario);

}
