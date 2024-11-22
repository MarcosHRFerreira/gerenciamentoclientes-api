package br.com.fiap.tc.gerenciamentoclientes_api.damain.usecase;

import br.com.fiap.tc.gerenciamentoclientes_api.domain.entity.Cliente;
import br.com.fiap.tc.gerenciamentoclientes_api.infra.adapter.repository.ListarClienteAdapter;
import br.com.fiap.tc.gerenciamentoclientes_api.infra.entity.ClienteEntity;
import br.com.fiap.tc.gerenciamentoclientes_api.infra.repository.ClienteRepository;
import br.com.fiap.tc.gerenciamentoclientes_api.infra.repository.mapper.ClienteEntityMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ListarClienteAdapterTest {

    @Autowired
    private ListarClienteAdapter listarClienteAdapter;

    @MockBean
    private ClienteRepository clienteRepository;

    @MockBean
    private ClienteEntityMapper clienteEntityMapper;

    @Test
    @DisplayName("Deve listar clientes com sucesso")
    public void deveListarClientesComSucesso() {

        ClienteEntity cli = new ClienteEntity(
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

        Mockito.when(clienteRepository.findAll()).thenReturn(List.of(cli));
        Mockito.when(clienteEntityMapper.toClienteResponse(Mockito.any())).thenReturn(clienteMock);

        // Execução
        List<Cliente> resultado = listarClienteAdapter.listarClientes();

        // Verificação
        assertEquals(1, resultado.size());
        assertEquals(clienteMock, resultado.get(0));
    }
}