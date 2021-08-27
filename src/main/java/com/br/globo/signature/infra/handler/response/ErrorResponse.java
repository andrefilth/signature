
package com.br.globo.signature.infra.handler.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Getter;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Set;

import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

/**
 * Class comments go here...
 *
 * @author André Franco
 * @version 1.0 06/10/2020
 */
@JsonPropertyOrder({"message", "code", "field", "short_message", "errors"})
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Builder
@Getter
public class ErrorResponse {

    private static final String DEFAULT_MESSAGE = "Ops! Ocorreu um erro inesperado.";
    @JsonProperty("short_message")
    private final String shortMessage;
    private final String message;
    private final int code;
    private final String field;
    private final Object data;
    private Set<ErrorResponse> errors;

    @Override
    public String toString() {
        return new ToStringBuilder(this, JSON_STYLE)
            .append("message", message)
            .append("code", code)
            .append("field", field)
            .append("shortMessage", shortMessage)
            .append("errors", errors)
            .build();
    }

}
