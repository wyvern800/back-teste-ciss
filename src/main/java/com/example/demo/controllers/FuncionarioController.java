package com.example.demo.controllers;

import com.example.demo.models.Funcionario;
import com.example.demo.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:8081/api"})
@RestController
public class FuncionarioController {

    @Autowired
    FuncionarioService funcionarioService;

    /**
     * Representa o mapeamento de {@code GET}
     * @return Lista com todos os funcionários
     */
    @GetMapping()
    @RequestMapping(method = RequestMethod.GET, path = "/funcionarios")
    public List<Funcionario> get() {
        return funcionarioService.listAll();
    }

    /**
     * Representa o mapeamento de {@code POST}
     * @return O funcionário que foi adicionado
     */
    @RequestMapping(value=  "/funcionarios", method = RequestMethod.POST)
    public ResponseEntity<Funcionario> post(@RequestBody Funcionario funcionario) {
        return funcionarioService.create(funcionario);
    }

    /**
     * Representa o mapeamento de {@code PUT}
     * @param id O id a ser editado
     * @param novoFuncionario O novo funcionário presente no corpo da requisição (formato: {@code JSON})
     * @return A resposta | {@code HttpStatus.OK} se o funcionário existe, {@code HttpStatus.NOT_FOUND} se não existe
     */
    @RequestMapping(value = "/funcionarios/{id}", method =  RequestMethod.PUT)
    public ResponseEntity<Funcionario> put(@PathVariable(value = "id") long id, @RequestBody Funcionario novoFuncionario) {
        return funcionarioService.update(id, novoFuncionario);
    }


    /**
     * Representa o mapeamento de {@code DELETE}
     * @param id O id do funcionaro à ser deletado
     * @return A resposta | {@code HttpStatus.OK} se funcionário existe, {@code HttpStatus.NOT_FOUND} se não existe
     */
    @RequestMapping(value = "/characters/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Funcionario> delete(@PathVariable(value = "id") long id) {
        return funcionarioService.delete(id);
    }
}
