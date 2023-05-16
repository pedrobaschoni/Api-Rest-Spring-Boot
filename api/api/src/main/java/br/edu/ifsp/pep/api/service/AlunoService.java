package br.edu.ifsp.pep.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifsp.pep.api.model.Aluno;
import br.edu.ifsp.pep.api.repository.AlunoRepository;

@Service
public class AlunoService {

    @Autowired
    AlunoRepository alunoRepository;

    public void inserir(Aluno aluno) {
        alunoRepository.save(aluno);
    }

    public List<Aluno> acharTodos() {
        return alunoRepository.findAll();
    }

    public Optional<Aluno> acharPorMatricula(Integer matricula) {
        return alunoRepository.findByMatricula(matricula);
    }

    public Aluno atualizar(Integer matricula, Aluno novosDados) {
        Optional<Aluno> aluno = acharPorMatricula(matricula);

        if (aluno.isPresent()) {

            Aluno novoAluno = aluno.get();

            novoAluno.setNome(novosDados.getNome());
            novoAluno.setCpf(novosDados.getCpf());

            alunoRepository.save(novoAluno);

            return novoAluno;
        }

        return null;
    }

    public void deletar(Integer matricula) {
        Optional<Aluno> aluno = acharPorMatricula(matricula);

        if (aluno.isPresent()) {
            alunoRepository.delete(aluno.get());
        }

        // aluno.ifPresent(value -> alunoRepository.delete(value));
    }
}
