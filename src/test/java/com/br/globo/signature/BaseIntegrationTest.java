
package com.br.globo.signature;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static io.restassured.RestAssured.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

/**
 * Class comments go here...
 *
 * @author André Franco
 * @version 1.0 26/08/2021
 */
@ActiveProfiles("test")
@SpringBootTest(webEnvironment = RANDOM_PORT)
abstract public class BaseIntegrationTest {

    public static final String path = "/api/signature";
    @Value("http://localhost:${local.server.port}")
    protected String baseUri;

    @BeforeEach
    public void init(){
        baseURI = baseUri;
        basePath = path;
        enableLoggingOfRequestAndResponseIfValidationFails();
        // deleteAllDataBases


    }


}
