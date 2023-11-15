package Challenger.com.br.ChallengerFinal;

import Challenger.com.br.config.AppConfig;
import Challenger.com.br.menu.Menu;
import Challenger.com.br.service.VerificadorCadastro;
import Challenger.com.br.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "Challenger.com.br")
@EnableJpaRepositories(basePackages = "Challenger.com.br.service")
@EntityScan(basePackages = "Challenger.com.br.model")
@Import(AppConfig.class)
public class ChallengerFinalApplication implements CommandLineRunner {

	private final VerificadorCadastro verificadorCadastro;
	private final ClienteService clienteService;

	@Autowired
	public ChallengerFinalApplication(VerificadorCadastro verificadorCadastro, ClienteService clienteService) {
		this.verificadorCadastro = verificadorCadastro;
		this.clienteService = clienteService;
	}

	public static void main(String[] args) {
		SpringApplication.run(ChallengerFinalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String nome = "Nome do Cliente";
		String carro = "FH 400 6x2 2p (diesel";
		String placa = "XYZ1234";
		String pesoVeiculo = "100";
		String senha = "111" ;
		String cpf = "4222525829" ;

		Menu.mostrarMenuPrincipal(verificadorCadastro, clienteService, nome, carro, placa, pesoVeiculo , senha , cpf);
	}
}
