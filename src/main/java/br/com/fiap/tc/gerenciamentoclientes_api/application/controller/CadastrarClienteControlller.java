package br.com.fiap.tc.gerenciamentoclientes_api.application.controller;

import br.com.fiap.tc.gerenciamentoclientes_api.domain.entity.Cliente;
import br.com.fiap.tc.gerenciamentoclientes_api.domain.input.CadastrarClienteRequest;
import br.com.fiap.tc.gerenciamentoclientes_api.domain.mapper.ClienteDtoMapper;
import br.com.fiap.tc.gerenciamentoclientes_api.domain.output.ClienteResponse;
import br.com.fiap.tc.gerenciamentoclientes_api.domain.usecase.CadastrarClienteUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RequiredArgsConstructor
@RestController
@RequestMapping("/clientes")
public class CadastrarClienteControlller {

    private final ClienteDtoMapper clienteMapper;
    private final CadastrarClienteUseCase cadastrarClienteUseCase;

    @PostMapping
    public ResponseEntity<ClienteResponse> cadastrarCliente(@RequestBody CadastrarClienteRequest cadastrarClienteRequest) {

        Cliente cliente = clienteMapper.toCliente(cadastrarClienteRequest);

        Cliente clienteCadastrado = cadastrarClienteUseCase.cadastrarCliente(cliente);

        ClienteResponse clienteResponse = clienteMapper.toClienteResponse(clienteCadastrado);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(clienteResponse.clienteId())
                .toUri();

        return ResponseEntity.created(uri).body(clienteResponse);
    }


}
