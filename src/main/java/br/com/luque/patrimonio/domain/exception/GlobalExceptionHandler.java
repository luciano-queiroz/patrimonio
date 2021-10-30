package br.com.luque.patrimonio.domain.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;
import br.com.luque.patrimonio.domain.dto.ErrorDTO;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static Map<HttpStatus, String> msgErro = new HashMap<>();
    static {
        msgErro.put(HttpStatus.BAD_REQUEST, "A requisição foi mal formada ou omite atributos obrigatórios");
        msgErro.put(HttpStatus.FORBIDDEN, "Acesso não autorizado");
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ErrorDTO> handleException(ResponseStatusException error) {
        ErrorDTO errorDTO = ErrorDTO.builder()
                .code(HttpStatus.BAD_REQUEST.toString())
                .title(msgErro.get(HttpStatus.BAD_REQUEST))
                .detail(error.getReason())
                .build();

        return new ResponseEntity<ErrorDTO>(errorDTO, HttpStatus.BAD_REQUEST);
    }
}
