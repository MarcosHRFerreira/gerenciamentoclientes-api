package br.com.fiap.tc.gerenciamentoclientes_api.controller;

import br.com.fiap.tc.gerenciamentoclientes_api.application.controller.BuscarClienteController;
import br.com.fiap.tc.gerenciamentoclientes_api.domain.entity.Cliente;
import br.com.fiap.tc.gerenciamentoclientes_api.domain.exception.ClienteNotFoundException;
import br.com.fiap.tc.gerenciamentoclientes_api.domain.mapper.ClienteDtoMapper;
import br.com.fiap.tc.gerenciamentoclientes_api.domain.output.ClienteResponse;
import br.com.fiap.tc.gerenciamentoclientes_api.domain.usecase.BuscarClientePorIdUseCase;
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

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(BuscarClienteController.class)
public class BuscarClienteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BuscarClientePorIdUseCase buscarClientePorIdUseCase;

    @MockBean
    private ClienteDtoMapper clienteDtoMapper;

    private static final Long CLIENTE_ID = Long.valueOf("1") ;

    @Test
    @DisplayName("Deve retornar um cliente com sucesso")
    public void deveRetornarClienteComSucesso() throws Exception {
        // Cenário
        Cliente clienteMock = new Cliente(
                        CLIENTE_ID,
                        "João Silva",
                        "joao.silva@example.com",
                        "11987654321",
                        "Rua das Flores",
                        "Centro",
                        "12345-678",
                        "Apto 101",
                        "100",
                        "SP",
                        "São Paulo"
                );
        ClienteResponse clienteResponseMock = new ClienteResponse(
                CLIENTE_ID,
                "João Silva",
                "joao.silva@example.com",
                "11987654321",
                "Rua das Flores",
                "Centro",
                "12345-678",
                "Apto 101",
                "100",
                "SP",
                "São Paulo"
        );

        Mockito.when(buscarClientePorIdUseCase.buscarClientePorId(CLIENTE_ID)).thenReturn(clienteMock);
        Mockito.when(clienteDtoMapper.toClienteResponse(clienteMock)).thenReturn(clienteResponseMock);

        RequestBuilder request = MockMvcRequestBuilders.get("/clientes/" + CLIENTE_ID)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);

        // Execução e Verificação
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    @DisplayName("Deve retornar 404 quando o cliente não for encontrado")
    public void deveRetornar404QuandoClienteNaoForEncontrado() throws Exception {
        // Cenário
        Mockito.when(buscarClientePorIdUseCase.buscarClientePorId(CLIENTE_ID))
                .thenThrow(new ClienteNotFoundException("Cliente de id: " +CLIENTE_ID+" não encontrado."));

        RequestBuilder request = MockMvcRequestBuilders.get("/clientes/" + CLIENTE_ID)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);

        // Execução e Verificação
        mockMvc.perform(request)
                .andExpect(status().isNotFound())
                .andReturn();
    }
}
