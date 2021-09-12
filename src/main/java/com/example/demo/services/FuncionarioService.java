package com.example.demo.services;

import com.example.demo.models.Funcionario;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.demo.repository.FuncionarioRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class FuncionarioService {

    @Autowired
    FuncionarioRepository funcionarioRepository;

    /**
     * Pega lista de todos os funcionários
     * @return A lista dos funcionários
     */
    public List<Funcionario> listAll() {
        return funcionarioRepository.findAll();
    }

    /**
     * Cria um funcionário
     * @param funcionario O funcionário que estamos criando
     * @return O objeto do funcionário e {@code HttpStatus.CREATED} como resposta
     */
    public ResponseEntity<Funcionario> create(Funcionario funcionario) {
        // Se o funcionário já existir
        if (entryExists(funcionario.getNome())) {
            log.info("Já existe um funcionário com o nome '"+funcionario.getNome()+"' já existe!");
            return new ResponseEntity<>(HttpStatus.IM_USED);
        }
        funcionarioRepository.save(funcionario);
        log.info("Funcionário "+funcionario.getNome()+" foi cadastrado com sucesso!");
        return new ResponseEntity<>(funcionario, HttpStatus.CREATED);
    }

    /**
     * Atualiza o funcionário
     * @param funcionarioId O funcionário a ser atualizado
     * @return {@code HttpStatus.OK} se funcionario foi atualizado | {@code HttpStatus.NOT_FOUND} se não
     */
    public ResponseEntity<Funcionario> update(long funcionarioId, Funcionario reqBodyFuncionario) {
        Optional<Funcionario> optFuncionario = funcionarioRepository.findById(funcionarioId);

        if (optFuncionario.isPresent()) {
            Funcionario funcionarioAntigo = optFuncionario.get();

            funcionarioAntigo.setNome(reqBodyFuncionario.getNome());
            funcionarioAntigo.setSobrenome(reqBodyFuncionario.getSobrenome());
            funcionarioAntigo.setEmail(reqBodyFuncionario.getEmail());
            funcionarioAntigo.setPis(reqBodyFuncionario.getPis());

            funcionarioRepository.save(funcionarioAntigo);
            log.info("Funcionário "+optFuncionario.get().getNome()+" foi atualizado com sucesso!");
            return new ResponseEntity<>(reqBodyFuncionario, HttpStatus.OK);
        } else {
            log.warn("Funcionário não foi encontrado!");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Checa se algum funcionário já existe
     * @param nome Nome do funcionário
     * @return {@code True} se existe | {@code False} se não existe
     */
    private boolean entryExists(String nome) {
        List<Funcionario> todosFuncionarios = funcionarioRepository.findAll();
        Optional<Funcionario> optFuncionario = todosFuncionarios.stream().filter(funcionario -> funcionario.getNome().equalsIgnoreCase(nome)).findFirst();
        return optFuncionario.isPresent();
    }

    /**
     * Deleta o funcionario específico
     * @param funcionarioId O id do funcionario a ser deletado
     */
    public ResponseEntity<Funcionario> delete(long funcionarioId) {
        Optional<Funcionario> optFuncionario = funcionarioRepository.findById(funcionarioId);
        if(optFuncionario.isPresent()){
            funcionarioRepository.delete(optFuncionario.get());
            log.info("Funcionário "+optFuncionario.get().getNome()+" foi removido com sucesso!");
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            log.warn("Funcionário não encontrado!");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Retorna o funcionario com o id apresentado
     * @param id Id do funcionario
     * @return  {@code HttpStatus.OK} se o funcionario foi encontrado | {@code HttpStatus.NOT_FOUND} se não foi
     */
    public ResponseEntity<Funcionario> getFuncionarioById(long id) {
        Optional<Funcionario> optFuncionario = funcionarioRepository.findById(id);
        return optFuncionario.map(funcionario -> new ResponseEntity<>(funcionario, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}