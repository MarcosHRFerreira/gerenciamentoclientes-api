package br.com.fiap.tc.gerenciamentoclientes_api.domain.gateway;

import br.com.fiap.tc.gerenciamentoclientes_api.domain.entity.Cliente;

import java.util.List;

public interface ListarClienteInterface {
    List<Cliente> listarClientes();
}
