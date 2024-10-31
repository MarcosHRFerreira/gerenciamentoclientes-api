package br.com.fiap.tc.gerenciamentoclientes_api.infra.adapter.repository;


import br.com.fiap.tc.gerenciamentoclientes_api.domain.entity.Cliente;
import br.com.fiap.tc.gerenciamentoclientes_api.domain.gateway.ListarClienteInterface;
import br.com.fiap.tc.gerenciamentoclientes_api.domain.mapper.ClienteDtoMapper;
import br.com.fiap.tc.gerenciamentoclientes_api.domain.output.ClienteDeletadoResponse;
import br.com.fiap.tc.gerenciamentoclientes_api.infra.repository.ClienteRepository;
import br.com.fiap.tc.gerenciamentoclientes_api.infra.repository.mapper.ClienteEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ListarClienteAdapter implements ListarClienteInterface {

    private final ClienteRepository clienteRepository;
    private final ClienteEntityMapper clienteEntityMapper;


    @Override
    public List<Cliente> listarClientes(){
        return clienteRepository.findAll().stream().map(clienteEntityMapper::toClienteResponse).toList();
    }

}
