package br.edu.ifsp.pep.api.httpClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.ifsp.pep.api.model.Endereco;

@FeignClient(value = "cep-cliente", url = "https://brasilapi.com.br/api")
public interface CepHttpCliente {
    
    @GetMapping("/cep/v1/{cep}")
    public Endereco obterEnderecoPeloCep(@PathVariable("cep") String cep);
}
