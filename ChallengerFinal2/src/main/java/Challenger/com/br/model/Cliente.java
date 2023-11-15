package Challenger.com.br.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cliente {
    private String nome;
    private String carro;
    private String placa;
    private String pesoVeiculo;
    private String cpf;
    private String senha;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Cliente(String nome, String carro, String placa, String pesoVeiculo, String cpf, String senha) {
        this.nome = nome;
        this.carro = carro;
        this.placa = placa;
        this.pesoVeiculo = pesoVeiculo;
        this.cpf = cpf;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public String getCarro() {
        return carro;
    }

    public String getPlaca() {
        return placa;
    }

    public String getPesoVeiculo() {
        return pesoVeiculo;
    }

    public String getCpf() {
        return cpf;
    }

    public String getSenha() {
        return senha;
    }

    public Long getId() {
        return id;
    }
}
