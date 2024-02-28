package com.example.gestaoescolar.services;

import com.example.gestaoescolar.adapters.AulasDTOAdapter;
import com.example.gestaoescolar.adapters.MatriculasDTOAdapter;
import com.example.gestaoescolar.adapters.MatriculasEntityAdapter;
import com.example.gestaoescolar.dtos.EnderecoDTO;
import com.example.gestaoescolar.dtos.MatriculaDTO;
import com.example.gestaoescolar.exceptions.MatriculasException;
import com.example.gestaoescolar.models.*;
import com.example.gestaoescolar.repository.MatriculasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MatriculaService {


    @Autowired
    private MatriculasRepository matriculasRepository;

    public void createMatricula(MatriculaDTO matriculaDTO) {
        MatriculasEntityAdapter matriculasEntityAdapter = new MatriculasEntityAdapter(matriculaDTO);
        Matriculas matricula = matriculasEntityAdapter.getMatricula();
        matriculasRepository.save(matricula);
    }

    public MatriculaDTO findByMatricula(Long id_matricula) throws MatriculasException {
        Matriculas matricula = matriculasRepository.findById(id_matricula).orElseThrow(MatriculasException::new);
        MatriculasDTOAdapter matriculasDTOAdapter = new MatriculasDTOAdapter(matricula);
        return matriculasDTOAdapter.getMatriculaDTO();
    }

    public List<MatriculaDTO> listMatriculas(){

        List<Matriculas> allMatriculas = matriculasRepository.findAll();
        MatriculasDTOAdapter matriculaDTOAdapter = new MatriculasDTOAdapter(allMatriculas);
        return allMatriculas.stream()
                .map(matriculaDTOAdapter::toDTO)
                .collect(Collectors.toList());
    }

}
