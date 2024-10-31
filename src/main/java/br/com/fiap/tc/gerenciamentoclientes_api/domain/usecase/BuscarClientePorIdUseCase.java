package br.com.fiap.tc.gerenciamentoclientes_api.domain.usecase;

import br.com.fiap.tc.gerenciamentoclientes_api.domain.entity.Cliente;
import br.com.fiap.tc.gerenciamentoclientes_api.domain.exception.ClienteNotFoundException;
import br.com.fiap.tc.gerenciamentoclientes_api.domain.gateway.BuscarClientePorIdInterface;

public class BuscarClientePorIdUseCase {

    private final BuscarClientePorIdInterface buscarClientePorIdInterface;

    public BuscarClientePorIdUseCase(BuscarClientePorIdInterface buscarClientePorIdInterface) {
        this.buscarClientePorIdInterface = buscarClientePorIdInterface;
    }

    public Cliente buscarClientePorId(Long id){

        Cliente cliente = buscarClientePorIdInterface.buscarClientePorId(id);

        if (cliente == null) {
            throw new ClienteNotFoundException("Cliente de id: " + id + " não encontrado.");
        }

        return cliente;
    }

}
