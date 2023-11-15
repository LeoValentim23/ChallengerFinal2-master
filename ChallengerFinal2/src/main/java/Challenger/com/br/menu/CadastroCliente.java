package Challenger.com.br.menu;

import Challenger.com.br.guincho.Guincho;
import Challenger.com.br.model.Cliente;
import Challenger.com.br.conexao.ConnectionManager;
import Challenger.com.br.service.ClienteDAO;

import java.util.Scanner;

public class CadastroCliente {
    public static void realizarCadastro(String nome, String carro, String placa, String pesoVeiculo, String cpf, String senha) {
        System.out.println("Cadastro Cliente");

        ConnectionManager connectionManager = new ConnectionManager();

        Cliente novoCliente = new Cliente(nome, carro, placa, pesoVeiculo, cpf, senha);

        if (ClienteDAO.inserirNoBancoDeDados(novoCliente, connectionManager)) {
            System.out.println("Cadastro realizado com sucesso!");
        } else {
            System.out.println("Erro ao realizar o cadastro.");
        }
    }
}


