package br.com.fiap.tc.gerenciamentoclientes_api.infra.config;

import br.com.fiap.tc.gerenciamentoclientes_api.domain.gateway.CadastrarClienteInterface;
import br.com.fiap.tc.gerenciamentoclientes_api.domain.usecase.CadastrarClienteUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CadastraClienteConfig {

    @Bean
    public CadastrarClienteUseCase cadastrarClienteUseCase(CadastrarClienteInterface cadastrarClienteInterface) {
        return new CadastrarClienteUseCase(cadastrarClienteInterface);
    }


}
