package br.com.luque.patrimonio.domain.exception;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

import br.com.luque.patrimonio.domain.dto.ErrorDTO;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static Map<HttpStatus, String> msgErro = new HashMap<>();
    private static Map<Class<?>, HttpStatus> mapException = new HashMap<>();
    static {
        msgErro.put(HttpStatus.BAD_REQUEST, "A requisição foi mal formada ou omite atributos obrigatórios.");
        msgErro.put(HttpStatus.UNPROCESSABLE_ENTITY,"Requisição bem formada, mas houve falha na validação do conteúdo.");

        mapException.put(HttpMessageNotReadableException.class, HttpStatus.BAD_REQUEST);
        mapException.put(JsonParseException.class, HttpStatus.BAD_REQUEST);    
        mapException.put(MethodArgumentNotValidException.class, HttpStatus.BAD_REQUEST);
        
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> handleException(Exception exception) {
        ErrorDTO errorDTO = new ErrorDTO();
        HttpStatus httpStatus;
        String detail;

        if (exception instanceof ResponseStatusException) {
            ResponseStatusException rException = (ResponseStatusException) exception;
            httpStatus = rException.getStatus();
            detail = rException.getReason();
        } else {            
            httpStatus = mapException.get(exception.getClass());
            if (httpStatus == null){
                httpStatus = HttpStatus.NOT_IMPLEMENTED;
            }
            detail = exception.getMessage();
        }

        errorDTO.setCode(httpStatus.toString());
        errorDTO.setTitle(msgErro.get(httpStatus));
        errorDTO.setDetail(detail);        

        return new ResponseEntity<ErrorDTO>(errorDTO, httpStatus);
    }
}
