package br.edu.ifsp.pep.api.model;

import java.io.Serializable;

import br.edu.ifsp.pep.api.dto.AlunoDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Aluno implements Serializable {
    @Id
    @NotNull
    @Min(value = 1)
    private Integer matricula;

    @NotEmpty
    private String nome;
    
    private String cpf;

    private Endereco endereco;

    public Aluno(AlunoDTO aluno){
        this.matricula = aluno.getMatricula();
        this.nome = aluno.getNome();
        this.cpf = aluno.getCpf();
    }
}
