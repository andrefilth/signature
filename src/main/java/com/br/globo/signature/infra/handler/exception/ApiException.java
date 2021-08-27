
package com.br.globo.signature.infra.handler.exception;

import com.br.globo.signature.infra.handler.response.ErrorResponse;
import lombok.Getter;

/**
 * Classe criada para poder customizar o retorno sem impactar outros serviços
 */
public abstract class ApiException extends RuntimeException {

    @Getter
    private final int code;

    @Getter
    private String shortMessage;

    protected ApiException(String msg, int code, String shortMessage) {
        super(msg);
        this.code = code;
        this.shortMessage = shortMessage;
    }


    public ErrorResponse getErrorModel() {
        return ErrorResponse.builder().code(this.code).message(this.getMessage()).shortMessage(this.getShortMessage()).build();
    }

}

