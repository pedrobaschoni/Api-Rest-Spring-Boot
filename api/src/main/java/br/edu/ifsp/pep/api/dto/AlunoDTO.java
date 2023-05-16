package br.edu.ifsp.pep.api.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class AlunoDTO {

    @NotNull
    @Min(value = 1)
    private Integer matricula;

    @NotEmpty
    private String nome;
    
    private String cpf;

    private String cep;
}
