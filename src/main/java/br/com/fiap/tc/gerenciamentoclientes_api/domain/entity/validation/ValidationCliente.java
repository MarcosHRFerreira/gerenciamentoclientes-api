package br.com.fiap.tc.gerenciamentoclientes_api.domain.entity.validation;

import br.com.fiap.tc.gerenciamentoclientes_api.domain.entity.Cliente;

public class ValidationCliente {

    private Cliente cliente;

    public ValidationCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void validar() throws IllegalArgumentException {
        validarNome();
        validarEmail();
        validarTelefone();
        validarLogradouro();
        validarBairro();
        validarCep();
        validarUf();
        validarCidade();
        validarNumero();
    }

    private void validarNome() {
        if (cliente.getNome() == null || cliente.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do cliente não pode ser vazio.");
        }
        if (cliente.getNome().length() <=3 || cliente.getNome().length()>200) {
            throw new IllegalArgumentException("O nome do cliente deve ter no mínimo 3 caracteres e no máximo 200.");
        }

    }

    private void validarEmail() {
        if (cliente.getEmail() == null || cliente.getEmail().trim().isEmpty()) {
            throw new IllegalArgumentException("O email do cliente não pode ser vazio.");
        }
        // Exemplo de uma validação simples de formato de email:
        if (!cliente.getEmail().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            throw new IllegalArgumentException("O email fornecido é inválido.");
        }
    }

    private void validarTelefone() {
        if (cliente.getTelefone() == null || cliente.getTelefone().trim().isEmpty()) {
            throw new IllegalArgumentException("O telefone do cliente não pode ser vazio.");
        }
        if (!cliente.getTelefone().matches("\\d+")) {
            throw new IllegalArgumentException("O telefone deve conter apenas números.");
        }
    }

    private void validarLogradouro() {
        if (cliente.getLogradouro() == null || cliente.getLogradouro().trim().isEmpty()) {
            throw new IllegalArgumentException("O logradouro do cliente não pode ser vazio.");
        }

        if (cliente.getLogradouro().length() <=3 || cliente.getLogradouro().length()>200) {
            throw new IllegalArgumentException("O logradouro do cliente deve ter no mínimo 3 caracteres e no máximo 200.");
        }
    }

    private void validarBairro() {
        if (cliente.getBairro() == null || cliente.getBairro().trim().isEmpty()) {
            throw new IllegalArgumentException("O bairro do cliente não pode ser vazio.");
        }

        if (cliente.getBairro().length() <=3 || cliente.getBairro().length()>200) {
            throw new IllegalArgumentException("O bairro do cliente deve ter no mínimo 3 caracteres e no máximo 200.");
        }
    }

    private void validarCep() {
        if (cliente.getCep() == null || cliente.getCep().trim().isEmpty()) {
            throw new IllegalArgumentException("O cep do cliente não pode ser vazio.");
        }

        if (!cliente.getCep().matches("^(\\d{5}-\\d{3}|\\d{8})$")) {
            throw new IllegalArgumentException("O CEP deve estar no formato válido (XXXXX-XXX ou XXXXXXXX).");
        }
    }

    private void validarUf() {
        if (cliente.getUf() == null || cliente.getUf().trim().isEmpty()) {
            throw new IllegalArgumentException("A uf do cliente não pode ser vazio.");
        }

        if (!cliente.getUf().matches("[A-Z]{2}")) {
            throw new IllegalArgumentException("A uf deve conter apenas letras (A-Z) e ter exatamente 2 caracteres.");
        }
    }

    private void validarCidade() {
        if (cliente.getCidade() == null || cliente.getCidade().trim().isEmpty()) {
            throw new IllegalArgumentException("O cidade do cliente não pode ser vazio.");
        }

        if (cliente.getCidade().length() <=3 || cliente.getCidade().length()>200) {
            throw new IllegalArgumentException("A cidade do cliente deve ter no mínimo 3 caracteres e no máximo 200.");
        }
    }

    private void validarNumero() {
        if (cliente.getNumero() == null || cliente.getNumero().trim().isEmpty()) {
            throw new IllegalArgumentException("O número do logradouro do cliente não pode ser vazio.");
        }

        if (cliente.getCidade().length() <=1 || cliente.getCidade().length()>15) {
            throw new IllegalArgumentException("A cidade do cliente deve ter no mínimo 3 caracteres e no máximo 15.");
        }
    }


}
