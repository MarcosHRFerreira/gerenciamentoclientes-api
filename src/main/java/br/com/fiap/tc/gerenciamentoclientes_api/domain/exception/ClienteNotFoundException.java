package br.com.fiap.tc.gerenciamentoclientes_api.domain.exception;

public class ClienteNotFoundException extends RuntimeException {
    public ClienteNotFoundException(String message) {
        super(message);
    }
}