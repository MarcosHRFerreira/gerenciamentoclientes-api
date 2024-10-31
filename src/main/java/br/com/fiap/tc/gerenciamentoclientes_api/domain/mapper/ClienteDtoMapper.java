package br.com.fiap.tc.gerenciamentoclientes_api.domain.mapper;

import br.com.fiap.tc.gerenciamentoclientes_api.domain.input.AtualizarClienteRequest;
import br.com.fiap.tc.gerenciamentoclientes_api.domain.input.CadastrarClienteRequest;
import br.com.fiap.tc.gerenciamentoclientes_api.domain.entity.Cliente;
import br.com.fiap.tc.gerenciamentoclientes_api.domain.output.ClienteResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

//@Component
@Mapper(componentModel = "spring")
public interface ClienteDtoMapper {

    /**
     * @param cadastrarClienteRequest
     * @return
     */
    @Mapping(target = "clienteId", ignore = true)
    Cliente toCliente(CadastrarClienteRequest cadastrarClienteRequest);

    /**
     * @param atualizarClienteRequest
     * @return
     */
    @Mapping(target = "clienteId", ignore = true)
    Cliente toCliente(AtualizarClienteRequest atualizarClienteRequest);

    /**
     * @param cliente
     * @return
     */
    ClienteResponse toClienteResponse(Cliente cliente);








}
