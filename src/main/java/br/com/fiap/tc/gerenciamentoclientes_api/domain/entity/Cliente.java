package br.com.fiap.tc.gerenciamentoclientes_api.domain.entity;

import br.com.fiap.tc.gerenciamentoclientes_api.domain.entity.validation.EmailValidator;

public class Cliente {

    private Long clienteId;
    private String nome;
    private String email;
    private String telefone;
    private String logradouro;
    private String bairro;
    private String cep;
    private String complemento;
    private String numero;
    private String uf;
    private String cidade;


    public Cliente(Long clienteId,
                   String nome,
                   String email,
                   String telefone,
                   String logradouro,
                   String bairro,
                   String cep,
                   String complemento,
                   String numero,
                   String uf,
                   String cidade) {
        if(nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser nulo ou vazio");
        }
        if(email == null || email.isEmpty() || !EmailValidator.isValid(email)) {
            throw new IllegalArgumentException("Email deve ser válido");
        }
        if(telefone == null || telefone.isEmpty() ) {
            throw new IllegalArgumentException("Telefone não pode ser nulo ou vazio");
        }
        if(logradouro == null || logradouro.isEmpty() ) {
            throw new IllegalArgumentException("Logradouro não pode ser nulo ou vazio");
        }
        if(bairro == null || bairro.isEmpty() ) {
            throw new IllegalArgumentException("Bairro não pode ser nulo ou vazio");
        }
        if(cep == null || cep.isEmpty() ) {
            throw new IllegalArgumentException("Cep não pode ser nulo ou vazio");
        }
        if(uf == null || uf.isEmpty() ) {
            throw new IllegalArgumentException("Uf não pode ser nulo ou vazio");
        }
        if(uf.length() > 2 ) {
            throw new IllegalArgumentException("Uf inválida");
        }

        if(cidade == null || cidade.isEmpty() ) {
            throw new IllegalArgumentException("Cidade não pode ser nulo ou vazio");
        }


        this.clienteId=clienteId;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.logradouro=logradouro;
        this.bairro=bairro;
        this.cep=cep;
        this.complemento=complemento;
        this.numero=numero;
        this.uf=uf;
        this.cidade=cidade;

    }

    public Cliente() {
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

}
