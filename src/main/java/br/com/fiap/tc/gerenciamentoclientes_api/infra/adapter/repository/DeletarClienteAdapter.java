package br.com.fiap.tc.gerenciamentoclientes_api.infra.adapter.repository;

import br.com.fiap.tc.gerenciamentoclientes_api.domain.gateway.DeletarClienteInterface;
import br.com.fiap.tc.gerenciamentoclientes_api.infra.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeletarClienteAdapter implements DeletarClienteInterface {

    private final ClienteRepository clienteRepository;

    @Override
    public boolean deletarUsuario(Long id){
        clienteRepository.deleteById(id);
        return  true;
    }

}
