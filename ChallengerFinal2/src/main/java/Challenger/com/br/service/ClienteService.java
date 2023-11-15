package Challenger.com.br.service;

import Challenger.com.br.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService() {

        this.clienteRepository = null;
    }

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public String obterPlacaDoCliente(String cpf) {
        Cliente cliente = clienteRepository.findByCpf(cpf);
        return cliente != null ? cliente.getPlaca() : null;
    }

    public String obterCarroDoCliente(String cpf) {
        Cliente cliente = clienteRepository.findByCpf(cpf);
        return cliente != null ? cliente.getCarro() : null;
    }
}
