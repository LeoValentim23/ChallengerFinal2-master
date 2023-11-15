package Challenger.com.br.menu;

import Challenger.com.br.service.ClienteService;
import Challenger.com.br.service.VerificadorCadastro;

public class Login {
    public static boolean realizarLogin(VerificadorCadastro verificadorCadastro, ClienteService clienteService, String cpf, String senha) {
        System.out.println("Login");


        if (verificadorCadastro.verificarCadastro(cpf, senha)) {
            System.out.println("Login bem-sucedido. Bem-vindo!");

            String placa = clienteService.obterPlacaDoCliente(cpf);
            String carro = clienteService.obterCarroDoCliente(cpf);

            MenuVeiculo.mostrarMenu(placa, carro);

            return true;
        } else {
            System.out.println("Login falhou. CPF ou senha incorretos.");
            return false;
        }
    }
}






