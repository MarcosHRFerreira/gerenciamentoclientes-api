package br.com.fiap.tc.gerenciamentoclientes_api.domain.output;

public record ClienteResponse(
        Long clienteId,
        String nome,
        String email,
        String telefone,
        String logradouro,
        String bairro,
        String cep,
        String complemento,
        String numero,
        String uf,
        String cidade
) {
}
