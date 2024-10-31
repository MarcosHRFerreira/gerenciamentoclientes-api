package br.com.fiap.tc.gerenciamentoclientes_api.infra.adapter.repository;

import br.com.fiap.tc.gerenciamentoclientes_api.domain.entity.Cliente;
import br.com.fiap.tc.gerenciamentoclientes_api.domain.entity.validation.ValidationCliente;
import br.com.fiap.tc.gerenciamentoclientes_api.domain.gateway.CadastrarClienteInterface;
import br.com.fiap.tc.gerenciamentoclientes_api.infra.repository.mapper.ClienteEntityMapper;
import br.com.fiap.tc.gerenciamentoclientes_api.infra.entity.ClienteEntity;
import br.com.fiap.tc.gerenciamentoclientes_api.infra.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CadastrarClienteAdapter implements CadastrarClienteInterface {

    private final ClienteRepository clienteRepository;
    private final ClienteEntityMapper clienteEntityMapper;

    @Override
    public Cliente cadastraCliente(Cliente cliente){

        ValidationCliente validator = new ValidationCliente(cliente);

        validator.validar();

        ClienteEntity clienteEntity=clienteEntityMapper.toEntity(cliente);
        ClienteEntity novoCliente =  clienteRepository.save(clienteEntity);
        return clienteEntityMapper.toClienteResponse(novoCliente);

    }



}
