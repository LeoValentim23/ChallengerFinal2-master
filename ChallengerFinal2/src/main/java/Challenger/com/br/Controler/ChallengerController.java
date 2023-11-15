package Challenger.com.br.Controler;

import Challenger.com.br.menu.CadastroCliente;
import Challenger.com.br.menu.Chamado;
import Challenger.com.br.menu.Login;
import Challenger.com.br.menu.MenuVeiculo;
import Challenger.com.br.model.RequisicaoChamado;
import Challenger.com.br.model.Cliente;
import Challenger.com.br.service.ClienteService;
import Challenger.com.br.service.VerificadorCadastro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Scanner;

@RestController
@RequestMapping("/api")
public class ChallengerController {

    private final ClienteService clienteService;

    @Autowired
    public ChallengerController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping("/Login")
    public String fazerLogin(@RequestBody Cliente cliente, VerificadorCadastro verificadorCadastro) {
        String cpf = cliente.getCpf();
        String senha = cliente.getSenha();

        return Login.realizarLogin(verificadorCadastro, clienteService, cpf, senha)
                ? "Login bem-sucedido. Bem-vindo!" : "Login falhou. CPF ou senha incorretos.";
    }
    @PostMapping("/Cadastro")
    public String realizarCadastro(@RequestBody Cliente cliente) {
        String nome = cliente.getNome();
        String carro = cliente.getCarro();
        String placa = cliente.getPlaca();
        String pesoVeiculo = cliente.getPesoVeiculo();
        String cpf = cliente.getCpf();
        String senha = cliente.getSenha();

        CadastroCliente.realizarCadastro(nome, carro, placa, pesoVeiculo, cpf, senha);

        return "Cadastro realizado com sucesso!";
    }

    @GetMapping("/MenuVeiculo")
    public String mostrarMenuVeiculo() {
        String cpf = "4222525829";
        return MenuVeiculo.mostrarMenu(clienteService.obterPlacaDoCliente(cpf), clienteService.obterCarroDoCliente(cpf));
    }

    @PostMapping("/Chamado")
    public String realizarChamado(@RequestBody RequisicaoChamado dadosChamado) {
        Scanner scanner = new Scanner(System.in);
        int pesoVeiculo = Integer.parseInt(String.valueOf(dadosChamado.getPesoVeiculo()));
        boolean resultadoChamado = Chamado.realizarChamado();


        scanner.close();

        return resultadoChamado ? "Chamado realizado com sucesso!" : "Erro ao processar o chamado.";
    }
}

