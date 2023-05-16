package br.edu.ifsp.pep.api.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Endereco implements Serializable{
    @Id
    private String cep;
    private String state; 
    private String city;
    private String service;
}
