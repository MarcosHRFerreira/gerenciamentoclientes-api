package br.com.fiap.tc.gerenciamentoclientes_api.infra.repository.mapper;

import br.com.fiap.tc.gerenciamentoclientes_api.domain.entity.Cliente;
import br.com.fiap.tc.gerenciamentoclientes_api.infra.entity.ClienteEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ClienteEntityMapper {


    ClienteEntityMapper INSTANCE = Mappers.getMapper(ClienteEntityMapper.class);

    /**
     * @param clienteEntity
     * @return
     */
    Cliente toClienteResponse(ClienteEntity clienteEntity);


    /**
     * @param cliente
     * @return
     */
    ClienteEntity toEntity(Cliente cliente);

}
