
package com.br.globo.signature.infra.extractor;


import com.br.globo.signature.infra.handler.response.ErrorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;

/**
 * Class comments go here...
 *
 * @author André Franco
 * @version 1.0 06/10/2020
 */
@RequiredArgsConstructor
@Component
public class FiedToErroRespondeExtractor implements Extractor<FieldError, ErrorResponse> {

    private final MessageSource messageSource;

    @Override
    public ErrorResponse extract(final FieldError extract) {
        final String message = messageSource.getMessage(extract, LocaleContextHolder.getLocale());
        final String field = extract.getField();
        final String objectName = extract.getObjectName();
        return ErrorResponse
            .builder()
            .message(message)
            .field(field)
            .shortMessage(String.format("class error: %s", objectName))
            .build();
    }

}
