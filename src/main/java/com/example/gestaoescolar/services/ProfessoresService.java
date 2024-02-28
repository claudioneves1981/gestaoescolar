package com.example.gestaoescolar.services;

import com.example.gestaoescolar.adapters.ProfessorEntityAdapter;
import com.example.gestaoescolar.adapters.ProfessoresDTOAdapter;
import com.example.gestaoescolar.dtos.ProfessorDTO;
import com.example.gestaoescolar.exceptions.ProfessorException;
import com.example.gestaoescolar.models.*;
import com.example.gestaoescolar.repository.ProfessoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfessoresService {

    @Autowired
    private ProfessoresRepository professoresRepository;

    public void createProfessor(ProfessorDTO professorDTO) {

        ProfessorEntityAdapter professorEntityAdapter = new ProfessorEntityAdapter(professorDTO);
        Professores professor = professorEntityAdapter.getProfessor();
        professoresRepository.save(professor);
    }

    public ProfessorDTO findByProfessor(Long id_professorDTO) throws ProfessorException {
        Professores professor = professoresRepository.findById(id_professorDTO).orElseThrow(ProfessorException::new);
        ProfessoresDTOAdapter professoresDTOAdapter = new ProfessoresDTOAdapter(professor);
        return professoresDTOAdapter.getProfessorDTO();
    }

    public List<ProfessorDTO> listProfessores(){

        List<Professores> allProfessores = professoresRepository.findAll();
        ProfessoresDTOAdapter professorDTOAdapter = new ProfessoresDTOAdapter(allProfessores);
        return allProfessores.stream()
                .map(professorDTOAdapter::toDTO)
                .collect(Collectors.toList());
    }

}
