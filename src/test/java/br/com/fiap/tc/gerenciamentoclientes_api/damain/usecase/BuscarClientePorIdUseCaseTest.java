//package br.com.fiap.tc.gerenciamentoclientes_api.damain.usecase;
//
//
//import br.com.fiap.tc.gerenciamentoclientes_api.domain.entity.Cliente;
//import br.com.fiap.tc.gerenciamentoclientes_api.domain.exception.ClienteNotFoundException;
//import br.com.fiap.tc.gerenciamentoclientes_api.domain.gateway.BuscarClientePorIdInterface;
//import br.com.fiap.tc.gerenciamentoclientes_api.domain.usecase.BuscarClientePorIdUseCase;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mockito;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//
//@ExtendWith(SpringExtension.class)
//@SpringBootTest
//public class BuscarClientePorIdUseCaseTest {
//
//    @MockBean
//    private BuscarClientePorIdInterface buscarClientePorIdInterface;
//
//    @Test
//    @DisplayName("Deve buscar um cliente por ID com sucesso")
//    @Skipt
//    public void deveBuscarClientePorIdComSucesso() {
//        // Cenário
//        Long clienteId = 1L;
//        Cliente clienteMock = new Cliente(
//                clienteId,
//                "João Silva",
//                "joao.silva@example.com",
//                "11987654321",
//                "Rua das Flores",
//                "Centro",
//                "12345-678",
//                "Apto 101",
//                "100",
//                "SP",
//                "São Paulo"
//        );
//
//        Mockito.when(buscarClientePorIdInterface.buscarClientePorId(clienteId)).thenReturn(clienteMock);
//
//        BuscarClientePorIdUseCase buscarClientePorIdUseCase = new BuscarClientePorIdUseCase(buscarClientePorIdInterface);
//
//        // Execução
//        Cliente resultado = buscarClientePorIdUseCase.buscarClientePorId(clienteId);
//
//        // Verificação
//        assertEquals(clienteMock, resultado);
//    }
//
//    @Test
//    @DisplayName("Deve lançar ClienteNotFoundException quando cliente não for encontrado")
//    public void deveLancarClienteNotFoundExceptionQuandoClienteNaoForEncontrado() {
//        // Cenário
//        Long clienteId = 1L;
//
//        Mockito.when(buscarClientePorIdInterface.buscarClientePorId(clienteId)).thenReturn(null);
//
//        BuscarClientePorIdUseCase buscarClientePorIdUseCase = new BuscarClientePorIdUseCase(buscarClientePorIdInterface);
//
//        // Execução e Verificação
//        assertThrows(ClienteNotFoundException.class, () -> {
//            buscarClientePorIdUseCase.buscarClientePorId(clienteId);
//        });
//    }
//}