package br.com.fiap.tc.gerenciamentoclientes_api.application.controller;


import br.com.fiap.tc.gerenciamentoclientes_api.domain.entity.Cliente;
import br.com.fiap.tc.gerenciamentoclientes_api.domain.input.AtualizarClienteRequest;
import br.com.fiap.tc.gerenciamentoclientes_api.domain.mapper.ClienteDtoMapper;
import br.com.fiap.tc.gerenciamentoclientes_api.domain.output.ClienteResponse;
import br.com.fiap.tc.gerenciamentoclientes_api.domain.usecase.AtualizarClienteUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/clientes")
public class AtualizarClienteController {

    private final ClienteDtoMapper clienteDtoMapper;
    private final AtualizarClienteUseCase atualizarClienteUseCase;

    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponse>atualizarUsuario(@PathVariable Long id,
                                                           @RequestBody AtualizarClienteRequest clienteRequest){
        Cliente clienteAtualizado = atualizarClienteUseCase.atualizarCliente(id,clienteDtoMapper.toCliente(clienteRequest));

        ClienteResponse clienteResponse=clienteDtoMapper.toClienteResponse(clienteAtualizado);

        return ResponseEntity.ok(clienteResponse);

    }

}
