package com.example.gestaoescolar.controlller;

import com.example.gestaoescolar.dtos.AulasDTO;
import com.example.gestaoescolar.models.Aulas;
import com.example.gestaoescolar.services.AulasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gestaoescolar")
public class AulaController {

    @Autowired
    private AulasService aulasService;

    @PostMapping("/aula/novaaula")
    public void createAula(@RequestBody AulasDTO aulasDTO){
        aulasService.createAula(aulasDTO);
    }

    @DeleteMapping("aula/{disciplina}")
    public void deleteAula(@PathVariable("disciplina") String disciplina){
        aulasService.deleteAula(disciplina);
    }




}
