package br.com.fiap.tc.gerenciamentoclientes_api.damain.usecase;


import br.com.fiap.tc.gerenciamentoclientes_api.domain.entity.Cliente;
import br.com.fiap.tc.gerenciamentoclientes_api.domain.gateway.AtualizarClienteInterface;
import br.com.fiap.tc.gerenciamentoclientes_api.domain.usecase.AtualizarClienteUseCase;
import br.com.fiap.tc.gerenciamentoclientes_api.domain.usecase.BuscarClientePorIdUseCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class AtualizarClienteUseCaseTest {

    @MockBean
    private AtualizarClienteInterface atualizarClienteInterface;

    @MockBean
    private BuscarClientePorIdUseCase buscarClientePorIdUseCase;

    @Test
    @DisplayName("Deve atualizar um cliente com sucesso")
    public void deveAtualizarClienteComSucesso() {
        // Cenário
        Long clienteId = 1L;
        Cliente clienteExistente = new Cliente(
                clienteId,
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
        Cliente clienteAtualizado = new Cliente(
                clienteId,
                "João Silva Atualizado",
                "joao.silva.atualizado@example.com",
                "11987654322",
                "Rua das Rosas",
                "Centro",
                "12345-679",
                "Apto 102",
                "101",
                "SP",
                "São Paulo"
        );

        Mockito.when(buscarClientePorIdUseCase.buscarClientePorId(clienteId)).thenReturn(clienteExistente);
        Mockito.when(atualizarClienteInterface.atualizarCliente(clienteId, clienteExistente)).thenReturn(clienteAtualizado);

        AtualizarClienteUseCase atualizarClienteUseCase = new AtualizarClienteUseCase(atualizarClienteInterface, buscarClientePorIdUseCase);

        // Execução
        Cliente resultado = atualizarClienteUseCase.atualizarCliente(clienteId, clienteAtualizado);

        // Verificação
        assertEquals(clienteAtualizado.getNome(), resultado.getNome());
        assertEquals(clienteAtualizado.getEmail(), resultado.getEmail());
        assertEquals(clienteAtualizado.getTelefone(), resultado.getTelefone());
        assertEquals(clienteAtualizado.getLogradouro(), resultado.getLogradouro());
        assertEquals(clienteAtualizado.getBairro(), resultado.getBairro());
        assertEquals(clienteAtualizado.getCep(), resultado.getCep());
        assertEquals(clienteAtualizado.getComplemento(), resultado.getComplemento());
        assertEquals(clienteAtualizado.getNumero(), resultado.getNumero());
        assertEquals(clienteAtualizado.getUf(), resultado.getUf());
        assertEquals(clienteAtualizado.getCidade(), resultado.getCidade());
    }
}