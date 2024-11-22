package br.com.fiap.tc.gerenciamentoclientes_api.controller;

import br.com.fiap.tc.gerenciamentoclientes_api.application.controller.BuscarClienteController;
import br.com.fiap.tc.gerenciamentoclientes_api.application.controller.CadastrarClienteControlller;
import br.com.fiap.tc.gerenciamentoclientes_api.domain.entity.Cliente;
import br.com.fiap.tc.gerenciamentoclientes_api.domain.input.CadastrarClienteRequest;
import br.com.fiap.tc.gerenciamentoclientes_api.domain.mapper.ClienteDtoMapper;
import br.com.fiap.tc.gerenciamentoclientes_api.domain.output.ClienteResponse;
import br.com.fiap.tc.gerenciamentoclientes_api.domain.usecase.CadastrarClienteUseCase;
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
@WebMvcTest(CadastrarClienteControlller.class)
public class CadastrarClienteControlllerTest {

    @MockBean
    private ClienteDtoMapper clienteMapper;

    @MockBean
    private CadastrarClienteUseCase cadastrarClienteUseCase;

    @Autowired
    private MockMvc mockMvc;


    @Test
    @DisplayName("Deve cadastrar um cliente com sucesso")
    public void deveCadastrarClienteComSucesso() throws Exception {
        // Cenário
        CadastrarClienteRequest request = new CadastrarClienteRequest(
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

        Mockito.when(clienteMapper.toCliente(Mockito.any(CadastrarClienteRequest.class)))
                .thenReturn(clienteMock);
        Mockito.when(cadastrarClienteUseCase.cadastrarCliente(Mockito.any(Cliente.class)))
                .thenReturn(clienteMock);
        Mockito.when(clienteMapper.toClienteResponse(Mockito.any(Cliente.class)))
                .thenReturn(clienteResponseMock);

        String requestJson = new ObjectMapper().writeValueAsString(request);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/clientes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson)
                .accept(MediaType.APPLICATION_JSON);

        // Execução e Verificação
        mockMvc.perform(requestBuilder)
                .andExpect(status().isCreated())
                .andReturn();
    }
}