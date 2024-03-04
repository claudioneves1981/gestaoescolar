package com.example.gestaoescolar.services;

import com.example.gestaoescolar.adapters.NotaDTOAdapter;
import com.example.gestaoescolar.adapters.NotaEntityAdapter;
import com.example.gestaoescolar.adapters.ProfessoresDTOAdapter;
import com.example.gestaoescolar.dtos.NotaDTO;
import com.example.gestaoescolar.dtos.response.NotaResponseDTO;
import com.example.gestaoescolar.exceptions.NotasException;
import com.example.gestaoescolar.models.Aulas;
import com.example.gestaoescolar.models.Matriculas;
import com.example.gestaoescolar.models.Notas;
import com.example.gestaoescolar.models.Professores;
import com.example.gestaoescolar.repository.AulasRepository;
import com.example.gestaoescolar.repository.MatriculasRepository;
import com.example.gestaoescolar.repository.NotasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NotaService {

    @Autowired
    private NotasRepository notasRepository;

    @Autowired
    private AulasRepository aulasRepository;

    @Autowired
    private MatriculasRepository matriculasRepository;

    public void lancarNotas(NotaDTO notaDTO){
        NotaEntityAdapter notaEntityAdapter = new NotaEntityAdapter(notaDTO);
        Aulas aula = aulasRepository.findById(notaDTO.getId_aula()).get();
        Matriculas matriculas = matriculasRepository.findById(notaDTO.getId_matricula()).get();
        Notas nota = notaEntityAdapter.getNota();
        nota.setId_aula(aula);
        nota.setId_matricula(matriculas);
        notasRepository.save(nota);
    }

    public NotaResponseDTO mediaEstudante(Long id_matricula) throws NotasException {
        Notas notas = notasRepository.findNotaByMatricula(id_matricula).orElseThrow(NotasException::new);
        NotaDTOAdapter notaDTOAdapter = new NotaDTOAdapter(notas);
        return notaDTOAdapter.getNotaDTO();
    }

    public List<NotaResponseDTO> listNotas(){

        List<Notas> allNotas = notasRepository.findAll();
        NotaDTOAdapter notasDTOAdapter = new NotaDTOAdapter(allNotas);
        return allNotas.stream()
                .map(notasDTOAdapter::toDTO)
                .collect(Collectors.toList());
    }

}
