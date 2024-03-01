package com.example.gestaoescolar.services;

import com.example.gestaoescolar.adapters.ProfessorEntityAdapter;
import com.example.gestaoescolar.adapters.ProfessoresDTOAdapter;
import com.example.gestaoescolar.dtos.EnderecoDTO;
import com.example.gestaoescolar.dtos.ProfessorDTO;
import com.example.gestaoescolar.exceptions.ProfessorException;
import com.example.gestaoescolar.models.*;
import com.example.gestaoescolar.repository.ProfessoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfessoresService {

    @Autowired
    private ProfessoresRepository professoresRepository;

    @Autowired
    private ViaCepService viaCepService;

    @Autowired
    private PasswordEncoder encoder;

    public void createProfessor(ProfessorDTO professorDTO) {

        EnderecoDTO enderecoDTO = viaCepService.consultarCep(professorDTO.getCep());
        ProfessorEntityAdapter professorEntityAdapter = new ProfessorEntityAdapter(professorDTO, enderecoDTO);
        Professores professor = professorEntityAdapter.getProfessor();
        String pass = professorDTO.getSenha();
        System.out.println(professorDTO);
        List<String> roles = new ArrayList<>();
        roles.add("PROFESSOR");
        Login login = new Login();
        login.setUsuario(professorDTO.getUsuario());
        login.setSenha(encoder.encode(pass));
        login.setRoles(roles);
        professor.setLogin(login);
        System.out.print(professor);
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
