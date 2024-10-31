package br.com.fiap.tc.gerenciamentoclientes_api.infra.config;

import br.com.fiap.tc.gerenciamentoclientes_api.domain.gateway.AtualizarClienteInterface;
import br.com.fiap.tc.gerenciamentoclientes_api.domain.usecase.AtualizarClienteUseCase;
import br.com.fiap.tc.gerenciamentoclientes_api.domain.usecase.BuscarClientePorIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AtualizarClienteConfig {
    @Bean
    public AtualizarClienteUseCase atualizarClienteUseCase(
            AtualizarClienteInterface atualizarClienteInterface,
            BuscarClientePorIdUseCase buscarClientePorIdUseCase
    ){
        return new AtualizarClienteUseCase(atualizarClienteInterface,buscarClientePorIdUseCase);
    }
}
