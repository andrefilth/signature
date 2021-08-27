
package com.br.globo.signature.infra.handler;

import com.br.globo.signature.infra.extractor.NotValidExceptionToErroRespondeExtractor;
import com.br.globo.signature.infra.handler.exception.notfound.NotFoundException;
import com.br.globo.signature.infra.handler.response.ErrorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.*;

/**
 * Class comments go here...
 *
 * @author André Franco
 * @version 1.0 26/08/2021
 */
@RequiredArgsConstructor
@RestControllerAdvice
public class ControllerAdviceHandler {

    private final NotValidExceptionToErroRespondeExtractor fiedToErroRespondeExtractor;


    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse handler(final MethodArgumentNotValidException exception) {

        return fiedToErroRespondeExtractor.extract(exception);
    }
    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ErrorResponse handler(final NotFoundException exception) {
        return exception.getErrorModel();
    }


}
