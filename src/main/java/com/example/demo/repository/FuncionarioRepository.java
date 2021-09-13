package com.example.demo.repository;

import com.example.demo.models.Funcionario;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface FuncionarioRepository extends CrudRepository<Funcionario, String> {
    List<Funcionario> findAll();

    Optional<Funcionario> findById(String id);
}
