package kg.aleksandrov.shop.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.util.stream.Collectors;

import static kg.aleksandrov.shop.constnats.ErrorMessages.BASIC;

@Slf4j
@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<String> handleException(UnifiedException e){
        log.error(e.getMessage(), e.getParam());
        return new ResponseEntity<>(String.format(e.getMessage(), e.getParam()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<String> handleException(RuntimeException e) {
        log.error(e.getMessage());
        return new ResponseEntity<>(BASIC, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<String> handleException(MethodArgumentNotValidException e){
        var errors = e.getFieldErrors().stream().limit(1).toList();
        var message = errors.stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining());
        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
