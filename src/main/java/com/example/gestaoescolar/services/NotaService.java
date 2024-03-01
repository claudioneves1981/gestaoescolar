package com.example.gestaoescolar.services;

import com.example.gestaoescolar.adapters.NotaDTOAdapter;
import com.example.gestaoescolar.adapters.NotaEntityAdapter;
import com.example.gestaoescolar.adapters.ProfessoresDTOAdapter;
import com.example.gestaoescolar.dtos.NotaDTO;
import com.example.gestaoescolar.exceptions.NotasException;
import com.example.gestaoescolar.models.Aulas;
import com.example.gestaoescolar.models.Matriculas;
import com.example.gestaoescolar.models.Notas;
import com.example.gestaoescolar.models.Professores;
import com.example.gestaoescolar.repository.NotasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotaService {

    @Autowired
    private NotasRepository notasRepository;

    public void lancarNotas(NotaDTO notaDTO){
        NotaEntityAdapter notaEntityAdapter = new NotaEntityAdapter(notaDTO);
        Notas nota = notaEntityAdapter.getNota();
        notasRepository.save(nota);
    }

    public NotaDTO mediaEstudante(Long id_matricula) throws NotasException {
        Notas notas = notasRepository.findNotaByMatricula(id_matricula).orElseThrow(NotasException::new);
        NotaDTOAdapter notaDTOAdapter = new NotaDTOAdapter(notas);
        return notaDTOAdapter.getNotaDTO();
    }

    public List<NotaDTO> listNotas(){

        List<Notas> allNotas = notasRepository.findAll();
        NotaDTOAdapter notasDTOAdapter = new NotaDTOAdapter(allNotas);
        return allNotas.stream()
                .map(notasDTOAdapter::toDTO)
                .collect(Collectors.toList());
    }

}
