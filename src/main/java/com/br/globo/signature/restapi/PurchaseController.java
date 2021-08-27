/*
 * @(#)UserController.java 1.0 31/10/2020
 *
 * Copyright (c) 2020, PicPay S.A. All rights reserved.
 * PicPay S.A. proprietary/confidential. Use is subject to license terms.
 */

package com.br.globo.signature.restapi;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

/**
 * Class comments go here...
 *
 * @author André Franco
 * @version 1.0 26/08/2020
 */
@Slf4j
@Api(tags = "Envio Status de uma compra de assinatura")
@RestController
@RequestMapping(value = "purchases", produces = "application/json; charset=UTF-8")
@RequiredArgsConstructor
public class PurchaseController {

    @ApiOperation(value = "Receber o STATUS de uma compra")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 204, message = "No Content")
    })
    @GetMapping
    @ResponseStatus(OK)
    public List<String> findUserList() {
        log.info("lista");
        return List.of("Lista 1", "Lista 2");
    }


}
