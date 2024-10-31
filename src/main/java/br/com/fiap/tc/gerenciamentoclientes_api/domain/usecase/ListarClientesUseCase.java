package br.com.fiap.tc.gerenciamentoclientes_api.domain.usecase;

import br.com.fiap.tc.gerenciamentoclientes_api.domain.entity.Cliente;
import br.com.fiap.tc.gerenciamentoclientes_api.domain.gateway.ListarClienteInterface;

import java.util.List;

public class ListarClientesUseCase {
    private final ListarClienteInterface listarClienteInterface;

    public ListarClientesUseCase(ListarClienteInterface listarClienteInterface) {
        this.listarClienteInterface = listarClienteInterface;
    }

    public List<Cliente> listarClientes(){
        return listarClienteInterface.listarClientes();
    }

}
