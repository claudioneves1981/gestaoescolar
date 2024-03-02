package com.example.gestaoescolar.controlller;

import com.example.gestaoescolar.dtos.MatriculaDTO;
import com.example.gestaoescolar.dtos.response.MatriculaResponseDTO;
import com.example.gestaoescolar.exceptions.MatriculasException;
import com.example.gestaoescolar.services.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gestaoescolar")
public class MatriculaController {

    @Autowired
    private MatriculaService matriculaService;

    @PostMapping("matricula/novamatricula")
    public void createMatricula(@RequestBody MatriculaDTO matriculaDTO){
        matriculaService.createMatricula(matriculaDTO);
    }

    @GetMapping("matricula/{id}")
        public MatriculaResponseDTO findByMatricula(@PathVariable("id") Long id) throws MatriculasException {
           return matriculaService.findByMatricula(id);
        }


    @GetMapping("matricula/listarmatriculas")
    public List<MatriculaResponseDTO> listMatriculas() {
    return matriculaService.listMatriculas();
    }
}
