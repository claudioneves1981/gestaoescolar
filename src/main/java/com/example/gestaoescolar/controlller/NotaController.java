package com.example.gestaoescolar.controlller;

import com.example.gestaoescolar.dtos.NotaDTO;
import com.example.gestaoescolar.dtos.response.NotaResponseDTO;
import com.example.gestaoescolar.exceptions.NotasException;
import com.example.gestaoescolar.services.NotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gestaoescolar")
public class NotaController {

    @Autowired
    private NotaService notaService;

    @PostMapping("notas/lancarnota")
    public void lancarNotas(@RequestBody NotaDTO notaDTO){
        notaService.lancarNotas(notaDTO);
    }

    @GetMapping("notas/{id}")
    public NotaResponseDTO mediaEstudante(@PathVariable("id") Long id) throws NotasException {
        return notaService.mediaEstudante(id);
    }

    @GetMapping("notas/listarnotas")
    public List<NotaResponseDTO> listNotas(){
        return notaService.listNotas();
    }
}
