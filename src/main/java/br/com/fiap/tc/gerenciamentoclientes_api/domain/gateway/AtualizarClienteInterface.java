package br.com.fiap.tc.gerenciamentoclientes_api.domain.gateway;

import br.com.fiap.tc.gerenciamentoclientes_api.domain.entity.Cliente;

public interface AtualizarClienteInterface {

    Cliente atualizarCliente(Long id, Cliente cliente);

}
