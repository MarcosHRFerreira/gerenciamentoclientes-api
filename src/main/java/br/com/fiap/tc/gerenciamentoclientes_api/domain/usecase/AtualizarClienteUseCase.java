package br.com.fiap.tc.gerenciamentoclientes_api.domain.usecase;

import br.com.fiap.tc.gerenciamentoclientes_api.domain.entity.Cliente;
import br.com.fiap.tc.gerenciamentoclientes_api.domain.gateway.AtualizarClienteInterface;

public class AtualizarClienteUseCase {

    private final AtualizarClienteInterface atualizarClienteInterface;
    private final BuscarClientePorIdUseCase buscarClientePorIdUseCase;


    public AtualizarClienteUseCase(AtualizarClienteInterface atualizarClienteInterface, BuscarClientePorIdUseCase buscarClientePorIdUseCase) {
        this.atualizarClienteInterface = atualizarClienteInterface;
        this.buscarClientePorIdUseCase = buscarClientePorIdUseCase;
    }

    public Cliente atualizarCliente(Long id, Cliente cliente){
        Cliente clienteBuscado = buscarClientePorIdUseCase.buscarClientePorId(id);

        clienteBuscado.setNome(cliente.getNome());
        clienteBuscado.setEmail(cliente.getEmail());
        clienteBuscado.setTelefone(cliente.getTelefone());
        clienteBuscado.setLogradouro(cliente.getLogradouro());
        clienteBuscado.setBairro(cliente.getBairro());
        clienteBuscado.setCep(cliente.getCep());
        clienteBuscado.setComplemento(cliente.getComplemento());
        clienteBuscado.setNumero(cliente.getNumero());
        clienteBuscado.setUf(cliente.getNumero());
        clienteBuscado.setCidade(cliente.getCidade());

        return atualizarClienteInterface.atualizarCliente(id,clienteBuscado);

    }


}
