package br.com.fiap.tc.gerenciamentoclientes_api.infra.config;

import br.com.fiap.tc.gerenciamentoclientes_api.domain.gateway.BuscarClientePorIdInterface;
import br.com.fiap.tc.gerenciamentoclientes_api.domain.usecase.BuscarClientePorIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BuscarClientePorIdConfig {
    @Bean
    public BuscarClientePorIdUseCase buscarClientePorIdUseCase(BuscarClientePorIdInterface buscarClientePorIdInterface){
        return new BuscarClientePorIdUseCase(buscarClientePorIdInterface);
    }
}
