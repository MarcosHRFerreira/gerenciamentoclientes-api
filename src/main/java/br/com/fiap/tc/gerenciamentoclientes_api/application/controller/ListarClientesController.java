package br.com.fiap.tc.gerenciamentoclientes_api.application.controller;


import br.com.fiap.tc.gerenciamentoclientes_api.domain.entity.Cliente;
import br.com.fiap.tc.gerenciamentoclientes_api.domain.mapper.ClienteDtoMapper;
import br.com.fiap.tc.gerenciamentoclientes_api.domain.output.ClienteResponse;
import br.com.fiap.tc.gerenciamentoclientes_api.domain.usecase.ListarClientesUseCase;
import br.com.fiap.tc.gerenciamentoclientes_api.infra.repository.mapper.ClienteEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/clientes")
public class ListarClientesController {

    private final ClienteEntityMapper clienteEntityMapper;
    private final ListarClientesUseCase listarClientesUseCase;
    private final ClienteDtoMapper clienteDtoMapper;

    @GetMapping
    public ResponseEntity<List<ClienteResponse>>listarClientes(){
        List<Cliente> clientes = listarClientesUseCase.listarClientes();
        List<ClienteResponse> listaClienteResponse = clientes.stream().map(clienteDtoMapper::toClienteResponse).toList();

        return ResponseEntity.ok(listaClienteResponse);

    }

}
