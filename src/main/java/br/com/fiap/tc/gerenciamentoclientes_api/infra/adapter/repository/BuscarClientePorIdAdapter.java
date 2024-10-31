package br.com.fiap.tc.gerenciamentoclientes_api.infra.adapter.repository;

import br.com.fiap.tc.gerenciamentoclientes_api.domain.entity.Cliente;
import br.com.fiap.tc.gerenciamentoclientes_api.domain.gateway.BuscarClientePorIdInterface;
import br.com.fiap.tc.gerenciamentoclientes_api.infra.repository.mapper.ClienteEntityMapper;
import br.com.fiap.tc.gerenciamentoclientes_api.infra.entity.ClienteEntity;
import br.com.fiap.tc.gerenciamentoclientes_api.infra.repository.ClienteRepository;
import org.springframework.stereotype.Component;

@Component
public class BuscarClientePorIdAdapter implements BuscarClientePorIdInterface {
    private final ClienteRepository clienteRepository;
    private final ClienteEntityMapper clienteEntityMapper;

    public BuscarClientePorIdAdapter(ClienteRepository clienteRepository, ClienteEntityMapper clienteEntityMapper) {
        this.clienteRepository = clienteRepository;
        this.clienteEntityMapper = clienteEntityMapper;
    }

    @Override
    public Cliente buscarClientePorId(Long id){
        ClienteEntity clienteBuscado = clienteRepository.findById(id).orElse(null);

       return clienteEntityMapper.toClienteResponse(clienteBuscado);
    }

}
