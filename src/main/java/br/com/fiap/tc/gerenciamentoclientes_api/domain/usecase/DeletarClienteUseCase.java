package br.com.fiap.tc.gerenciamentoclientes_api.domain.usecase;

import br.com.fiap.tc.gerenciamentoclientes_api.domain.gateway.DeletarClienteInterface;

public class DeletarClienteUseCase {

    private final DeletarClienteInterface deletarClienteInterface;
    private final BuscarClientePorIdUseCase buscarClientePorIdUseCase;


    public DeletarClienteUseCase(DeletarClienteInterface deletarClienteInterface, BuscarClientePorIdUseCase buscarClientePorIdUseCase) {
        this.deletarClienteInterface = deletarClienteInterface;
        this.buscarClientePorIdUseCase = buscarClientePorIdUseCase;
    }

    public boolean deletarCliente(Long id){

        buscarClientePorIdUseCase.buscarClientePorId(id);

        return deletarClienteInterface.deletarUsuario(id);

    }


}
