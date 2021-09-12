package com.example.demo.repository;

import com.example.demo.models.Funcionario;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FuncionarioRepository extends CrudRepository<Funcionario, Long> {
    List<Funcionario> findAll();
}
