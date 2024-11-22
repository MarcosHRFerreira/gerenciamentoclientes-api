package br.com.fiap.tc.gerenciamentoclientes_api.controller;

import br.com.fiap.tc.gerenciamentoclientes_api.application.controller.AtualizarClienteController;
import br.com.fiap.tc.gerenciamentoclientes_api.domain.entity.Cliente;
import br.com.fiap.tc.gerenciamentoclientes_api.domain.input.AtualizarClienteRequest;
import br.com.fiap.tc.gerenciamentoclientes_api.domain.mapper.ClienteDtoMapper;
import br.com.fiap.tc.gerenciamentoclientes_api.domain.output.ClienteResponse;
import br.com.fiap.tc.gerenciamentoclientes_api.domain.usecase.AtualizarClienteUseCase;
import com.fasterxml.jackson.databind.ObjectMapper;
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
@WebMvcTest(AtualizarClienteController.class)
public class AtualizarClienteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AtualizarClienteUseCase atualizarClienteUseCase;

    @MockBean
    private ClienteDtoMapper clienteDtoMapper;

    private static final Long CLIENTE_ID = 1L;

    @Test
    @DisplayName("Deve atualizar um cliente com sucesso")
    public void deveAtualizarClienteComSucesso() throws Exception {
        // Cenário
        AtualizarClienteRequest request = new AtualizarClienteRequest(
                null,
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

        Mockito.when(clienteDtoMapper.toCliente(Mockito.any(AtualizarClienteRequest.class))).thenReturn(clienteMock);
        Mockito.when(atualizarClienteUseCase.atualizarCliente(Mockito.eq(CLIENTE_ID), Mockito.any(Cliente.class))).thenReturn(clienteMock);
        Mockito.when(clienteDtoMapper.toClienteResponse(Mockito.any(Cliente.class))).thenReturn(clienteResponseMock);

        String requestJson = new ObjectMapper().writeValueAsString(request);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .put("/clientes/" + CLIENTE_ID)
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson)
                .accept(MediaType.APPLICATION_JSON);

        // Execução e Verificação
        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andReturn();
    }
}