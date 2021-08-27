/*
 * @(#)NotFoundException.java 1.0 31/10/2020
 *
 * Copyright (c) 2020, PicPay S.A. All rights reserved.
 * PicPay S.A. proprietary/confidential. Use is subject to license terms.
 */

package com.br.globo.signature.infra.handler.exception.notfound;


import com.br.globo.signature.infra.handler.exception.ApiException;
import org.springframework.http.HttpStatus;

/**
 * Class comments go here...
 *
 * @author André Franco
 * @version 1.0 16/10/2020
 */
public  abstract class NotFoundException extends ApiException {

    private static final int HTTP_404 = HttpStatus.NOT_FOUND.value();

    protected NotFoundException(final String msg) {
        super(msg, HTTP_404, "");
    }

    protected NotFoundException(final String msg, final String shortMessage) {
        super(msg, HTTP_404, shortMessage);
    }

}
