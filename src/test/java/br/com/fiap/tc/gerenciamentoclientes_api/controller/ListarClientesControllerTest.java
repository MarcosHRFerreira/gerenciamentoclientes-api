package br.com.fiap.tc.gerenciamentoclientes_api.controller;

import br.com.fiap.tc.gerenciamentoclientes_api.application.controller.ListarClientesController;
import br.com.fiap.tc.gerenciamentoclientes_api.domain.entity.Cliente;
import br.com.fiap.tc.gerenciamentoclientes_api.domain.mapper.ClienteDtoMapper;
import br.com.fiap.tc.gerenciamentoclientes_api.domain.output.ClienteResponse;
import br.com.fiap.tc.gerenciamentoclientes_api.domain.usecase.ListarClientesUseCase;
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

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ListarClientesController.class)
public class ListarClientesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ListarClientesUseCase listarClientesUseCase;

    @MockBean
    private ClienteDtoMapper clienteDtoMapper;

    @Test
    @DisplayName("Deve listar clientes com sucesso")
    public void deveListarClientesComSucesso() throws Exception {
        // Cenário
        Cliente clienteMock = new Cliente(
                1L,
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
                1L,
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

        List<Cliente> clientes = Arrays.asList(clienteMock);
        List<ClienteResponse> clienteResponses = Arrays.asList(clienteResponseMock);

        Mockito.when(listarClientesUseCase.listarClientes()).thenReturn(clientes);
        Mockito.when(clienteDtoMapper.toClienteResponse(clienteMock)).thenReturn(clienteResponseMock);

        RequestBuilder request = MockMvcRequestBuilders.get("/clientes")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);

        // Execução e Verificação
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andReturn();
    }
}