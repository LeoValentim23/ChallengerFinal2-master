package Challenger.com.br.config;

import Challenger.com.br.service.ClienteRepository;
import Challenger.com.br.service.ClienteService;
import Challenger.com.br.service.VerificadorCadastro;
import Challenger.com.br.conexao.ConnectionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public VerificadorCadastro verificadorCadastro(ConnectionManager connectionManager) {
        return new VerificadorCadastro(connectionManager);
    }

    @Bean
    public ClienteService clienteService(ClienteRepository clienteRepository) {
        return new ClienteService(clienteRepository);
    }
}

