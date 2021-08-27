package com.br.globo.signature.restapi;

import com.br.globo.signature.BaseIntegrationTest;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static com.br.globo.signature.restapi.utils.PurchaseControllerIntegrationTestUtil.requestLogin;
import static org.hamcrest.Matchers.notNullValue;


/**
 * Class comments go here...
 *
 * @author André Franco
 * @version 1.0 26/08/2021
 */
@ExtendWith(SpringExtension.class)
class PurchaseControllerIntegrationTest extends BaseIntegrationTest {


    @DisplayName("TESTE 1")
    @Test
    public void test_should_login_sucess(){


        final ValidatableResponse response = requestLogin().log().all();
        response
                .statusCode(200)

        ;
    }

}