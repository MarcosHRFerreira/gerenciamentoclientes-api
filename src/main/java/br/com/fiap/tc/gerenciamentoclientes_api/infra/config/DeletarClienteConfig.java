package br.com.fiap.tc.gerenciamentoclientes_api.infra.config;

import br.com.fiap.tc.gerenciamentoclientes_api.domain.gateway.DeletarClienteInterface;
import br.com.fiap.tc.gerenciamentoclientes_api.domain.usecase.BuscarClientePorIdUseCase;
import br.com.fiap.tc.gerenciamentoclientes_api.domain.usecase.DeletarClienteUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeletarClienteConfig {

    @Bean
    public DeletarClienteUseCase deletarClienteUseCase(
            DeletarClienteInterface deletarClienteInterface,
            BuscarClientePorIdUseCase buscarClientePorIdUseCase
    ){
        return new DeletarClienteUseCase(deletarClienteInterface,buscarClientePorIdUseCase);
    }

}
