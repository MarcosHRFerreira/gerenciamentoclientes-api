package br.com.fiap.tc.gerenciamentoclientes_api.application.handler;

import br.com.fiap.tc.gerenciamentoclientes_api.application.handler.exception.ErroCustomizado;
import br.com.fiap.tc.gerenciamentoclientes_api.domain.exception.ClienteNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ClienteNotFoundException.class)
    public ResponseEntity<ErroCustomizado> handleUsuarioNotFoundException(ClienteNotFoundException ex, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        ErroCustomizado erro = new ErroCustomizado(
                Instant.now(),
                ex.getMessage(),
                status.value(),
                request.getRequestURI()
        );

        return new ResponseEntity<>(erro, status);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErroCustomizado> handleIllegalArgumentException(IllegalArgumentException ex, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ErroCustomizado erro = new ErroCustomizado(
                Instant.now(),
                ex.getMessage(),
                status.value(),
                request.getRequestURI()
        );

        return new ResponseEntity<>(erro, status);
    }

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<ErroCustomizado> handleIllegalStateException(IllegalStateException ex, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ErroCustomizado erro = new ErroCustomizado(
                Instant.now(),
                ex.getMessage(),
                status.value(),
                request.getRequestURI()
        );

        return new ResponseEntity<>(erro, status);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErroCustomizado> handleNullPointerException(NullPointerException ex, HttpServletRequest request) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR; // ou outro status que você considere apropriado
        ErroCustomizado erro = new ErroCustomizado(
                Instant.now(),
                "Um erro inesperado ocorreu: " + ex.getMessage(), // Mensagem personalizada
                status.value(),
                request.getRequestURI()
        );

        return new ResponseEntity<>(erro, status);
    }

}
