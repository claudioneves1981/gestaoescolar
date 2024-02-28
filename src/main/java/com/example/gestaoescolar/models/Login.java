package com.example.gestaoescolar.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "tb_login")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_USUARIO")
    private Long id_usuario;

    private String usuario;

    private String senha;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "tb_user_roles", joinColumns = @JoinColumn(name= "usuario_id"))
    @Column(name = "role_id")
    private List<String> roles = new ArrayList<>();

}
