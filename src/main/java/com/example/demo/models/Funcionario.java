package com.example.demo.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "funcionario")
@Data
@NoArgsConstructor
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min=2, max= 30, message
            = "Nome deve ter entre 2 a 30 caracteres")
    @NotNull(message = "Nome não pode ser nulo")
    private String nome;

    @Size(min=2, max= 40, message
            = "Nome deve ter entre 2 a 40 caracteres")
    @NotNull(message = "Sobrenome não pode ser nulo")
    private String sobrenome;

    @Email(message = "Email deve ser válido")
    private String email;

    @NotNull(message = "Pis deve ser válido")
    private Integer pis;

    public Funcionario(String nome, String sobrenome, String email, Integer pis) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.pis = pis;
    }
}
