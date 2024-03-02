#Gestao Escolar

### Tecnologias usadas
- Java 17
- Maven
- Lombok
- JPA
- Spring Boot
- Spring Security
- Spring Cloud(Open Feign)
- Postgres

POST
Professor/ Cadastrar Professor
http://localhost:8080/gestaoescolar/professor/cadastrarprofessor
﻿

Body
```
{
"nome":"Cláudio",
"email":"cfneguacu@hotmail.com",
"genero":"masculino",
"identidade":"305965827",
"nascimento": "1981-09-15",
"nacionalidade":"brasileira",
"naturalidade":"são paulo",
"nivel_academico":"Bacharel",
"area_formacao":"Matematica",
"cep":"04755050",
"numero":"215",
"complemento":"Bloco 1 ap 408",
"telefone":"2615-0932",
"usuario": "claudio1981",
"senha":"teste"
}
```

POST
Login
http://localhost:8080/login
﻿

Authorization
Bearer Token

Body
```
{
"usuario":"claudio1982",
"senha": "teste2"
}
```
POST
Aula /Nova Aula
http://localhost:8080/gestaoescolar/aula/novaaula
﻿

Request Headers
Authorization
eyJhbGciOiJIUzUxMiJ9.eyJpYXQiOjE3MDkzMjc2NDksImV4cCI6MTcwOTMzMTI0OSwiYXV0aG9yaXRpZXMiOlsiUk9MRV9QUk9GRVNTT1IiXX0.Kcuo3O63vSQJtwJnfDCjh_HEHjWG60zqXPML9qLS8nOi00QLI2AhXniZBQhyVfIPfHjQv7d7tre2if6xjXjQZQ
Body
```
{
"professor":"Claudio",
"curso":"Tecnologia da Informação",
"classe":"segundo ano do ensino medio",
"turma":"2",
"disciplina":"Matematica",
"periodo" : "noturno"
}
```

GET
Professor / Listar Professores
http://localhost:8080/gestaoescolar/professor/listarprofessores
﻿

GET
Professor / Consulta por id
http://localhost:8080/gestaoescolar/professor/1
﻿

POST
Matricula / Nova Matricula
http://localhost:8080/gestaoescolar/matricula/novamatricula
﻿

Body
```
{
"nome":"Pedro",
"identidade":"1235456698",
"email":"cfneguacu@hootmail.com",
"nascimento":"1981-09-20",
"nacionalidade":"Brasileira",
"naturalidade": "São Paulo",
"genero":"Masculino",
"nome_mae": "Josefa",
"nome_pai":"Joao",
"telefone_mae": "66666666",
"telefone_pai":"999999999",
"trabalho_mae":"Empregada Domestica",
"trabalho_pai":"Engenheiro",
"cep":"04755050",
"numero":"54",
"complemento":"Casa Fundos",
"ano":2024,
"curso":"Tecnologia da Informação",
"classe": "primeiro ano do ensino medio",
"turma":"1",
"periodo": "Diurno",
"usuario" : "pedrinho",
"senha":"pedrinho",
"data_matricula":"2024-03-01"
}
```

GET
Matricula / Consulta por id
http://localhost:8080/gestaoescolar/matricula/1
﻿

Request Headers
Authorization
eyJhbGciOiJIUzUxMiJ9.eyJpYXQiOjE3MDkzMzAzNDQsImV4cCI6MTcwOTMzMzk0NCwiYXV0aG9yaXRpZXMiOlsiUk9MRV9FU1RVREFOVEUiLCJST0xFX1BST0ZFU1NPUiJdfQ.6iRayb8E7B2lIzL83BNPaaDi1myVko6uNv11k_-SoWjTxej-adXM_DgBIkuJyCdpp0g-K2ArzrqCPmOumHkU_A

GET
Matricula / Lista de Matriculas
http://localhost:8080/gestaoescolar/matricula/listarmatriculas
﻿

Request Headers
Authorization
eyJhbGciOiJIUzUxMiJ9.eyJpYXQiOjE3MDkzMzI0ODUsImV4cCI6MTcwOTMzNjA4NSwiYXV0aG9yaXRpZXMiOlsiUk9MRV9QUk9GRVNTT1IiXX0.GsgIyNnPStAsS4dh_Su4JZ0W70UaMi3gD8LnokhpEaVs3FKZGb9d_8FsZw0gxVW6rEpde9cP8V75IDfdm2G6Xg

POST
Notas / Lançar Notas
http://localhost:8080/gestaoescolar/notas/lancarnota
﻿

Request Headers
Authorization
eyJhbGciOiJIUzUxMiJ9.eyJpYXQiOjE3MDkzMzI0ODUsImV4cCI6MTcwOTMzNjA4NSwiYXV0aG9yaXRpZXMiOlsiUk9MRV9QUk9GRVNTT1IiXX0.GsgIyNnPStAsS4dh_Su4JZ0W70UaMi3gD8LnokhpEaVs3FKZGb9d_8FsZw0gxVW6rEpde9cP8V75IDfdm2G6Xg


Body

```
{
"id_matricula": 1,
"id_aula":1,
"nota1":9.0,
"nota2":10.0,
"nota3":9.0
}
```

GET
Notas / Notas por id
http://localhost:8080/gestaoescolar/notas/1
﻿

Request Headers
Authorization
eyJhbGciOiJIUzUxMiJ9.eyJpYXQiOjE3MDkzMzI3NjYsImV4cCI6MTcwOTMzNjM2NiwiYXV0aG9yaXRpZXMiOlsiUk9MRV9QUk9GRVNTT1IiXX0.cNVOgFvYFa7gDVm-3ctpRxXgGY31MO_jLGCrG-agSnv9SYON0v5FLNjGTAF9lC7iphHlTyRtfjk6nJvTRgoM2w

GET
Notas / Listar Notas
http://localhost:8080/gestaoescolar/notas/listarnotas
﻿

Request Headers
Authorization
eyJhbGciOiJIUzUxMiJ9.eyJpYXQiOjE3MDkzMzI3NjYsImV4cCI6MTcwOTMzNjM2NiwiYXV0aG9yaXRpZXMiOlsiUk9MRV9QUk9GRVNTT1IiXX0.cNVOgFvYFa7gDVm-3ctpRxXgGY31MO_jLGCrG-agSnv9SYON0v5FLNjGTAF9lC7iphHlTyRtfjk6nJvTRgoM2w