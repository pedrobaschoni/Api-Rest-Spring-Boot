package br.edu.ifsp.pep.api.controller;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifsp.pep.api.dto.AlunoDTO;
import br.edu.ifsp.pep.api.httpClient.CepHttpCliente;
import br.edu.ifsp.pep.api.model.Aluno;
import br.edu.ifsp.pep.api.model.Endereco;
import br.edu.ifsp.pep.api.service.AlunoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class AlunoController {

    @Autowired
    CepHttpCliente cepHttpCliente;

    @Autowired
    AlunoService alunoService;

    @PostMapping("/inserir")
    public ResponseEntity<Aluno> inserir(@RequestBody @Valid AlunoDTO alunoDTO) {
        Aluno aluno = new Aluno(alunoDTO);

        Endereco endereco = cepHttpCliente.obterEnderecoPeloCep(alunoDTO.getCep());

        aluno.setEndereco(endereco);

        alunoService.inserir(aluno);
        return ResponseEntity.created(null).body(aluno);
    }
    
    @GetMapping("/achar/todos")
    public List<Aluno> acharPorMatricula() {
        List<Aluno> alunos = alunoService.acharTodos();

        if (alunos == null) {
            return null;
        }

        return alunos;
    }

    @GetMapping("/achar/{matricula}")
    public ResponseEntity<Aluno> acharPorMatricula(@PathVariable Integer matricula) {
        Optional<Aluno> aluno = alunoService.acharPorMatricula(matricula);

        if (aluno.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(aluno.get());
    }

    @PutMapping("/atualizar/{matricula}")
    public ResponseEntity<Aluno> atualizar(@RequestBody Aluno novosDados, @PathVariable Integer matricula) {
        Optional<Aluno> aluno = alunoService.acharPorMatricula(matricula);

        if(aluno.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        Aluno alunoResponse = alunoService.atualizar(matricula, novosDados);

        return ResponseEntity.ok().body(alunoResponse);
    }

    @PatchMapping("/atualizar/{matricula}")
    public ResponseEntity<Aluno> atualizarCPF(@RequestParam("cpf") String cpf, @PathVariable Integer matricula) {
        Optional<Aluno> alunoOptional = alunoService.acharPorMatricula(matricula);

        if (alunoOptional == null) {
            return ResponseEntity.notFound().build();
        }

        Aluno aluno = alunoOptional.get();

        aluno.setCpf(cpf);

        alunoService.atualizar(matricula, aluno);

        return ResponseEntity.ok().body(aluno);
    }

    @DeleteMapping("/deletar/{matricula}")
    public ResponseEntity<Aluno> deletar(@PathVariable Integer matricula) {
        Optional<Aluno> aluno = alunoService.acharPorMatricula(matricula);

        if (aluno.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        alunoService.deletar(matricula);

        return ResponseEntity.ok().body(null);
    }
}
