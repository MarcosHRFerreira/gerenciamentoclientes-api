package br.com.fiap.tc.gerenciamentoclientes_api.controller;


import br.com.fiap.tc.gerenciamentoclientes_api.application.controller.DeletarClienteController;
import br.com.fiap.tc.gerenciamentoclientes_api.domain.usecase.DeletarClienteUseCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(DeletarClienteController.class)
public class DeletarClienteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DeletarClienteUseCase deletarClienteUseCase;

    private static final Long CLIENTE_ID = 1L;

    @Test
    @DisplayName("Deve deletar um cliente com sucesso")
    public void deveDeletarClienteComSucesso() throws Exception {
        // Cenário
        Mockito.when(deletarClienteUseCase.deletarCliente(CLIENTE_ID)).thenReturn(true);

        RequestBuilder request = MockMvcRequestBuilders
                .delete("/clientes/" + CLIENTE_ID)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);

        // Execução e Verificação
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andReturn();
    }
}