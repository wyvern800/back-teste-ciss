package com.example.demo.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "funcionario")
@Data
@NoArgsConstructor
public class Funcionario implements Serializable {
    private static final long SerialVersionUID=1L;

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name = "UUID_ID", updatable = false, unique = true, nullable = false)
    private String id;

    @Size(min=2, max= 30, message
            = "Nome deve ter entre 2 a 30 caracteres")
    @NotNull(message = "Nome não pode ser nulo")
    @Column(nullable = false)
    private String nome;

    @Size(min=2, max= 40, message
            = "Nome deve ter entre 2 a 40 caracteres")
    @NotNull(message = "Sobrenome não pode ser nulo")
    @Column(nullable = false)
    private String sobrenome;

    @Email(message = "Email deve ser válido")
    @Column(unique = true, nullable = false)
    private String email;

    @NotNull(message = "Pis deve ser válido")
    @Column(unique = true, nullable = false)
    private Integer pis;

    public Funcionario(String nome, String sobrenome, String email, Integer pis) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.pis = pis;
    }
}
