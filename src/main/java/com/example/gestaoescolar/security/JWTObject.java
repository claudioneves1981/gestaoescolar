package com.example.gestaoescolar.security;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class JWTObject {
    private String subject;
    private Date issuedAt;
    private Date expiration;
    private List<String> roles;

}