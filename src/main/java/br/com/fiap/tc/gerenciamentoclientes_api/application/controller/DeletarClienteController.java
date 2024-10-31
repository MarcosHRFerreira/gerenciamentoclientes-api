package br.com.fiap.tc.gerenciamentoclientes_api.application.controller;


import br.com.fiap.tc.gerenciamentoclientes_api.domain.output.ClienteDeletadoResponse;
import br.com.fiap.tc.gerenciamentoclientes_api.domain.usecase.DeletarClienteUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/clientes")
public class DeletarClienteController {

    private final DeletarClienteUseCase deletarClienteUseCase;

    @DeleteMapping("/{id}")
    public ResponseEntity<ClienteDeletadoResponse>deletarCliente(@PathVariable Long id){

        boolean clienteFoiDeletado= deletarClienteUseCase.deletarCliente(id);
        return ResponseEntity.ok(new ClienteDeletadoResponse(clienteFoiDeletado));

    }


}
