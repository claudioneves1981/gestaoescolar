package com.example.gestaoescolar.controlller;

import com.example.gestaoescolar.dtos.ProfessorDTO;
import com.example.gestaoescolar.exceptions.ProfessorException;
import com.example.gestaoescolar.services.ProfessoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/gestaoescolar")
public class ProfessorController {

    @Autowired
    private ProfessoresService professoresService;

    @PostMapping("/professor/cadastrarprofessor")
    public void createProfessor(ProfessorDTO professorDTO) {
        professoresService.createProfessor(professorDTO);
    }

    @GetMapping("/professor/{id}")
    public ProfessorDTO findByProfessor(Long id) throws ProfessorException {
        return professoresService.findByProfessor(id);
    }

    @GetMapping("/professor/listarprofessores")
    public List<ProfessorDTO> listProfessores(){
        return professoresService.listProfessores();
    }
}
