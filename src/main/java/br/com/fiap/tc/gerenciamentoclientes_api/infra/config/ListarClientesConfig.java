package br.com.fiap.tc.gerenciamentoclientes_api.infra.config;

import br.com.fiap.tc.gerenciamentoclientes_api.domain.gateway.ListarClienteInterface;
import br.com.fiap.tc.gerenciamentoclientes_api.domain.usecase.ListarClientesUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ListarClientesConfig {

    @Bean
    public ListarClientesUseCase listarClientesUseCase(
            ListarClienteInterface listarClienteInterface){
        return  new ListarClientesUseCase((listarClienteInterface));
    }

}
