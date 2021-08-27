
package com.br.globo.signature.infra.extractor;

import com.br.globo.signature.infra.handler.response.ErrorResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Class comments go here...
 *
 * @author André Franco
 * @version 1.0 26/08/2021
 */
@Slf4j
@RequiredArgsConstructor
@Component
public class NotValidExceptionToErroRespondeExtractor implements Extractor<MethodArgumentNotValidException, ErrorResponse> {

    private final FiedToErroRespondeExtractor fiedToErroRespondeExtractor;

    @Override
    public ErrorResponse extract(final MethodArgumentNotValidException exception) {
        final Set<ErrorResponse> collect = exception
            .getBindingResult()
            .getFieldErrors()
            .stream()
            .map(fiedToErroRespondeExtractor::extract)
            .collect(Collectors.toSet());
        final ErrorResponse errorResponse = ErrorResponse
            .builder()
            .message("Dados enviados inválidos, verificar campos")
            .code(HttpStatus.BAD_REQUEST.value())
            .errors(collect)
            .build();
        log.info("Error response: {} ", errorResponse);
        return errorResponse;
    }

}
