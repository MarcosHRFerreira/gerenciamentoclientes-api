package br.com.fiap.tc.gerenciamentoclientes_api.infra.adapter.repository;

import br.com.fiap.tc.gerenciamentoclientes_api.domain.entity.Cliente;
import br.com.fiap.tc.gerenciamentoclientes_api.domain.gateway.AtualizarClienteInterface;
import br.com.fiap.tc.gerenciamentoclientes_api.infra.repository.mapper.ClienteEntityMapper;
import br.com.fiap.tc.gerenciamentoclientes_api.infra.entity.ClienteEntity;
import br.com.fiap.tc.gerenciamentoclientes_api.infra.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AtualizarClienteAdapter implements AtualizarClienteInterface {

    private final ClienteRepository clienteRepository;
    private final ClienteEntityMapper clienteEntityMapper;
    private final BuscarClientePorIdAdapter buscarClientePorIdAdapter;

    @Override
    public Cliente atualizarCliente(Long id, Cliente cliente){
        ClienteEntity clienteAtualizado= clienteRepository.save(clienteEntityMapper.toEntity(cliente));

        return clienteEntityMapper.toClienteResponse(clienteAtualizado);

    }
}
