package br.com.fiap.tc.gerenciamentoclientes_api.application.controller;


import br.com.fiap.tc.gerenciamentoclientes_api.domain.entity.Cliente;
import br.com.fiap.tc.gerenciamentoclientes_api.domain.mapper.ClienteDtoMapper;
import br.com.fiap.tc.gerenciamentoclientes_api.domain.output.ClienteResponse;
import br.com.fiap.tc.gerenciamentoclientes_api.domain.usecase.BuscarClientePorIdUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/clientes")
public class BuscarClienteController {

    private final ClienteDtoMapper clienteDtoMapper;
    private final BuscarClientePorIdUseCase buscarClientePorIdUseCase;

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponse>buscaCliente(@PathVariable Long id){
        Cliente clienteBuscado= buscarClientePorIdUseCase.buscarClientePorId(id);
        return ResponseEntity.ok(clienteDtoMapper.toClienteResponse(clienteBuscado));
    }


}
