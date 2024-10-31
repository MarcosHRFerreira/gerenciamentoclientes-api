package br.com.fiap.tc.gerenciamentoclientes_api.domain.usecase;

import br.com.fiap.tc.gerenciamentoclientes_api.domain.entity.Cliente;
import br.com.fiap.tc.gerenciamentoclientes_api.domain.gateway.CadastrarClienteInterface;

public class CadastrarClienteUseCase {


    private final CadastrarClienteInterface cadastrarClienteInterface;

    public CadastrarClienteUseCase(CadastrarClienteInterface cadastrarClienteInterface) {
        this.cadastrarClienteInterface = cadastrarClienteInterface;
    }

    public Cliente cadastrarCliente(Cliente cliente) {
        return cadastrarClienteInterface.cadastraCliente(cliente);
    }

}
