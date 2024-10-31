package br.com.fiap.tc.gerenciamentoclientes_api.domain.gateway;

import br.com.fiap.tc.gerenciamentoclientes_api.domain.entity.Cliente;

public interface BuscarClientePorIdInterface {
    Cliente buscarClientePorId(Long id);
}
