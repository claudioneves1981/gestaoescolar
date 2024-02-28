package com.example.gestaoescolar.services;

import com.example.gestaoescolar.adapters.AulasDTOAdapter;
import com.example.gestaoescolar.adapters.AulasEntityAdapter;
import com.example.gestaoescolar.dtos.AulasDTO;
import com.example.gestaoescolar.models.*;
import com.example.gestaoescolar.repository.AulasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AulasService {

    @Autowired
    private AulasRepository aulasRepository;

    public void createAula(AulasDTO aulasDTO){

        AulasEntityAdapter aulasEntityAdapter = new AulasEntityAdapter(aulasDTO);
        Aulas aula = aulasEntityAdapter.getAula();
        aulasRepository.save(aula);
    }

    public void deleteAula(String disciplina){
        aulasRepository.deleteByDisciplina(disciplina);
    }

    public List<AulasDTO> listAulas(){
        List<Aulas> allAulas = aulasRepository.findAll();
        AulasDTOAdapter aulaDTOAdapter = new AulasDTOAdapter(allAulas);
        return allAulas.stream()
                .map(aulaDTOAdapter::toDTO)
                .collect(Collectors.toList());
    }
}
